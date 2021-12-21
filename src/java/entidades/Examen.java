package entidades;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import procesos.BaseDeDatos;

/**
 *
 * @author manue
 */
public class Examen {

    private String cod_tema;
    private String corr_est;
    private Map<String, Pregunta> preguntas;
    private Map<String, List<Respuesta>> respuestas;

    public Examen() {
        preguntas = new HashMap<>();
        respuestas = new HashMap<>();
    }

    /**
     * @return the cod_tema
     */
    public String getCod_tema() {
        return cod_tema;
    }

    /**
     * @param cod_tema the cod_tema to set
     */
    public void setCod_tema(String cod_tema) {
        this.cod_tema = cod_tema;
    }

    /**
     * @return the corr_est
     */
    public String getCorr_est() {
        return corr_est;
    }

    /**
     * @param corr_est the corr_est to set
     */
    public void setCorr_est(String corr_est) {
        this.corr_est = corr_est;
    }

    public void cargarPreguntas() {

        Connection cn = null;
        Statement stmt = null;
        ResultSet rs = null;
        Pregunta pregunta;
        String query;

        try {

            cn = BaseDeDatos.conectar();
            stmt = cn.createStatement();
            query = "SELECT * FROM Pregunta WHERE cod_tema='" + this.getCod_tema() + "'";

            rs = stmt.executeQuery(query);

            while (rs.next()) {
                pregunta = new Pregunta();
                pregunta.setCod_pregunta(rs.getString("cod_pregunta"));
                pregunta.setPregunta(rs.getString("pregunta"));
                pregunta.setImagen(rs.getString("imagen"));
                this.getPreguntas().put(rs.getString("cod_pregunta"), pregunta);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            BaseDeDatos.cerrarConexiones(cn, stmt, rs);
        }

    }

    public List<Respuesta> buscarRespuestas(String cod_pregunta) {

        Connection cn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Respuesta> lista = new LinkedList<>();
        Respuesta respuesta;
        String query;

        try {

            cn = BaseDeDatos.conectar();
            stmt = cn.createStatement();
            query = "SELECT * FROM Respuesta WHERE cod_pregunta='" + cod_pregunta + "'";
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                respuesta = new Respuesta();
                respuesta.setCod_pregunta(rs.getString("cod_pregunta"));
                respuesta.setIdent_opcion(rs.getString("ident_opcion"));
                respuesta.setOpcion_resp(rs.getString("opcion_resp"));
                respuesta.setRespuesta(rs.getString("respuesta"));
                respuesta.setRetroalimentacion(rs.getString("retroalimentacion"));
                lista.add(respuesta);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            BaseDeDatos.cerrarConexiones(cn, stmt, rs);
        }

        return lista;
    }

    public void cargarRespuestas() {

        Iterator<String> iterador = this.getPreguntas().keySet().iterator();

        while (iterador.hasNext()) {
            String next = iterador.next();
            this.getRespuestas().put(next, buscarRespuestas(next));
        }

    }

    public int obtenerPonderacion() {
        int ponderacion = 0;

        String query;
        int i = 0, j, cantPreg = 0, puntos[], aux = 0;

        Connection conn1 = null;
        Statement stmt1 = null;
        ResultSet rs1 = null;

        try {

            conn1 = BaseDeDatos.conectar();
            stmt1 = conn1.createStatement();
            query = "SELECT * FROM Pregunta WHERE cod_tema ='" + this.getCod_tema() + "'";
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
            query = "SELECT * FROM Pregunta WHERE cod_tema ='" + this.getCod_tema() + "'";
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

            conn3 = BaseDeDatos.conectar();
            stmt3 = conn3.createStatement();
            query = "SELECT * FROM Contestan WHERE correo_est='" + this.getCorr_est() + "'";
            rs3 = stmt3.executeQuery(query);

            while (rs3.next()) {

                for (j = 0; j < cantPreg; j++) {
                    if (rs3.getString("cod_pregunta").equals(String.valueOf(puntos[j]))) {
                        aux++;
                    }
                }

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            BaseDeDatos.cerrarConexiones(conn3, stmt3, rs3);
        }

        if (cantPreg == 0) {
            ponderacion = 0;
        } else {
            ponderacion = (aux / cantPreg) * 100;
        }

        return ponderacion;
    }

    public String generarExamen() {
        String examenHTML = "";
        int i = 0;
        Pregunta pregunta;
        Iterator<String> aux = this.getPreguntas().keySet().iterator();

        while (aux.hasNext()) {
            pregunta = this.getPreguntas().get(aux.next());
            examenHTML += "<br>"
                    + "<div class=\"row row-cols-1 text-start text-dark\">"
                    + "<div class=\"col-12 mb-4\">"
                    + "<div class=\"row row-cols-2\">"
                    + "<div class=\"col-auto col-sm-12 col-md-8 col-xl-12 order-first\" style=\"margin-bottom: 0.5em;\">"
                    + "<h2 style=\"color: rgb(0,0,0);\">Pregunta " + (i + 1) + "</h2>"
                    + "<p style=\"color: rgb(0,0,0);\">" + pregunta.getPregunta() + "</p><br>"
                    + "</div>"
                    + "<div class=\"col-auto col-sm-12 col-md-4 col-xl-12 text-center align-self-center order-2\" style=\"margin-bottom: 0.5em;\"><img class=\"img-fluid\" src=\"" + pregunta.getImagen() + "\"></div>";

            for (Respuesta respuesta : this.getRespuestas().get(pregunta.getCod_pregunta())) {

                examenHTML += "<div class=\"col-auto col-sm-12 order-last\" style=\"margin-bottom: 0.5em;\">"
                        + "<div class=\"form-check\" style=\"margin-bottom: 0.5em;\">"
                        + "<input class=\"form-check-input\" type=\"radio\" checked=\"\" value=\"" + respuesta.getIdent_opcion() + "\" name=\"respuesta" + pregunta.getCod_pregunta() + "\">"
                        + "<label class=\"form-check-label\" for=\"formCheck-1\">" + respuesta.getIdent_opcion() + ")&nbsp;" + respuesta.getOpcion_resp() + "</label>"
                        + "</div>"
                        + "</div>";

            }

            examenHTML += "</div>"
                    + "</div>"
                    + "</div>"
                    + "<br>";

            i++;
        }

        return examenHTML;
    }

    public static Respuesta buscarRespuesta(String cod_pregunta, String ident_opcion) {
        Respuesta respuesta = new Respuesta();
        List<Respuesta> lista = new ArrayList<>();
        Connection cn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String query = "SELECT * FROM Respuesta";

        try {

            cn = BaseDeDatos.conectar();
            stmt = cn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                respuesta = new Respuesta();
                respuesta.setCod_pregunta(rs.getString("cod_pregunta"));
                respuesta.setIdent_opcion(rs.getString("ident_opcion"));
                respuesta.setOpcion_resp(rs.getString("opcion_resp"));
                respuesta.setRespuesta(rs.getString("respuesta"));
                respuesta.setRetroalimentacion(rs.getString("retroalimentacion"));
                lista.add(respuesta);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            BaseDeDatos.cerrarConexiones(cn, stmt, rs);
        }

        for (Respuesta res : lista) {
            if (res.getCod_pregunta().equals(cod_pregunta) && res.getIdent_opcion().equals(ident_opcion)) {
                respuesta = res;
            }
        }

        return respuesta;
    }

    public Map<String, Respuesta> buscarRespuestasCorrectas() {
        Map<String, Respuesta> map = new HashMap<>();

        Connection cn = null;
        Statement stmt = null;
        ResultSet rs = null;
        Respuesta respuesta;
        String query;

        try {

            cn = BaseDeDatos.conectar();
            stmt = cn.createStatement();
            query = "SELECT * FROM Respuesta WHERE respuesta='Correcto'";
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                respuesta = new Respuesta();
                respuesta.setCod_pregunta(rs.getString("cod_pregunta"));
                respuesta.setIdent_opcion(rs.getString("ident_opcion"));
                respuesta.setOpcion_resp(rs.getString("opcion_resp"));
                respuesta.setRespuesta(rs.getString("respuesta"));
                respuesta.setRetroalimentacion(rs.getString("retroalimentacion"));
                map.put(rs.getString("cod_pregunta"), respuesta);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            BaseDeDatos.cerrarConexiones(cn, stmt, rs);
        }

        return map;
    }

    public static void subirIntento(String correo_est, String cod_pregunta, String puntos_obtenidos, String fecha) {

        Connection cn1 = null;
        Statement stmt1 = null;
        ResultSet rs = null;
        boolean intentoExistente = false;
        String query;

        try {

            cn1 = BaseDeDatos.conectar();
            stmt1 = cn1.createStatement();
            query = "SELECT * FROM Contestan WHERE corr_est ='" + correo_est + "'";

            rs = stmt1.executeQuery(query);

            intentoExistente = rs.next();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            BaseDeDatos.cerrarConexiones(cn1, stmt1, rs);
        }

        if (!intentoExistente) {

            Connection cn2 = null;
            Statement stmt2 = null;

            try {

                cn2 = BaseDeDatos.conectar();
                stmt2 = cn2.createStatement();
                query = "INSERT INTO Contestan VALUES('"
                        + correo_est + "','"
                        + cod_pregunta + "','"
                        + puntos_obtenidos + "','"
                        + fecha + "')";

                stmt2.executeUpdate(query);

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } finally {
                BaseDeDatos.cerrarConexiones(cn2, stmt2);
            }

        } else {

            Connection cn3 = null;
            Statement stmt3 = null;

            try {

                cn3 = BaseDeDatos.conectar();
                stmt3 = cn3.createStatement();
                query = "UPDATE Contestan SET"
                        + "(cod_pregunta='" + cod_pregunta 
                        + "',puntos_obtenidos='" + puntos_obtenidos 
                        + "',fecha='" + fecha 
                        + "') WHERE correo_est='" + correo_est + "'";

                stmt3.executeUpdate(query);

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } finally {
                BaseDeDatos.cerrarConexiones(cn3, stmt3);
            }

        }

    }

    public static class Pregunta {

        private String cod_pregunta, pregunta, imagen;

        public Pregunta() {
            cod_pregunta = "";
            pregunta = "";
            imagen = "";
        }

        /**
         * @return the cod_pregunta
         */
        public String getCod_pregunta() {
            return cod_pregunta;
        }

        /**
         * @param cod_pregunta the cod_pregunta to set
         */
        public void setCod_pregunta(String cod_pregunta) {
            this.cod_pregunta = cod_pregunta;
        }

        /**
         * @return the pregunta
         */
        public String getPregunta() {
            return pregunta;
        }

        /**
         * @param pregunta the pregunta to set
         */
        public void setPregunta(String pregunta) {
            this.pregunta = pregunta;
        }

        /**
         * @return the imagen
         */
        public String getImagen() {
            return imagen;
        }

        /**
         * @param imagen the imagen to set
         */
        public void setImagen(String imagen) {
            this.imagen = imagen;
        }
    }

    public static class Respuesta {

        private String cod_pregunta, ident_opcion, opcion_resp, respuesta, retroalimentacion;

        public Respuesta() {
            cod_pregunta = "";
            ident_opcion = "";
            opcion_resp = "";
            respuesta = "";
            retroalimentacion = "";
        }

        /**
         * @return the cod_pregunta
         */
        public String getCod_pregunta() {
            return cod_pregunta;
        }

        /**
         * @param cod_pregunta the cod_pregunta to set
         */
        public void setCod_pregunta(String cod_pregunta) {
            this.cod_pregunta = cod_pregunta;
        }

        /**
         * @return the ident_opcion
         */
        public String getIdent_opcion() {
            return ident_opcion;
        }

        /**
         * @param ident_opcion the ident_opcion to set
         */
        public void setIdent_opcion(String ident_opcion) {
            this.ident_opcion = ident_opcion;
        }

        /**
         * @return the opcion_resp
         */
        public String getOpcion_resp() {
            return opcion_resp;
        }

        /**
         * @param opcion_resp the opcion_resp to set
         */
        public void setOpcion_resp(String opcion_resp) {
            this.opcion_resp = opcion_resp;
        }

        /**
         * @return the respuesta
         */
        public String getRespuesta() {
            return respuesta;
        }

        /**
         * @param respuesta the respuesta to set
         */
        public void setRespuesta(String respuesta) {
            this.respuesta = respuesta;
        }

        /**
         * @return the retroalimentacion
         */
        public String getRetroalimentacion() {
            return retroalimentacion;
        }

        /**
         * @param retroalimentacion the retroalimentacion to set
         */
        public void setRetroalimentacion(String retroalimentacion) {
            this.retroalimentacion = retroalimentacion;
        }
    }

    /**
     * @return the preguntas
     */
    public Map<String, Pregunta> getPreguntas() {
        return preguntas;
    }

    /**
     * @param preguntas the preguntas to set
     */
    public void setPreguntas(Map<String, Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    /**
     * @return the respuestas
     */
    public Map<String, List<Respuesta>> getRespuestas() {
        return respuestas;
    }

    /**
     * @param respuestas the respuestas to set
     */
    public void setRespuestas(Map<String, List<Respuesta>> respuestas) {
        this.respuestas = respuestas;
    }

}
