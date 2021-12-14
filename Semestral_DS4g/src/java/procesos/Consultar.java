
package procesos;

import entidades.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Polar
 */
public class Consultar {
    
    Connection conn;

    public Consultar() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            this.conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=articulos", "root", "root");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al registrar el driver de SQLSERVER: " + ex);
        } catch (SQLException ex) {
            Logger.getLogger(Consultar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Consultar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Consultar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Usuario> ConsultarUsuario() {
        
        List<Usuario> users = new ArrayList<Usuario>();
        try {
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM Usuario";
            ResultSet rset = stmt.executeQuery(query);
            
            while(rset.next()) {
                Usuario user = new Usuario();
                user.setCedula(rset.getString("cedula"));
                user.setNombre(rset.getString("nombre"));
                user.setApellido(rset.getString("apellido"));
                user.setCorreo(rset.getString("correo"));
                user.setPassword(rset.getString("contraseña"));
                user.setGrupo(rset.getString("grupo"));
                users.add(user);
            }
            rset.close();
            stmt.close();
            conn.close();
            
            return users;
        } catch (SQLException ex) {
            Logger.getLogger(Consultar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }
}
