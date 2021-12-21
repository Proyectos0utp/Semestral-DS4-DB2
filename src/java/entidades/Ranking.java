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
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import procesos.BaseDeDatos;

/**
 *
 * @author manue
 */
public class Ranking {

    public static String generarRanking(String cod_tema) {
        String nombreUsuario, tag = "";
        int i = 1, puntos;

        String query;

        Examen ex = new Examen();
        ex.setCod_tema(cod_tema);
        ex.cargarPreguntas();
        Object cod_preguntas[] = ex.getPreguntas().keySet().toArray();
        Map<String,Integer> map_correo_puntos = new TreeMap<>();
        Map<Integer,String> map_puntos_correo = new TreeMap<>();
        Connection cn1 = null;
        Statement stmt1 = null;
        ResultSet rs1 = null;

        try {

            cn1 = BaseDeDatos.conectar();
            stmt1 = cn1.createStatement();
            query = "SELECT * FROM Contestan";
            rs1 = stmt1.executeQuery(query);

            while (rs1.next()) {
                
                for(Object preg : cod_preguntas){
                    
                    if (rs1.getString("cod_pregunta").equals(preg.toString())) {
                        nombreUsuario = Usuario.buscarNombreUsuario(rs1.getString("correo_est"));
                        if (map_correo_puntos.containsKey(nombreUsuario)) {
                            
                            puntos = rs1.getInt("puntos_obtenidos") + map_correo_puntos.get(nombreUsuario);
                            map_correo_puntos.replace(nombreUsuario, puntos);
                            
                        } else {
                            map_correo_puntos.put(nombreUsuario, rs1.getInt("puntos_obtenidos"));
                        }
                        
                    }
                    
                }
                
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            BaseDeDatos.cerrarConexiones(cn1, stmt1, rs1);
        }
        
        Iterator<String> iterador = map_correo_puntos.keySet().iterator();
        
        while (iterador.hasNext()) {
            String next = iterador.next();
            map_puntos_correo.put(map_correo_puntos.get(next), next);
        }
       
        Iterator<Integer> puntos_reg = map_puntos_correo.keySet().iterator();
        Iterator<String> nombre_reg = map_puntos_correo.values().iterator();
        while (puntos_reg.hasNext()) {
            Integer p = puntos_reg.next();
            String n = nombre_reg.next();
            
            tag += "<tr>"
                    + "<td>#" + i + "</td>"
                    + "<td>" + n + "</td>"
                    + "<td>" + p + "</td>"
                    + "</tr>";
            i++;
        }
        
        return tag;
    }
}
