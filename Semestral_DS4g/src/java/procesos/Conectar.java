package procesos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * @author Polar
 */
public class Conectar {

    public static Connection conectar() {
        Connection conn = null;
        try {
            
            // CLASE DRIVER SQL
            String url = "jdbc:sqlserver://localhost\\localhost;databaseName=EducacionVirtual";
            String user = "db2_admin";
            String pass = "1234";
            
            // CADENA DE CONEXION
            conn = DriverManager.getConnection(url,user,pass);
            
        } catch (SQLException ex) {
            System.out.println("Error:");
            ex.printStackTrace();
        } 
        return conn;
    }
}
