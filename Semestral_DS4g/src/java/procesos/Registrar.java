
package procesos;

import entidades.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Polar
 */
public class Registrar {

    Connection conn;

    public Registrar() {
//        this.conn = Conectar.conectar(); 
    }
    
    public int insertarUsuario(Usuario usuario) {
        
        int resultado = 0;
        
        try {
            Statement stmt = conn.createStatement();
            String query = "INSERT INTO Usuario(cedula,correo,contraseña,nombre,apellido) VALUES ('"
                    + usuario.getCedula() + "','"
                    + usuario.getCorreo() + "','"
                    + usuario.getPassword() + "','"
                    + usuario.getNombre() + "','"
                    + usuario.getApellido() + "')";
            
            resultado = stmt.executeUpdate(query);
            
            stmt.close();
            conn.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al registrar el driver de SQLSERVER: " + ex);
            Logger.getLogger(Registrar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    public boolean revisarExistencia(String correo, String cedula){
    
        boolean resultado = false;
    
        try {
            Statement stmt = Conectar.conectar().createStatement();
            String query = "SELECT * FROM Usuario WHERE "
                    + "correo='" + correo + "' or cedula='" + cedula+"'";
            
            ResultSet rs = stmt.executeQuery(query);
            
            if(rs != null){
                resultado = true;
            }
            
            stmt.close();
            conn.close();
            rs.close();
            
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
            Logger.getLogger(Registrar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultado;
    }
    
}
