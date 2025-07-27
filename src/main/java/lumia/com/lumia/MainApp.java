
package lumia.com.lumia;

import java.sql.Connection;
import java.sql.SQLException;

public class MainApp {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("¡Conector cargado con éxito!");

            Connection conexion = ConexionDB.obtenerConexion();
            if (conexion != null) {
                System.out.println("¡Conexión exitosa!");

                // Aquí empiezas a probar los métodos CRUD
                UsuarioDAO usuarioDAO = new UsuarioDAO();

                // INSERTAR usuario
               usuarioDAO.RegistrarUsuario("Juan Pérez", "juan@example.com", "123456", "estudiante");

// Para listar usuarios
usuarioDAO.listarUsuarios();

              
                // ACTUALIZAR usuario
                 Usuario usuarioActualizado = new Usuario(1, "Juan Actualizado", "juan@example.com", "123456", "estudiante");
                 boolean actualizado = usuarioDAO.actualizarUsuario(usuarioActualizado);
                if (actualizado) {
                    System.out.println("Usuario actualizado correctamente.");
                } else {
                    System.out.println("Error al actualizar el usuario.");
                }


                // ELIMINAR usuario
                usuarioDAO.eliminarUsuario(1);

            } else {
                System.out.println("Fallo en la conexión.");
            }
            
         } catch (ClassNotFoundException e) {
            System.out.println("ERROR: No se encontró el conector JDBC");
           e.printStackTrace();
       // } catch (SQLException e) {
            System.out.println("ERROR de conexión o SQL:");
            e.printStackTrace();
        }
    }
}