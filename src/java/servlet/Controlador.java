/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import entidades.Examen;
import entidades.Examen.Respuesta;
import entidades.Grupo;
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
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
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
    public static Tema temaIngresado = new Tema();
    public static Grupo grupoSeleccionado = new Grupo();
    public static String buscando = "";
    LocalDate dt = LocalDate.now();
    LocalTime lt = LocalTime.now();

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

        //reportar.jsp
        if (accion.equals("Reportar")) {

            if (!request.getParameter("nombre").equals("") && !request.getParameter("correo").equals("") && !request.getParameter("mensaje").equals("")) {
                mensajeAviso = "Reporte Enviado!";
            } else {
                mensajeAviso = "Llene todos los campos antes de enviar el reporte";
            }

            request.setAttribute("avisoReporte", mensajeAviso);
            ventanaAMostrar = "reportar.jsp";
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
        if (accion.equals("Finalizar Registro")) {
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

        //Finalizar Examen
        if (accion.equals("Finalizar")) {

            Examen examen = new Examen();
            Respuesta r = new Respuesta();
            String cod_tema = request.getParameter("cod_tema");
            examen.setCod_tema(cod_tema);
            examen.setCorr_est(usuarioLogeado.getCorreo());
            examen.cargarPreguntas();
            examen.cargarRespuestas();
            Object cod_preguntas[] = examen.getPreguntas().keySet().toArray();
            int i = 0;
            Map<String, Respuesta> respuestas = examen.buscarRespuestasCorrectas();
            mensajeAviso = "Retroalimentacion<br>";
            while (i < cod_preguntas.length) {
                String cod_pregunta = cod_preguntas[i].toString();

                String date = dt.format(DateTimeFormatter.ISO_DATE) + "T" + lt;

                if (respuestas.get(cod_pregunta).getIdent_opcion().equals(request.getParameter("respuesta" + cod_pregunta))) {
                    Examen.subirIntento(usuarioLogeado.getCorreo(), cod_pregunta, "1", date);
                } else {
                    Examen.subirIntento(usuarioLogeado.getCorreo(), cod_pregunta, "0", date);
                }
                r = Examen.buscarRespuesta(cod_pregunta, request.getParameter("respuesta" + cod_pregunta));
                mensajeAviso += "Pregunta " + (i + 1) + ": " + r.getRetroalimentacion() + "<br>";
                i++;
            }

            ventanaAMostrar = "descripcion.jsp";
            request.setAttribute("avisoIntento", mensajeAviso);
        }

        //Rankings
        if (accion.equals("Rankings")) {
            ventanaAMostrar = "ranking.jsp";
        }

        //Administrar Grupo
        if (accion.equals("Administrar Grupo")) {
            System.out.println(request.getParameter("cod_grupo"));
            grupoSeleccionado = Grupo.buscarGrupo(request.getParameter("cod_grupo"));
            ventanaAMostrar = "administrarGrupo.jsp";
        }

        //Administrar Tema
        if (accion.equals("Administrar Tema")) {
            temaIngresado = Tema.buscarPorCodigo(request.getParameter("cod_tema"));
            ventanaAMostrar = "modificarTema.jsp";
        }

        //Crear Nuevo Grupo
        if (accion.equals("Crear Nuevo Grupo")) {
            ventanaAMostrar = "crearGrupo.jsp";
        }

        //Crear Nuevo Tema
        if (accion.equals("Crear Nuevo Tema")) {
            ventanaAMostrar = "crearTema.jsp";
        }

        //Crear Grupo
        if (accion.equals("Crear Grupo")) {

            Grupo grupo = new Grupo();
            grupo.setCod_grupo(request.getParameter("cod_grupo"));
            grupo.setCorreo_maestro(request.getParameter("correo_maestro"));

            if (!grupo.getCod_grupo().equals("") && !grupo.getCorreo_maestro().equals("") && !request.getParameter("nivel").equals("")) {

                try {

                    grupo.setNivel(Integer.parseInt(request.getParameter("nivel")));

                    if (grupo.getNivel() > 0) {

                        grupo.crearGrupo();
                        mensajeAviso = "Grupo creado exitosamente.";
                        ventanaAMostrar = "adminProf.jsp";

                    } else {
                        mensajeAviso = "Error, ingrese un nivel mayor a cero.";
                        ventanaAMostrar = "crearGrupo.jsp";
                    }

                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                    mensajeAviso = "Error, verifique los datos y reintente.";
                    ventanaAMostrar = "crearGrupo.jsp";
                } catch (NumberFormatException ex) {
                    mensajeAviso = "Error, en el nivel solo puede ingresar numeros enteros";
                    ventanaAMostrar = "crearGrupo.jsp";
                }

            } else {
                mensajeAviso = "Debe llenar todos los campos.";
                ventanaAMostrar = "crearGrupo.jsp";
            }

            request.setAttribute("avisoGrupo", mensajeAviso);
        }

        //Crear Tema
        if (accion.equals("Crear Tema")) {

            Tema tema = new Tema();

            if (!request.getParameter("cod_tema").equals("") && !request.getParameter("titulo").equals("") && !request.getParameter("contenido").equals("") && !request.getParameter("imagen").equals("")) {

                tema.setCodTema(request.getParameter("cod_tema"));
                tema.setContenido(request.getParameter("contenido"));
                tema.setImagen(request.getParameter("imagen"));
                tema.setTitulo(request.getParameter("titulo"));

                try {
                    tema.crearTema();
                    mensajeAviso = "Tema creado exitosamente.";
                    ventanaAMostrar = "administrarGrupo.jsp";
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                    mensajeAviso = "Error, verifique los datos y reintente.";
                    ventanaAMostrar = "crearTema.jsp";
                }

            } else {
                mensajeAviso = "Debe llenar todos los campos primero.";
                ventanaAMostrar = "crearTema.jsp";
            }

            request.setAttribute("avisoTema", mensajeAviso);
        }

        //Actualizar Tema
        if (accion.equals("Actualizar Tema")) {
            Tema tema = new Tema();

            if (!request.getParameter("titulo").equals("") && !request.getParameter("contenido").equals("") && !request.getParameter("imagen").equals("")) {

                tema.setCodTema(request.getParameter("cod_tema"));
                tema.setContenido(request.getParameter("contenido"));
                tema.setImagen(request.getParameter("imagen"));
                tema.setTitulo(request.getParameter("titulo"));

                try {
                    tema.actualizarTema();
                    mensajeAviso = "Tema actualizado exitosamente.";
                    ventanaAMostrar = "administrarGrupo.jsp";
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                    mensajeAviso = "Error, verifique los datos y reintente.";
                    ventanaAMostrar = "modificarTema.jsp";
                }

            } else {
                mensajeAviso = "Debe llenar todos los campos primero.";
                ventanaAMostrar = "modificarTema.jsp";
            }

            request.setAttribute("avisoTema", mensajeAviso);
        }

        //Buscar tema
        if (accion.equals("Buscar Tema")) {

            if (!request.getParameter("busqueda").equals("")) {
                buscando = request.getParameter("busqueda");
                String grupo = usuarioLogeado.getGrupo() + "-";
                if (Tema.buscarCoincidencia(buscando, Tema.generarListaTemasEst(Controlador.usuarioLogeado.getGrupo())).isEmpty()) {
                    mensajeAviso = "No hubo coincidencias.";
                }

            } else {
                mensajeAviso = "Llene el campo de busqueda antes de buscar.";
            }
            request.setAttribute("avisoBusqueda", mensajeAviso);
            ventanaAMostrar = "buscar.jsp";
        }
        
        //Eliminar tema
        if (accion.equals("Eliminar Tema")) {
            Tema.eliminarTema(request.getParameter("cod_tema"));
            
            mensajeAviso = "Tema borrado exitosamente.";
            request.setAttribute("avisoTema", mensajeAviso);
            ventanaAMostrar = "administrarGrupo.jsp";
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
