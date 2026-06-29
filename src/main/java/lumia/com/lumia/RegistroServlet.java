package lumia.com.lumia;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet para registrar nuevos usuarios
 * @author edwar
 */
@WebServlet(name = "RegistroServlet", urlPatterns = {"/RegistroServlet"})
public class RegistroServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Recibir datos del formulario
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");
        String tipo = request.getParameter("tipo");

        // Verificar si el correo ya existe
        UsuarioDAO dao = new UsuarioDAO();
        boolean existe = dao.existeCorreo(correo);

        if (existe) {
            // Correo ya registrado
            response.sendRedirect("registro.jsp?error=1");
        } else {
            // Registrar nuevo usuario
            dao.RegistrarUsuario(nombre, correo, contrasena, tipo);
            response.sendRedirect("registro.jsp?exito=1");
        }
    }
}