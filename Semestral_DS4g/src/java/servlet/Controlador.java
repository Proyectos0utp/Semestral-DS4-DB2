/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidades.*;
import javax.servlet.RequestDispatcher;
import procesos.*;

/**
 *
 * @author manue
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {
    
    public static Usuario usuarioLogeado = new Usuario();
    private Registrar registrar = new Registrar();
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
        String ventanaAMostrar = "";
        
        //contacto.jsp
        if (accion.equals("Contactar")) {
           
            if (!request.getParameter("nombre").equals("") && !request.getParameter("correo").equals("") && !request.getParameter("mensaje").equals("")) {
                request.setAttribute("avisoContacto", "Mensaje Enviado!");
            } else {
                request.setAttribute("avisoContacto", "Llene todos los campos antes de enviar el mensaje");
            }
            
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
                
                if (registrar.revisarExistencia(usuario.getCorreo(),usuario.getCedula())) {
                    request.setAttribute("avisoRegistro", "El correo ingresado o la cedula ingresada ya tiene un usuario. Reintente.");
                } else {
                    registrar.insertarUsuario(usuario);
                    request.setAttribute("avisoRegistro", "Se ha registrado exitosamente.");
                }
                
            } else {
                request.setAttribute("avisoRegistro", "Llene todos los campos.");
            }
            
            ventanaAMostrar = "registro.jsp";
            
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
