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
        try {
            Connection conn1 = Conectar.conectar();
            Statement stmt1 = conn1.createStatement();
            String query = "SELECT * FROM Usuario WHERE correo = '" + correo + "' AND contraseña = '" + pass + "'";
            ResultSet rs1 = stmt1.executeQuery(query);
            
            if (!rs1.getString("correo").equals("")) {
                
                usuario = new Usuario();
                usuario.setCorreo(correo);
                usuario.setCedula(rs1.getString("cedula"));
                usuario.setNombre(rs1.getString("nombre"));
                usuario.setApellido(rs1.getString("apellido"));
                usuario.setPassword(pass);
                
                
                //Una vez es encontrado el usuario, se busca si es profesor o estudiante
                Connection conn2 = Conectar.conectar();
                Statement stmt2 = conn2.createStatement();
                query = "SELECT * FROM Maestro WHERE correo_usuario = '" + correo +"'";
                ResultSet rs2 = stmt2.executeQuery(query);
                
                if (!rs2.getString("correo").equals("")) {
                    Connection conn3 = Conectar.conectar();
                    Statement stmt3 = conn3.createStatement();
                    query = "SELECT * FROM Grupo WHERE correo_maestro = '" + correo +"'";
                    ResultSet rs3 = stmt3.executeQuery(query);
                    usuario.setGrupo(rs3.getString("cod_grupo"));
                    usuario.setEsProfesor(true);
                    
                    rs3.close();
                    stmt3.close();
                    conn3.close();
                   
                } else {
                    Connection conn4 = Conectar.conectar();
                    Statement stmt4 = conn4.createStatement();
                    query = "SELECT * FROM Estudiante WHERE correo_usuario = '" + correo +"'";
                    ResultSet rs4 = stmt4.executeQuery(query);
                    usuario.setGrupo(rs4.getString("cod_grupo"));
                    usuario.setEsProfesor(false);
                    
                    rs4.close();
                    stmt4.close();
                    conn4.close();
                    
                }
                
                rs2.close();
                stmt2.close();
                conn2.close();
            }
            
            rs1.close();
            stmt1.close();
            conn1.close();
        } catch (Exception ew) {
            System.out.println(ew.getMessage());
        }
        return usuario;
    }

    public static void cerrar(Usuario usuario) {
        usuario = null;
    }

}
