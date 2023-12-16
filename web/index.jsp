<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mensajes</title>
    </head>
    <body>
        <c:import url="opciones.jsp" />
        <c:url var="urlForm" value="RegistroServlet" />
        <form action="${urlForm}" method="post">
            Mensaje: <input type="text" name="mensaje" />
            <input type="submit" value="Enviar" />
        </form>
        <c:if test="${not empty respuesta}">
             <h2><c:out value="${respuesta}"/></h2>
        </c:if>
    </body>
</html>
