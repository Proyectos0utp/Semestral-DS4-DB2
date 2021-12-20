package entidades;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import procesos.BaseDeDatos;

/**
 *
 * @author manue
 */
public class Examen {

    private String cod_tema;
    private String corr_est;
    private Map<Pregunta, Respuesta> enunciados;

    public Examen() {
        enunciados = new HashMap<>();
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
                this.getEnunciados().put(pregunta, null);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            BaseDeDatos.cerrarConexiones(cn, stmt, rs);
        }

    }

    public void cargarRespuestas() {

        Connection cn = null;
        Statement stmt = null;
        ResultSet rs = null;
        Respuesta respuesta;
        Pregunta pregunta;
        Iterator<Pregunta> iterador;
        String query;

        try {

            cn = BaseDeDatos.conectar();
            stmt = cn.createStatement();
            query = "SELECT * FROM Respuesta";

            rs = stmt.executeQuery(query);

            while (rs.next()) {

                iterador = this.getEnunciados().keySet().iterator();

                while (iterador.hasNext()) {
                    pregunta = iterador.next();
                    if (rs.getString("cod_pregunta").equals(pregunta.getCod_pregunta())) {

                        respuesta = new Respuesta();
                        respuesta.setCod_pregunta(pregunta.cod_pregunta);
                        respuesta.setIdent_opcion(rs.getString("ident_opcion"));
                        respuesta.setOpcion_resp(rs.getString("opcion_resp"));
                        respuesta.setRespuesta(rs.getString("respuesta"));
                        respuesta.setRetroalimentacion(rs.getString("retroalimentacion"));
                        this.getEnunciados().replace(pregunta, respuesta);
                    }

                }

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            BaseDeDatos.cerrarConexiones(cn, stmt, rs);
        }

    }

    public int obtenerPonderacion() {
        int ponderacion = 0;

        String query;
        int i = 0, j, cantPreg = 0, puntos[], respuestas = 0;

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
                    if(rs3.getString("cod_pregunta").equals(String.valueOf(puntos[j]))){
                        respuestas++;
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
            ponderacion = (respuestas/cantPreg)*100;
        }

        return ponderacion;
    }

    private class Pregunta {

        private String cod_pregunta, pregunta, imagen;

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

    private class Respuesta {

        private String cod_pregunta, ident_opcion, opcion_resp, respuesta, retroalimentacion;

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
     * @return the enunciados
     */
    public Map<Pregunta, Respuesta> getEnunciados() {
        return enunciados;
    }

    /**
     * @param enunciados the enunciados to set
     */
    public void setEnunciados(Map<Pregunta, Respuesta> enunciados) {
        this.enunciados = enunciados;
    }

}
