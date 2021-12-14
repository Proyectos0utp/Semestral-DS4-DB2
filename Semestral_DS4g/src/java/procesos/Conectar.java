package procesos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Polar
 */
public class Conectar {

    Connection conn;

    public Connection Conectar() {
        try {

            // CLASE DRIVER SQL
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
                    
            // CADENA DE CONEXION
            this.conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=EducacionVirtual", "db2_admin", "1234");
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al registrar el driver de SQLSERVER: " + ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
}
