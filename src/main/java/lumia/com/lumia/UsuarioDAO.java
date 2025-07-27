

package lumia.com.lumia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



/**
 *
 * @author edwar
 */
public class UsuarioDAO {
//RESGISTRAR NUEVO USUARIO
    public void RegistrarUsuario(String nombre,String correo,String contraseña,String tipo){
        
        String sql = "INSERT INTO usuario (nombre,correo,contraseña,tipo) VALUES(?,?,?,?)";
        
       
 
    try (Connection conn=ConexionDB.obtenerConexion();
        PreparedStatement stmt = conn.prepareStatement(sql)){
                
                 //se repplazan los datos en interrogante por datos reales
                stmt.setString (1,nombre);
                stmt.setString(2,correo);
                stmt.setString(3,contraseña);
                stmt.setString(4,tipo);
                
                
               stmt.executeUpdate();
               System.out.println("USUARIO REGISTRADO CORECTAMENTE");
               
        }catch (SQLException e){
             System.out.println("ERROR AL REGISTRAR USUARIO" + e.getMessage()); 
               
    }
}
//metodo para listar usuario
    public void listarUsuarios(){
        String sql="SELECT * FROM usuario";
        
        try  (Connection conn = ConexionDB.obtenerConexion();
                 PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()){
            System.out.println("lista de usuario");
            while (rs.next()){
                int id = rs.getInt("id_usuario");
               String nombre = rs.getString("nombre");
                String correo = rs.getString("correo");
                String tipo = rs.getString("tipo");
            System.out.println(id + " | " + nombre + " | " + correo + " | " + tipo);
            }

        } catch (SQLException e) {
            System.err.println(" Error al listar usuarios: " + e.getMessage());
        }
    }
public Usuario obtenerUsuarioPorCredenciales(String correo, String contraseña) {
        String sql = "SELECT * FROM usuario WHERE correo = ? AND contraseña = ?";
        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, correo);
            stmt.setString(2, contraseña);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Usuario(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("correo"),
                        rs.getString("contraseña"),
                        rs.getString("tipo")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener usuario: " + e.getMessage());
        }
        return null;
    }

    // Validar si un correo ya está registrado
    public boolean existeCorreo(String correo) {
        String sql = "SELECT id FROM usuario WHERE correo = ?";
        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, correo);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.err.println("Error al validar correo: " + e.getMessage());
            return false;
        }
    }
    public boolean actualizarUsuario(Usuario usuario) {
    String sql = "UPDATE usuario SET nombre=?, correo=? WHERE id_usuario=?";
    try (Connection conn = ConexionDB.obtenerConexion();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, usuario.getNombre());
        stmt.setString(2, usuario.getCorreo());
        stmt.setInt(3, usuario.getId());
        return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
         System.out.println("Error al actualizar usuario: " + e.getMessage());
        return false;
    }
}

public boolean eliminarUsuario(int id) {
    String sql = "DELETE FROM usuario WHERE id_usuario=?";
    try (Connection conn = ConexionDB.obtenerConexion();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, id);
        return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
        System.out.println("Error al eliminar usuario: " + e.getMessage());
        return false;
    }
}
}
