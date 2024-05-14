/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Jhon
 */
public class conexion {
    Connection con;
    String url = "jdbc:mysql://localhost:3307/bd_biblioteca_alexandria";
    String user = "root";
    String password = "";
    public Connection Conexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch ( ClassNotFoundException ex) {
            System.out.println("Error1 DriverBD: " + ex.getMessage());
        } catch ( SQLException ex) {
            System.out.println("Error2 DriverBD: " + ex.getMessage());
        }
        return con;
    }
}
