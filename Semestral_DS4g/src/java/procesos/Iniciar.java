/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author jotaz
 */
public class Iniciar {

    Connection cn;

    public void Iniciar() {
        this.cn = (Connection) new Conectar();
    }

    public int LoginVerificar(String correo, String pass) {
        int tipo = 0;
        try {
            Statement stmt = cn.createStatement();
            String query = "SELECT * FROM Usuario WHERE correo = '" + correo + "' AND contraseña = '" + pass + "'";
            ResultSet result = stmt.executeQuery(query);
            if (result.next()) {
                tipo = 1;
            }
            if (tipo != 0) {
                return tipo;
            } else {
                query = "SELECT * FROM Usuario WHERE correo = '" + correo + "' AND contraseña = '" + pass + "'";
                result = stmt.executeQuery(query);
                if (result.next()) {
                    tipo = 2;
                }
            }
            stmt.close();
            cn.close();
        } catch (Exception ew) {
            System.out.println(ew.getMessage());
        }
        return tipo;
    }

    public String LoginCedula(String correo, String pass) {
        try {
            Statement stmt = cn.createStatement();
            String query = "SELECT * FROM Usuario WHERE correo = '" + correo + "' AND contraseña = '" + pass + "'";
            ResultSet result = stmt.executeQuery(query);
            if (result.next()) {
                stmt.close();
                cn.close();
                return result.getString("cedula");
            }
            stmt.close();
            cn.close();
        } catch (Exception ew) {
            System.out.println(ew.getMessage());
        }
        return "Error";
    }

    public String LoginNombre(String correo, String pass) {
        try {
            Statement stmt = cn.createStatement();
            String query = "SELECT * FROM Usuario WHERE correo = '" + correo + "' AND contraseña = '" + pass + "'";
            ResultSet result = stmt.executeQuery(query);
            if (result.next()) {
                stmt.close();
                cn.close();
                return result.getString("nombre");
            }
            stmt.close();
            cn.close();
        } catch (Exception ew) {
            System.out.println(ew.getMessage());
        }
        return "Error";
    }

    public String LoginApellido(String correo, String pass) {
        try {
            Statement stmt = cn.createStatement();
            String query = "SELECT * FROM Usuario WHERE correo = '" + correo + "' AND contraseña = '" + pass + "'";
            ResultSet result = stmt.executeQuery(query);
            if (result.next()) {
                stmt.close();
                cn.close();
                return result.getString("apellido");
            }
            stmt.close();
            cn.close();
        } catch (Exception ew) {
            System.out.println(ew.getMessage());
        }
        return "Error";
    }

    public String LoginGrupo(String correo) {
        try {
            Statement stmt = cn.createStatement();
            String query = "SELECT * FROM Estudiante WHERE correo = '" + correo + "'";
            ResultSet result = stmt.executeQuery(query);
            if (result.next()) {
                stmt.close();
                cn.close();
                return result.getString("cod_grupo");
            }
            stmt.close();
            cn.close();
        } catch (Exception ew) {
            System.out.println(ew.getMessage());
        }
        return "Error";
    }
}
