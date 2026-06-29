<%-- 
    Document   : registro
    Created on : 28/06/2026, 3:28:28 p. m.
    Author     : edwar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>LUMIA - Registro</title>
    </head>
    <body>
        <h1>Registro - LUMIA</h1>

        <!-- Mensaje de éxito -->
        <% if(request.getParameter("exito") != null){ %>
            <p style="color:green">¡Usuario registrado correctamente!</p>
        <% } %>

        <!-- Mensaje de error -->
        <% if(request.getParameter("error") != null){ %>
            <p style="color:red">El correo ya está registrado</p>
        <% } %>

        <!-- Formulario de registro -->
        <form action="RegistroServlet" method="post">
            <label>Nombre:</label>
            <input type="text" name="nombre" required/><br/><br/>

            <label>Correo:</label>
            <input type="email" name="correo" required/><br/><br/>

            <label>Contraseña:</label>
            <input type="password" name="contrasena" required/><br/><br/>

            <label>Tipo:</label>
            <select name="tipo">
                <option value="estudiante">Estudiante</option>
                <option value="profesor">Profesor</option>
            </select><br/><br/>

            <input type="submit" value="Registrarse"/>
        </form>

        <br/>
        <a href="Login.jsp">¿Ya tienes cuenta? Inicia sesión</a>
    </body>
</html>
