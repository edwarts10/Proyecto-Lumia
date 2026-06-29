/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lumia.com.lumia;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private Connection conn;

    public Connection getConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/datalumia", "root", "tu_contraseña"
            );
        } catch (Exception e) {
            System.out.println("Error conexión: " + e);
        }
        return conn;
    }
}