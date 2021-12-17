package procesos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;
/**
 * @author Polar
 */
public class Conectar {

    public static Connection conectar() {
        Connection conn = null;
        try {
            
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=EducacionVirtual", "db2_admin", "1234");
            
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            System.out.println("Error:");
            ex.printStackTrace();
        } 
        return conn;
    }
}
