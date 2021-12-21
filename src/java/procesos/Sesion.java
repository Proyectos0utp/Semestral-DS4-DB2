/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

import entidades.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jotaz
 */
public class Sesion {

    public static Usuario iniciar(String correo, String pass) {
        Usuario usuario = new Usuario();
        
        Connection conn1 = null, conn2 = null, conn3 = null, conn4 = null;
        Statement stmt1 = null, stmt2 = null, stmt3 = null, stmt4 = null;
        ResultSet rs1 = null, rs2 = null, rs3 = null, rs4 = null; 
        
        try {
            conn1 = BaseDeDatos.conectar();
            stmt1 = conn1.createStatement();
            String query = "SELECT * FROM Usuario WHERE correo = '" + correo + "' AND contraseña = '" + pass + "'";
            rs1 = stmt1.executeQuery(query);
            
            if (rs1.next()) {
                
                usuario.setCorreo(correo);
                usuario.setCedula(rs1.getString("cedula"));
                usuario.setNombre(rs1.getString("nombre"));
                usuario.setApellido(rs1.getString("apellido"));
                usuario.setPassword(pass);
                
                
                //Una vez es encontrado el usuario, se busca si es profesor o estudiante
                try {
                    conn2 = BaseDeDatos.conectar();
                    stmt2 = conn2.createStatement();
                    query = "SELECT * FROM Maestro WHERE correo_usuario = '" + correo +"'";
                    rs2 = stmt2.executeQuery(query);

                    if (rs2.next()) {
                        
                        try {
                            conn3 = BaseDeDatos.conectar();
                            stmt3 = conn3.createStatement();
                            query = "SELECT * FROM Grupo WHERE correo_maestro = '" + correo +"'";
                            rs3 = stmt3.executeQuery(query);

                            if (rs3.next()) {
                                usuario.setGrupo(rs3.getString("cod_grupo"));
                                usuario.setEsProfesor(true);
                            }
    
                        } catch (SQLException e) {
                            System.out.println(e.getMessage());
                        } finally {
                            BaseDeDatos.cerrarConexiones(conn3, stmt3, rs3);
                        }
                        
                    } else {
                        
                        try {
                            conn4 = BaseDeDatos.conectar();
                            stmt4 = conn4.createStatement();
                            query = "SELECT * FROM Estudiante WHERE correo_usuario = '" + correo +"'";
                            rs4 = stmt4.executeQuery(query);

                            if (rs4.next()) {
                                usuario.setGrupo(rs4.getString("cod_grupo"));
                                usuario.setEsProfesor(false);
                            }

                                
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        } finally {
                            BaseDeDatos.cerrarConexiones(conn4, stmt4, rs4);
                        }
                        
                    }

                        
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                } finally {
                    BaseDeDatos.cerrarConexiones(conn2, stmt2, rs2);
                }
                
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            BaseDeDatos.cerrarConexiones(conn1, stmt1, rs1);
        }
        
        return usuario;
    }
    
    public static String generarMenuHTML(Usuario usuario){
        
        String html, inicio;
        
        if(!usuario.getApellido().equals("")){
        
            inicio = (usuario.esProfesor()) ? "adminProf.jsp" : "adminEst.jsp";
            
            html = ""
                    + "<nav class=\"navbar navbar-light align-items-start sidebar sidebar-dark accordion bg-gradient-primary p-0\">"
                    + "<div class=\"container-fluid d-flex flex-column p-0\">"
                    + "<hr style=\"color: rgba(255,255,255,0);\"><a class=\"navbar-brand text-center d-flex justify-content-center align-items-center sidebar-brand m-0\" href=\"#\">" + "<img class=\"img-fluid\" src=\"assets/img/utp_logo_small.png\"></a>"
                    + "<hr class=\"sidebar-divider my-0\">"
                    + "<ul class=\"navbar-nav text-light\" id=\"accordionSidebar\">"
                    + "<li class=\"nav-item\"><a class=\"nav-link\" href=\"" + inicio + "\"><span class=\"text-dark\" style=\"font-size: 20px;\">Inicio</span></a></li>"
                    + "<li class=\"nav-item\"><a class=\"nav-link\" href=\"iniciarsesion.jsp\"><span class=\"text-dark\" style=\"font-size: 20px;\">Busqueda</span></a></li>"
                    + "<li class=\"nav-item\"><a class=\"nav-link\" href=\"acerca_de.jsp\"><span class=\"text-dark\" style=\"font-size: 20px;\">Acerca de</span></a></li>"
                    + "<li class=\"nav-item\"><a class=\"nav-link\" href=\"contacto.jsp\"><span class=\"text-dark\" style=\"font-size: 20px;\">Contacto</span></a></li>"
                    + "<li class=\"nav-item\"><a class=\"nav-link\" href=\"reportar.jsp\"><span class=\"text-dark\" style=\"font-size: 20px;\">Reportar</span></a></li>"
                    + "<li class=\"nav-item\"><a class=\"nav-link\" href=\"Controlador?accion=Cerrar Sesion\"><span class=\"text-dark\" style=\"font-size: 20px;\">Salir</span></a></li>"
                    + "</ul>"
                    + "</div>"
                    + "</nav>";
            
        } else {
        
                    
            html = ""
                    + "<nav class=\"navbar navbar-light align-items-start sidebar sidebar-dark accordion bg-gradient-primary p-0\">"
                    + "<div class=\"container-fluid d-flex flex-column p-0\">"
                    + "<hr style=\"color: rgba(255,255,255,0);\"><a class=\"navbar-brand text-center d-flex justify-content-center align-items-center sidebar-brand m-0\" href=\"#\">" + "<img class=\"img-fluid\" src=\"assets/img/utp_logo_small.png\"></a>"
                    + "<hr class=\"sidebar-divider my-0\">"
                    + "<ul class=\"navbar-nav text-light\" id=\"accordionSidebar\">"
                    + "<li class=\"nav-item\"><a class=\"nav-link\" href=\"index.jsp\"><span class=\"text-dark\" style=\"font-size: 20px;\">Inicio</span></a></li>"
                    + "<li class=\"nav-item\"><a class=\"nav-link\" href=\"acerca_de.jsp\"><span class=\"text-dark\" style=\"font-size: 20px;\">Acerca De</span></a></li>"
                    + "<li class=\"nav-item\"><a class=\"nav-link\" href=\"contacto.jsp\"><span class=\"text-dark\" style=\"font-size: 20px;\">Contacto</span></a></li>"
                    + "<li class=\"nav-item\"><a class=\"nav-link\" href=\"iniciarsesion.jsp\"><span class=\"text-dark\" style=\"font-size: 20px;\">Iniciar Sesion</span></a></li>"
                    + "<li class=\"nav-item\"><a class=\"nav-link\" href=\"registro.jsp\"><span class=\"text-dark\" style=\"font-size: 20px;\">Registro</span></a></li>"
                    + "<li class=\"nav-item\"><a class=\"nav-link\" href=\"reportar.jsp\"><span class=\"text-dark\" style=\"font-size: 20px;\">Reportar</span></a></li>"
                    + "</ul>"
                    + "</div>"
                    + "</nav>";
            
        }
        
        return html;
    }

}
