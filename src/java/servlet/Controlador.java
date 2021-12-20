/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import entidades.Tema;
import entidades.Usuario;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import procesos.*;

/**
 *
 * @author manue
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    public static Usuario usuarioLogeado = new Usuario();
    public static Tema temaIngresado = new Tema();

    private Usuario usuario = new Usuario();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion");
        String ventanaAMostrar = "", mensajeAviso = "", correo = "", pass = "";

        //contacto.jsp
        if (accion.equals("Contactar")) {

            if (!request.getParameter("nombre").equals("") && !request.getParameter("correo").equals("") && !request.getParameter("mensaje").equals("")) {
                mensajeAviso = "Mensaje Enviado!";
            } else {
                mensajeAviso = "Llene todos los campos antes de enviar el mensaje";
            }

            request.setAttribute("avisoContacto", mensajeAviso);
            ventanaAMostrar = "contacto.jsp";
        }

        //registro.jsp
        if (accion.equals("Registrarse")) {

            usuario.setCorreo(request.getParameter("correo"));
            usuario.setCedula(request.getParameter("cedula"));
            usuario.setPassword(request.getParameter("pass"));
            usuario.setNombre(request.getParameter("nombre"));
            usuario.setApellido(request.getParameter("apellido"));

            if (request.getParameter("seleccion").equals("maestro")) {
                usuario.setEsProfesor(true);
            }

            if (!usuario.getCorreo().equals("") && !usuario.getPassword().equals("") && !usuario.getNombre().equals("") && !usuario.getApellido().equals("") && !usuario.getCedula().equals("")) {

                if (Registrar.revisarExistencia(usuario.getCorreo(), usuario.getCedula())) {
                    mensajeAviso = "El correo ingresado o la cedula ingresada ya tiene un usuario. Reintente.";
                    ventanaAMostrar = "registro.jsp";
                } else {
                    ventanaAMostrar = "registro2.jsp";
                }

            } else {
                mensajeAviso = "Llene todos los campos.";
            }
            request.setAttribute("avisoRegistro", mensajeAviso);
        }

        //Registrar2
        if (accion.equals("Finalizar")) {
            String query;
            try {
                
                Registrar.insertarUsuario(usuario);
                
                if (usuario.esProfesor()) {
                    Connection cn = null;
                    Statement stmt = null;
                    try {

                        cn = BaseDeDatos.conectar();
                        stmt = cn.createStatement();
                        query = "INSERT INTO Maestro VALUES ('"
                                + usuario.getCorreo() + "','"
                                + request.getParameter("seleccion") + "')";
                        
                        stmt.executeUpdate(query);
                        
                    } catch (SQLException e) {
                        System.out.println("Error: " + e);
                        mensajeAviso = e.getMessage();
                        ventanaAMostrar = "registro.jsp";
                    } finally {
                        BaseDeDatos.cerrarConexiones(cn, stmt);
                    }

                } else {
                    Connection cn = null;
                    Statement stmt = null;
                    try {
                        cn = BaseDeDatos.conectar();
                        stmt = cn.createStatement();
                        query = "INSERT INTO Estudiante VALUES ('"
                                + usuario.getCorreo() + "','"
                                + request.getParameter("seleccion") + "')";
                        
                        stmt.executeUpdate(query);
                        
                    } catch (SQLException e) {
                        System.out.println("Error: " + e);
                        mensajeAviso = e.getMessage();
                        ventanaAMostrar = "registro.jsp";
                    } finally {
                        BaseDeDatos.cerrarConexiones(cn, stmt);
                    }

                }
                mensajeAviso = "Usuario registrado exitosamente.";
            } catch (SQLException ex) {
                mensajeAviso = "Error al registrar.\nValide que la cedula sigue un formato adecuado y el correo tambien.";
            }

            request.setAttribute("avisoRegistro", mensajeAviso);
            ventanaAMostrar = "registro.jsp";
        }

        //iniciarsesion.jsp
        if (accion.equals("Iniciar Sesion")) {

            correo = request.getParameter("correo");
            pass = request.getParameter("pass");

            if (!correo.equals("") && !pass.equals("")) {

                usuarioLogeado = Sesion.iniciar(correo, pass);

                if (!usuarioLogeado.getApellido().equals("")) {

                    if (usuarioLogeado.esProfesor()) {
                        ventanaAMostrar = "adminProf.jsp";
                    } else {
                        ventanaAMostrar = "adminEst.jsp";
                    }

                } else {
                    mensajeAviso = "Credenciales incorrectas. Reintente.";
                    ventanaAMostrar = "iniciarsesion.jsp";
                }

            } else {
                mensajeAviso = "Rellene todos los campos. Reintente.";
                ventanaAMostrar = "iniciarsesion.jsp";
            }

            request.setAttribute("avisoSesion", mensajeAviso);
        }

        //Cerrar Sesion
        if (accion.equals("Cerrar Sesion")) {

            usuarioLogeado = new Usuario();
            ventanaAMostrar = "index.jsp";
        }

        //Ingresar_Tema
        if (accion.contains("Ingresar")) {

            temaIngresado = Tema.buscarPorCodigo(request.getParameter("cod_tema"));
            ventanaAMostrar = "descripcion.jsp";
        }

        //Aprendizaje
        if (accion.contains("Aprender")) {
            ventanaAMostrar = "aprendizaje.jsp";
        }
        
        //Hacer Examen
        if (accion.equals("Hacer Examen")) {
            ventanaAMostrar = "jugabilidad.jsp";
        }

        RequestDispatcher ventana = request.getRequestDispatcher(ventanaAMostrar);
        ventana.forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
