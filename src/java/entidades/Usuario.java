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

    public Usuario() {
        this.cedula = "";
        this.correo = "";
        this.password = "";
        this.nombre = "";
        this.apellido = "";
        this.grupo = "";
        this.esProfesor = false;
    }

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
    
    public static String buscarNombreUsuario(String correo_usuario){
        Usuario usuario = new Usuario();
        
        Connection cn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String query;
        
        try {
            
            cn = BaseDeDatos.conectar();
            stmt = cn.createStatement();
            query = "SELECT nombre,apellido FROM Usuario WHERE correo='" + correo_usuario + "'";
            rs = stmt.executeQuery(query);
            
            if(rs.next()){
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            BaseDeDatos.cerrarConexiones(cn, stmt, rs);
        }
        
        return usuario.getNombre() + " " + usuario.getApellido();
    }
    
    public int calcularMedallas(String codTema,String corr_est) {

        String query;
        int i = 0, puntos = 0;

        Examen examen = new Examen();
        examen.setCod_tema(codTema);
        examen.setCorr_est(corr_est);
        examen.cargarPreguntas();
        Object cod_preguntas[] = examen.getPreguntas().keySet().toArray();

        Connection conn1 = null;
        Statement stmt1 = null;
        ResultSet rs1 = null;

        try {

            conn1 = BaseDeDatos.conectar();
            stmt1 = conn1.createStatement();
            query = "SELECT * FROM Contestan";
            rs1 = stmt1.executeQuery(query);

            while (rs1.next()) {

                for (i = 0; i < cod_preguntas.length; i++) {
                    
                    if (cod_preguntas[i].toString().contains(rs1.getString("cod_pregunta"))) {
                        puntos += rs1.getInt("puntos_obtenidos");
                    }

                }

            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            BaseDeDatos.cerrarConexiones(conn1, stmt1, rs1);
        }
        
        if (puntos > 0) {
            return 1;
        } 
        return (puntos>0) ? 1 : 0;
    }
}
