<%-- 
    Document   : index
    Created on : 13/06/2026, 9:34:34 p. m.
    Author     : edwar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>LUMIA - Bienvenido</title>
    </head>
    <body>
        <h1>Bienvenido a LUMIA</h1>
        <p>Hola, <%= session.getAttribute("nombreUsuario") %></p>
        <a href="logout">Cerrar sesión</a>
    </body>
</html>