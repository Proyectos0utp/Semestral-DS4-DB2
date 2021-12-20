package entidades;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import procesos.BaseDeDatos;

public class Usuario {
    
    private String cedula;
    private String correo;
    private String password;
    private String nombre;
    private String apellido;
    private String grupo;
    private boolean esProfesor;

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    /**
     * @return the esProfesor
     */
    public boolean esProfesor() {
        return esProfesor;
    }

    /**
     * @param esProfesor the esProfesor to set
     */
    public void setEsProfesor(boolean esProfesor) {
        this.esProfesor = esProfesor;
    }

        public void calcularMedallas(String codTema, Integer medallas) {

        String query;
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
                query = "SELECT * FROM Contestan WHERE cod_pregunta ='" + puntos[j] + "' and correo_est='" + this.getCorreo() + "'";
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
            medallas++;
        } 
    }
}
