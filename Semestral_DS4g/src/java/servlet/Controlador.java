/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import entidades.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import procesos.*;

/**
 *
 * @author manue
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {
    
    public static Usuario usuarioLogeado = new Usuario();
    
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
            
            
            if (!usuario.getCorreo().equals("") && !usuario.getPassword().equals("") && !usuario.getNombre().equals("") && !usuario.getApellido().equals("") && !usuario.getCedula().equals("")) {
                
                if (Registrar.revisarExistencia(usuario.getCorreo(),usuario.getCedula())) {
                    mensajeAviso = "El correo ingresado o la cedula ingresada ya tiene un usuario. Reintente.";
                } else {
                    
                    try {
                        Registrar.insertarUsuario(usuario);
                        mensajeAviso = "Se ha registrado exitosamente.";
                    } catch (SQLException ex) {
                        mensajeAviso = "Error al registrar.\nValide que la cedula sigue un formato adecuado y el correo tambien.";
                    }
                    
                }
                
            } else {
                mensajeAviso = "Llene todos los campos.";
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
                
                if (usuarioLogeado != null) {
                    
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
            
            Sesion.cerrar(usuarioLogeado);
            ventanaAMostrar = "iniciarsesion.jsp";
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
