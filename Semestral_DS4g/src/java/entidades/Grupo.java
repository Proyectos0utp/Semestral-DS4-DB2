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

    public static List<Usuario> generarListaEstudiantes(String codGrupo) {
        List<Usuario> lista = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {

            conn = BaseDeDatos.conectar();
            stmt = conn.createStatement();
            String query = "SELECT * FROM Estudiante WHERE cod_grupo ='" + codGrupo + "'";
            rs = stmt.executeQuery(query);

            while (rs.next()) {

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            BaseDeDatos.cerrarConexiones(conn, stmt, rs);
        }

        return lista;
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

}
