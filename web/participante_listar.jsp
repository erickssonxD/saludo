<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Participantes</title>
    </head>
    <body>
        <%@include file="opciones.jsp" %>
        <h2>Listar Participantes</h2>

        <form action="<c:url value="/ListarParticipanteServlet" />" method="get">
            Nombre:<input type="text" name="nombre" />
            <input type="submit" value="Buscar" />
        </form>
        <br />

        <c:out value="${mensaje}" />

        <br />
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Sexo</th>
                <th>Distancia</th>
                <th>Categoria</th>
                <th>Accion</th>
            </tr>
            <c:forEach var="p" items="${lstParticipantes}">
                <tr>
                    <td><c:out value="${p.id}" /></td>
                    <td><c:out value="${p.nombre}" /></td>
                    <td><c:out value="${p.sexo}" /></td>
                    <td><c:out value="${p.distancia}" /></td>
                    <td><c:out value="${p.categoria}" /></td>
                    <td>
                        <c:url var="urlEliminar" value="/ListarParticipanteServlet">
                            <c:param name="nombre" value="${param.nombre}" />
                        </c:url>
                        <form action="${urlEliminar}" method="post">
                            <input type="hidden" name="id" value="${p.id}" />
                            <input type="submit" value="Eliminar" />
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>