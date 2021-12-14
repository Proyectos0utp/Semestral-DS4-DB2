
package procesos;

import entidades.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
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
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            this.conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=EducacionVirtual", "db2_admin", "1234");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al registrar el driver de SQLSERVER: " + ex);
        } catch (SQLException ex) {
            Logger.getLogger(Registrar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Registrar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Registrar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int InsertarUsuario(String cedula, String correo, String password, String nombre, String apellido) {
        
        int resultado = 0;
        
        try {
            Statement stmt = conn.createStatement();
            String query = "INSERT INTO Usuario(cedula,correo,contraseña,nombre,apellido)";
            
            query += "VALUES('"+ cedula +"','"+ correo +"','"+ password +
                    "','"+ nombre +"','"+ apellido +"')";
            
            resultado = stmt.executeUpdate(query);
            
            stmt.close();
            conn.close();
            
            return resultado;
        } catch (SQLException ex) {
            System.out.println("Error al registrar el driver de SQLSERVER: " + ex);
            Logger.getLogger(Registrar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
}
