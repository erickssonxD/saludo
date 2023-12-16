<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mensajes</title>
    </head>
    <body>
        <c:import url="opciones.jsp" />
        <h2>Mis Mensajes</h2>
        <c:if test="${not empty sessionScope.registro.lstMensajes}">
            <ul>
                <c:forEach var="msg" items="${sessionScope.registro.lstMensajes}">
                    <li>
                        <c:out value="${msg.texto}"/>
                        <fmt:formatDate value="${msg.fecha}" pattern="dd/MM/yyyy HH:mm:ss"/>
                    </li>
                </c:forEach>
            </ul>
        </c:if>
    </body>
</html>

