
package procesos;

import entidades.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * @author Polar
 */
public class Registrar {
    
    public static int insertarUsuario(Usuario usuario) throws SQLException {
        
        int resultado = 0;
        
        Connection conn = Conectar.conectar();
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
        
        return resultado;
    }
    
    public static boolean revisarExistencia(String correo, String cedula){
    
        boolean resultado = false;
    
        try {
            Connection conn = Conectar.conectar();
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM Usuario WHERE "
                    + "correo='" + correo + "' or cedula='" + cedula+"'";
            
            ResultSet rs = stmt.executeQuery(query);
            
            if(rs.next()){
                resultado = true;
            }
            
            rs.close();
            stmt.close();
            conn.close();
            
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
        
        return resultado;
    }
    
}
