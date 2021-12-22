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
import procesos.BaseDeDatos;

/**
 *
 * @author manue
 */
public class Grupo {

    private String cod_grupo;
    private String correo_maestro;
    private int nivel;

    public void crearGrupo() throws SQLException{
        
        Connection cn = null;
        Statement stmt = null;
        String query;
        
        cn = BaseDeDatos.conectar();
        stmt = cn.createStatement();
        query = "INSERT INTO Grupo VALUES('"
                + this.getCod_grupo() + "','"
                + this.getCorreo_maestro()+ "',"
                + this.getNivel()+ ")";
        
        stmt.executeUpdate(query);
        
        BaseDeDatos.cerrarConexiones(cn, stmt);
        
    }
    
    public static Grupo buscarGrupo(String cod_grupo) {
        Grupo grupo = new Grupo();

        Connection cn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String query;

        try {
            cn = BaseDeDatos.conectar();
            stmt = cn.createStatement();
            query = "SELECT * FROM Grupo WHERE cod_grupo='" + cod_grupo + "'";
            rs = stmt.executeQuery(query);

            if (rs.next()) {
                grupo.setCod_grupo(rs.getString("cod_grupo"));
                grupo.setCorreo_maestro(rs.getString("correo_maestro"));
                grupo.setNivel(rs.getInt("nivel"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            BaseDeDatos.cerrarConexiones(cn, stmt, rs);
        }

        return grupo;
    }

    public static String buscarProfesor(String codGrupo) {
        String nombre = "";
        Connection conn = null, conn2 = null;
        Statement stmt = null, stmt2 = null;
        ResultSet rs = null, rs2 = null;

        try {

            conn = BaseDeDatos.conectar();
            stmt = conn.createStatement();
            String query = "SELECT * FROM Grupo WHERE cod_grupo ='" + codGrupo + "'";
            rs = stmt.executeQuery(query);

            if (rs.next()) {

                try {
                    conn2 = BaseDeDatos.conectar();
                    stmt2 = conn2.createStatement();
                    query = "SELECT * FROM Usuario WHERE correo='" + rs.getString("correo_maestro") + "'";
                    rs2 = stmt2.executeQuery(query);

                    if (rs2.next()) {
                        nombre = rs2.getString("nombre");
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
            BaseDeDatos.cerrarConexiones(conn, stmt, rs);
        }

        return nombre;
    }

    public static int buscarNivel(String codGrupo) {
        int nivel = -1;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {

            conn = BaseDeDatos.conectar();
            stmt = conn.createStatement();
            String query = "SELECT * FROM Grupo WHERE cod_grupo ='" + codGrupo + "'";
            rs = stmt.executeQuery(query);

            if (rs.next()) {
                nivel = rs.getInt("cod_grupo");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            BaseDeDatos.cerrarConexiones(conn, stmt, rs);
        }

        return nivel;
    }

    public static List listarGrupos() {

        List<Grupo> lista = new ArrayList<>();
        Grupo grupo;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {

            conn = BaseDeDatos.conectar();
            stmt = conn.createStatement();
            String query = "SELECT * FROM Grupo";
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                grupo = new Grupo();
                grupo.setCod_grupo(rs.getString("cod_grupo"));
                grupo.setCorreo_maestro(rs.getString("correo_maestro"));
                grupo.setNivel(rs.getInt("nivel"));
                lista.add(grupo);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            BaseDeDatos.cerrarConexiones(conn, stmt, rs);
        }

        return lista;
    }

    /**
     * @return the cod_grupo
     */
    public String getCod_grupo() {
        return cod_grupo;
    }

    /**
     * @param cod_grupo the cod_grupo to set
     */
    public void setCod_grupo(String cod_grupo) {
        this.cod_grupo = cod_grupo;
    }

    /**
     * @return the correo_maestro
     */
    public String getCorreo_maestro() {
        return correo_maestro;
    }

    /**
     * @param correo_maestro the correo_maestro to set
     */
    public void setCorreo_maestro(String correo_maestro) {
        this.correo_maestro = correo_maestro;
    }

    /**
     * @return the nivel
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * @param nivel the nivel to set
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public static String listarParaProfesor(String correo_maestro) {
        String query, tag = "";

        Connection cn = null;
        Statement stmt = null;
        ResultSet rs = null;
        Grupo grupo;
        List<Grupo> grupos = new ArrayList<>();

        try {

            cn = BaseDeDatos.conectar();
            stmt = cn.createStatement();
            query = "SELECT * FROM Grupo WHERE correo_maestro='" + correo_maestro + "'";
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                grupo = new Grupo();
                grupo.setCod_grupo(rs.getString("cod_grupo"));
                grupo.setCorreo_maestro(correo_maestro);
                grupo.setNivel(rs.getInt("nivel"));
                grupos.add(grupo);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            BaseDeDatos.cerrarConexiones(cn, stmt, rs);
        }

        for (Grupo grupo1 : grupos) {

            tag += "<tr>"
                    + "<form action=\"Controlador\">"
                    + "<input type=\"hidden\" name=\"cod_grupo\" value=\"" + grupo1.getCod_grupo() + "\">"
                    + "<td style=\"color: rgb(0,0,0);\"><h3>Grupo#" + grupo1.getCod_grupo() + "</h3></td>"
                    + "<td><input class=\"btn btn-primary border rounded-0\" type=\"submit\" name=\"accion\" style=\"color: rgb(0,0,0);background: rgba(255,255,255,0);border-color: rgb(0,0,0);width: 150px;margin-bottom: 30px;\" value=\"Administrar Grupo\"></td>"
                    + "</form>"
                    + "</tr>";
        }

        return tag;
    }

}
