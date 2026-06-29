<%-- 
    Document   : login
    Created on : 28/06/2026, 2:20:08 p. m.
    Author     : edwar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>LUMIA - Iniciar Sesión</title>
    </head>
    <body>
        <h1>Iniciar Sesión - LUMIA</h1>
        
        <!-- Mensaje de error si el login falla -->
        <% if(request.getParameter("error") != null){ %>
            <p style="color:red">Correo o contraseña incorrectos</p>
        <% } %>
        
        <!-- Formulario de login -->
        <form action="LoginServlet" method="post">
            <label>Correo:</label>
            <input type="text" name="correo" required/><br/><br/>
            
            <label>Contraseña:</label>
            <input type="password" name="contrasena" required/><br/><br/>
            
            <input type="submit" value="Entrar"/>
        </form>
        
        <br/>
        <a href="registro.jsp">¿No tienes cuenta? Regístrate</a>
    </body>
</html>
