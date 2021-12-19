/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import procesos.Conectar;

/**
 *
 * @author manue
 */
public class Grupo {
    
    public static List<Usuario> generarListaEstudiantes(String codGrupo){
        List<Usuario> lista = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            
            conn = Conectar.conectar();
            stmt = conn.createStatement();
            String query = "SELECT * FROM Estudiante WHERE cod_grupo ='" + codGrupo + "'";
            rs = stmt.executeQuery(query);
            
            while (rs.next()) {                
                
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conectar.cerrarConexiones(conn, stmt, rs);
        }
        
        return lista;
    }
    
    public static String buscarProfesor(String codGrupo){
        String nombre = "";
        Connection conn = null, conn2 = null;
        Statement stmt = null, stmt2 = null;
        ResultSet rs = null, rs2 = null;
        
        try {
            
            conn = Conectar.conectar();
            stmt = conn.createStatement();
            String query = "SELECT * FROM Grupo WHERE cod_grupo ='" + codGrupo + "'";
            rs = stmt.executeQuery(query);
            
            if (rs.next()) {
                
                try {
                    conn2 = Conectar.conectar();
                    stmt2 = conn2.createStatement();
                    query = "SELECT * FROM Usuario WHERE correo='" + rs.getString("correo_maestro") + "'";
                    rs2 = stmt2.executeQuery(query);
                    
                    if (rs2.next()) {
                        nombre = rs2.getString("nombre");
                    }
                    
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                } finally {
                    Conectar.cerrarConexiones(conn2, stmt2, rs2);
                }
                
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conectar.cerrarConexiones(conn, stmt, rs);
        }
        
        return nombre;
    }
    
    public static int buscarNivel(String codGrupo){
        int nivel = -1;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            
            conn = Conectar.conectar();
            stmt = conn.createStatement();
            String query = "SELECT * FROM Grupo WHERE cod_grupo ='" + codGrupo + "'";
            rs = stmt.executeQuery(query);
            
            if (rs.next()) {
                nivel = rs.getInt("cod_grupo");
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conectar.cerrarConexiones(conn, stmt, rs);
        }
        
        return nivel;
    }
    
    public static List<Tema> generarListaTemas(String codGrupo){
        List<Tema> lista = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            
            conn = Conectar.conectar();
            stmt = conn.createStatement();
            String query, codTema, tableRows="";
            Tema tema = new Tema();
            
            switch (codGrupo) {
                case "01":
                    for(int i=0; i<4; i++){
                        codTema = "TCN01-"+(i+1);
                        query = "SELECT * FROM Tema WHERE cod_tema = '" + codTema + "'";
                        rs = stmt.executeQuery(query);
                        while (rs.next()) {    
                            tema.setCodTema(codTema);
                            tema.setTema(rs.getString("tema"));
                            tema.setImagen(rs.getString("imagen"));
                            tema.setContenido(rs.getString("Contenido"));
                            lista.add(tema);
                        }
                    }
                    
                    for (int i = 0; i < lista.size(); i++) {
                        tableRows += (lista.get(i)) + "<tr><td style=\"color: rgb(0,0,0);\">"+lista.get(i).getTema()+"</td><td><button class=\"btn btn-primary border rounded-0\" type=\"button\" style=\"color: rgb(0,0,0);background: rgba(255,255,255,0);border-color: rgb(0,0,0);width: 150px;margin-bottom: 30px;\">Administrar</button></td></tr>";
                    }
                    break;
                case "02":
                    break;
                case "03":
                    break;
                case "04":
                    break;
                case "05":
                    break;
                case "06":
                    break;
                case "07":
                    break;
                case "08":
                    break;
                case "09":
                    break;
                case "10":
                    break;
                case "11":
                    break;
                case "12":
                    break;
                case "13":
                    break;
                case "14":
                    break;
                case "15":
                    break;
                default:
                    break;
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conectar.cerrarConexiones(conn, stmt, rs);
        }
        
        return lista;
    }
    
    public static List<Tema> busqueda(String Busqueda){
        List<Tema> lista = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            
            conn = Conectar.conectar();
            stmt = conn.createStatement();
            String query = "SELECT * FROM Tema WHERE tema ='" + Busqueda + "'";
            rs = stmt.executeQuery(query);
            
            while (rs.next()) {                
                
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conectar.cerrarConexiones(conn, stmt, rs);
        }
        
        return lista;
    }
}
