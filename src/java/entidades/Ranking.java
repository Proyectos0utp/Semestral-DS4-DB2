/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import static entidades.Grupo.generarListaEstudiantes;
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
public class Ranking {

    private String estudiante;
    private int puntaje;

    public static List<Ranking> generarRanking(List<Usuario> estudiantes) {

        List<Ranking> ranking = new ArrayList<>();
        int puntaje = 0;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {

            conn = BaseDeDatos.conectar();
            stmt = conn.createStatement();
            String query = "SELECT puntos_obtenidos FROM Contestan WHERE correo_est LIKE '";

            for (int i = 0; i < estudiantes.size(); i++) {
                Ranking e = new Ranking();
                e.setEstudiante(estudiantes.get(i).getNombre() + estudiantes.get(i).getApellido());
                
                String q = query+estudiantes.get(i).getCorreo()+"'";
                
                rs = stmt.executeQuery(q);
                while (rs.next()) {
                    puntaje = puntaje + rs.getInt("puntos_obtenidos");
                }
                e.setPuntaje(puntaje);
                ranking.add(e);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            BaseDeDatos.cerrarConexiones(conn, stmt, rs);
        }

        return ranking;
    }

    public String getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(String estudiante) {
        this.estudiante = estudiante;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
    /*
    public int compareTo(Ranking est) {
        int comparePuntaje = ((Ranking) est).getPuntaje();

        //  For Ascending order
        return this.getPuntaje() - comparePuntaje;

        // For Descending order do like this
        // return compareage-this.studentage;
    }*/
}
