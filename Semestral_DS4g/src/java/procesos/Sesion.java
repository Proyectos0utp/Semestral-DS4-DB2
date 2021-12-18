/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

import entidades.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author jotaz
 */
public class Sesion {

    public static Usuario iniciar(String correo, String pass) {
        Usuario usuario = null;
        
        Connection conn1 = null, conn2 = null, conn3 = null, conn4 = null;
        Statement stmt1 = null, stmt2 = null, stmt3 = null, stmt4 = null;
        ResultSet rs1 = null, rs2 = null, rs3 = null, rs4 = null; 
        
        try {
            conn1 = Conectar.conectar();
            stmt1 = conn1.createStatement();
            String query = "SELECT * FROM Usuario WHERE correo = '" + correo + "' AND contraseña = '" + pass + "'";
            rs1 = stmt1.executeQuery(query);
            
            if (rs1.next()) {
                
                usuario = new Usuario();
                usuario.setCorreo(correo);
                usuario.setCedula(rs1.getString("cedula"));
                usuario.setNombre(rs1.getString("nombre"));
                usuario.setApellido(rs1.getString("apellido"));
                usuario.setPassword(pass);
                
                
                //Una vez es encontrado el usuario, se busca si es profesor o estudiante
                try {
                    conn2 = Conectar.conectar();
                    stmt2 = conn2.createStatement();
                    query = "SELECT * FROM Maestro WHERE correo_usuario = '" + correo +"'";
                    rs2 = stmt2.executeQuery(query);

                    if (rs2.next()) {
                        
                        try {
                            conn3 = Conectar.conectar();
                            stmt3 = conn3.createStatement();
                            query = "SELECT * FROM Grupo WHERE correo_maestro = '" + correo +"'";
                            rs3 = stmt3.executeQuery(query);

                            if (rs3.next()) {
                                usuario.setGrupo(rs3.getString("cod_grupo"));
                                usuario.setEsProfesor(true);
                            }
    
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        } finally {
                            Conectar.cerrarConexiones(conn3, stmt3, rs3);
                        }
                        
                    } else {
                        
                        try {
                            conn4 = Conectar.conectar();
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
                            Conectar.cerrarConexiones(conn4, stmt4, rs4);
                        }
                        
                    }

                        
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                } finally {
                    Conectar.cerrarConexiones(conn2, stmt2, rs2);
                }
                
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            Conectar.cerrarConexiones(conn1, stmt1, rs1);
        }
        
        return usuario;
    }

    public static void cerrar(Usuario usuario) {
        usuario = null;
    }

}
