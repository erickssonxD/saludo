<%-- 
    Document   : index
    Created on : Dec 10, 2023, 6:44:59 PM
    Author     : Erick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Saludos</title>
    </head>
    <body>
        <form action="SaludoServlet" method="POST">
            Nombre: <input type="text" name="nombre" /><br>
            <input type="submit" value="Enviar" />
        </form>
    </body>
</html>
