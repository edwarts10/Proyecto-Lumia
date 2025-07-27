
package lumia.com.lumia;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
/**
 *
 * @author edwar
 */
public class PruebaConexion {
    public static void main(String[] args) {
        try (Connection conn = ConexionDB.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM usuario")) {

            System.out.println(" Conexión exitosa. Datos de la tabla 'usuario':");

            while (rs.next()) {
                int id = rs.getInt("id_usuario");
                String nombre = rs.getString("nombre");
                String correo = rs.getString("correo");

                System.out.println("ID: " + id + " | Nombre: " + nombre + " | Correo: " + correo);
            }

        } catch (SQLException e) {
            System.err.println(" Error al consultar la base de datos: " + e.getMessage());
        }
    }
}

