package entidades;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import procesos.BaseDeDatos;

public class Tema {

    private String codTema;
    private String titulo;
    private String imagen;
    private String contenido;
    private double completado;

    public String getCodTema() {
        return codTema;
    }

    public void setCodTema(String codTema) {
        this.codTema = codTema;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String tema) {
        this.titulo = tema;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public static List<Tema> generarListaTemasProf(String codGrupo) {
        List<Tema> lista = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {

            conn = BaseDeDatos.conectar();
            stmt = conn.createStatement();
            String query, codTema, tableRows = "";
            Tema tema = new Tema();

            if (codGrupo.contains("01")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCN01%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("02")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCN02%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("03")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCN03%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("04")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCN04%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("05")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCN05%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("06")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCN06%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("07")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCN07%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("08")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCN08%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("09")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCN09%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("10")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCS10%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("11")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCS11%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("12")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCS12%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("13")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCS13%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("14")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCS14%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("15")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCS15%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            for (int i = 0; i < lista.size(); i++) {
                tableRows += (lista.get(i)) + "<tr><td style=\"color: rgb(0,0,0);\">" + lista.get(i).getTitulo() + "</td><td><button class=\"btn btn-primary border rounded-0\" type=\"button\" style=\"color: rgb(0,0,0);background: rgba(255,255,255,0);border-color: rgb(0,0,0);width: 150px;margin-bottom: 30px;\">Administrar</button></td></tr>";
            }

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
        Tema tema;

        try {

            conn = BaseDeDatos.conectar();
            stmt = conn.createStatement();
            String query;

            if (codGrupo.contains("01")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCN01%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("02")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCN02%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("03")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCN03%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("04")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCN04%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("05")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCN05%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("06")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCN06%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("07")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCN07%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("08")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCN08%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("09")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCN09%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("10")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCS10%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("11")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCS11%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("12")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCS12%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("13")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCS13%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("14")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCS14%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("15")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCS15%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
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

    public static List<Tema> buscarPorTitulo(String titulo) {
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

    public static Tema buscarPorCodigo(String codTema) {
        Tema tema = null;

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String query;

        try {

            conn = BaseDeDatos.conectar();
            stmt = conn.createStatement();
            query = "SELECT * FROM Tema WHERE cod_tema ='" + codTema + "'";
            rs = stmt.executeQuery(query);

            if (rs.next()) {
                tema = new Tema();
                tema.setCodTema(codTema);
                tema.setContenido(rs.getString("Contenido"));
                tema.setImagen(rs.getString("imagen"));
                tema.setTitulo(rs.getString("tema"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            BaseDeDatos.cerrarConexiones(conn, stmt, rs);
        }

        return tema;
    }

    public static String estatus(String codTema, String correoEstudiante) {

        String query, estatus = "", tag;
        int i = 0, j, cantPreg = 0, puntos[], respuestas = 0;

        Connection conn1 = null;
        Statement stmt1 = null;
        ResultSet rs1 = null;

        try {

            conn1 = BaseDeDatos.conectar();
            stmt1 = conn1.createStatement();
            query = "SELECT * FROM Pregunta WHERE cod_tema ='" + codTema + "'";
            rs1 = stmt1.executeQuery(query);

            while (rs1.next()) {
                cantPreg++;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            BaseDeDatos.cerrarConexiones(conn1, stmt1, rs1);
        }

        puntos = new int[cantPreg];

        Connection conn2 = null;
        Statement stmt2 = null;
        ResultSet rs2 = null;
        try {

            conn2 = BaseDeDatos.conectar();
            stmt2 = conn2.createStatement();
            query = "SELECT * FROM Pregunta WHERE cod_tema ='" + codTema + "'";
            rs2 = stmt2.executeQuery(query);

            while (rs2.next()) {
                puntos[i] = rs2.getInt("cod_pregunta");
                i++;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            BaseDeDatos.cerrarConexiones(conn2, stmt2, rs2);
        }

        Connection conn3 = null;
        Statement stmt3 = null;
        ResultSet rs3 = null;
        try {

            for (j = 0; j < cantPreg; j++) {

                conn3 = BaseDeDatos.conectar();
                stmt3 = conn3.createStatement();
                query = "SELECT * FROM Contestan WHERE cod_pregunta ='" + puntos[j] + "' and correo_est='" + correoEstudiante + "'";
                rs3 = stmt3.executeQuery(query);

                while (rs3.next()) {
                    respuestas++;
                }

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            BaseDeDatos.cerrarConexiones(conn3, stmt3, rs3);
        }
        
        if (respuestas == cantPreg) {
            estatus = "<span style=\\\"margin-left: 2em;\\\">   Completado</span>";
        } 
        
        tag = estatus + "<span><span><i class=\\\"fa fa-check-circle\\\" style=\\\"margin-right: 0.5em;margin-left: 0.5em;\\\"></i></span>   " + cantPreg + " pts</span>";

        return tag;
    }
    
    public String cargarImagenes(){
    
        String tag = "<br><br><br><br><br>"
                + "<div class=\"col-auto col-sm-12 col-md-6 text-center order-2\"><img class=\"img-fluid\" src=\"assets//img//temas//" + this.getCodTema() + "-A.png\" width=\"350\" height=\"350\"></div>"
                + "<div class=\"col-auto col-sm-12 col-md-6 text-center order-2\"><img class=\"img-fluid\" src=\"assets//img//temas//" + this.getCodTema() + "-B.png\" width=\"350\" height=\"350\"></div>";
    
        return tag;
    }
    
    /**
     * @return the completado
     */
    public double getCompletado() {
        return completado;
    }

    /**
     * @param completado the completado to set
     */
    public void setCompletado(double completado) {
        this.completado = completado;
    }

}
