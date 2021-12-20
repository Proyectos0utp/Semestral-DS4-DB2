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

    public static List<Tema> generarListaTemas(String codGrupo) {
        List<Tema> lista = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {

            conn = BaseDeDatos.conectar();
            stmt = conn.createStatement();
            String query, codTema, tableRows = "";
            Tema tema = new Tema();

            if (codGrupo.contains("01") || codGrupo.contains("02") || codGrupo.contains("03") || codGrupo.contains("04") || codGrupo.contains("05") || codGrupo.contains("06") || codGrupo.contains("07") || codGrupo.contains("08") || codGrupo.contains("09")) {
                for (int i = 0; i < 4; i++) {
                    codTema = "TCN" + codGrupo + "-" + (i + 1);
                    query = "SELECT * FROM Tema WHERE cod_tema = '" + codTema + "'";
                    rs = stmt.executeQuery(query);
                    while (rs.next()) {
                        tema.setCodTema(codTema);
                        tema.setTitulo(rs.getString("tema"));
                        tema.setImagen(rs.getString("imagen"));
                        tema.setContenido(rs.getString("Contenido"));
                        lista.add(tema);
                    }
                }
            } else {
                for (int i = 0; i < 4; i++) {
                    codTema = "TCS" + codGrupo + "-" + (i + 1);
                    query = "SELECT * FROM Tema WHERE cod_tema = '" + codTema + "'";
                    rs = stmt.executeQuery(query);
                    while (rs.next()) {
                        tema.setCodTema(codTema);
                        tema.setTitulo(rs.getString("tema"));
                        tema.setImagen(rs.getString("imagen"));
                        tema.setContenido(rs.getString("Contenido"));
                        lista.add(tema);
                    }
                }
            }

            for (int i = 0; i < lista.size(); i++) {
                tableRows += (lista.get(i)) + "<tr><td style=\"color: rgb(0,0,0);\">" + lista.get(i).getTitulo() + "</td><td><button class=\"btn btn-primary border rounded-0\" type=\"button\" style=\"color: rgb(0,0,0);background: rgba(255,255,255,0);border-color: rgb(0,0,0);width: 150px;margin-bottom: 30px;\">Administrar</button></td></tr>";
            }

            /*
            switch (codGrupo) {
                case "01":
                    for (int i = 0; i < 4; i++) {
                        codTema = "TCN" + codGrupo + "-" + (i + 1);
                        query = "SELECT * FROM Tema WHERE cod_tema = '" + codTema + "'";
                        rs = stmt.executeQuery(query);
                        while (rs.next()) {
                            tema.setCodTema(codTema);
                            tema.setTitulo(rs.getString("tema"));
                            tema.setImagen(rs.getString("imagen"));
                            tema.setContenido(rs.getString("Contenido"));
                            lista.add(tema);
                        }
                    }

                    for (int i = 0; i < lista.size(); i++) {
                        tableRows += (lista.get(i)) + "<tr><td style=\"color: rgb(0,0,0);\">" + lista.get(i).getTitulo() + "</td><td><button class=\"btn btn-primary border rounded-0\" type=\"button\" style=\"color: rgb(0,0,0);background: rgba(255,255,255,0);border-color: rgb(0,0,0);width: 150px;margin-bottom: 30px;\">Administrar</button></td></tr>";
                    }
                    break;
                case "02":
                    for (int i = 0; i < 4; i++) {
                        codTema = "TCN02-" + (i + 1);
                        query = "SELECT * FROM Tema WHERE cod_tema = '" + codTema + "'";
                        rs = stmt.executeQuery(query);
                        while (rs.next()) {
                            tema.setCodTema(codTema);
                            tema.setTitulo(rs.getString("tema"));
                            tema.setImagen(rs.getString("imagen"));
                            tema.setContenido(rs.getString("Contenido"));
                            lista.add(tema);
                        }
                    }
                    break;
                case "03":
                    for (int i = 0; i < 4; i++) {
                        codTema = "TCN02-" + (i + 1);
                        query = "SELECT * FROM Tema WHERE cod_tema = '" + codTema + "'";
                        rs = stmt.executeQuery(query);
                        while (rs.next()) {
                            tema.setCodTema(codTema);
                            tema.setTitulo(rs.getString("tema"));
                            tema.setImagen(rs.getString("imagen"));
                            tema.setContenido(rs.getString("Contenido"));
                            lista.add(tema);
                        }
                    }
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
             */
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            BaseDeDatos.cerrarConexiones(conn, stmt, rs);
        }

        return lista;
    }

    public static List<Tema> generarListaTemasEst(String codGrupo) {
        List<Tema> lista = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {

            conn = BaseDeDatos.conectar();
            stmt = conn.createStatement();
            String query;

            if (codGrupo.contains("01")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCN01%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    Tema tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            } else if (codGrupo.contains("02")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCN02%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    Tema tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            } else if (codGrupo.contains("03")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCN03%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    Tema tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            } else if (codGrupo.contains("04")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCN04%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    Tema tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            } else if (codGrupo.contains("05")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCN05%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    Tema tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            } else if (codGrupo.contains("06")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCN06%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    Tema tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            } else if (codGrupo.contains("07")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCN07%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    Tema tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            } else if (codGrupo.contains("08")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCN08%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    Tema tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            } else if (codGrupo.contains("09")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCN09%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    Tema tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            } else if (codGrupo.contains("10")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCS10%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    Tema tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            } else if (codGrupo.contains("11")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCS11%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    Tema tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            } else if (codGrupo.contains("12")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCS12%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    Tema tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            } else if (codGrupo.contains("13")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCS13%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    Tema tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            } else if (codGrupo.contains("14")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCS14%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    Tema tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            } else {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCS15%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    Tema tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            BaseDeDatos.cerrarConexiones(conn, stmt, rs);
        }

        return lista;
    }

    public static List<Tema> buscarTema(String titulo) {
        List<Tema> lista = new ArrayList<>();
        Tema tema;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {

            conn = BaseDeDatos.conectar();
            stmt = conn.createStatement();
            String query = "SELECT * FROM Tema WHERE tema ='" + titulo + "'";
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                tema = new Tema();
                tema.setCodTema(rs.getString("cod_tema"));
                tema.setContenido(rs.getString("Contenido"));
                tema.setImagen(rs.getString("imagen"));
                tema.setTitulo(rs.getString("tema"));
                lista.add(tema);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            BaseDeDatos.cerrarConexiones(conn, stmt, rs);
        }

        return lista;
    }
}
