
package lumia.com.lumia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author edwar
 */
public class ConexionDB {
    public static Connection obtenerConexion() {
        String url = "jdbc:mysql://localhost:3306/datalumia";
        String user = "root";
        String password = "Adminedw123";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos");
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println("Driver no encontrado");
            e.printStackTrace();
            return null;
        }
    }
}
