<%-- 
    Document   : mensaje.jsp
    Created on : Dec 10, 2023, 10:19:21 PM
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
        <h2> Hola <%= request.getAttribute("mensaje") %> </h2>
    </body>
</html>
