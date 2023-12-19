<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nacimientos</title>
    </head>
    <body>
        <c:import url="opciones.jsp" />
        <br />
        <c:url var="urlForm" value="EliminarServlet" />
        <h2>Todos los Nacimientos</h2>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Peso</th>
                    <th>Prematuro</th>
                    <th>Sexo</th>
                    <th>Fecha de Nacimiento</th>
                    <th>Centro</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <c:if test="${not empty applicationScope.registro.births}">
                    <c:forEach var="birth" items="${applicationScope.registro.births}">
                        <tr>
                            <td>${birth.id}</td>
                            <td>${birth.nombre}</td>
                            <td>${birth.peso}</td>
                            <td>${birth.prematuro ? 'Sí' : 'No'}</td>
                            <td>${birth.sexo == 'M' ? 'Masculino' : 'Femenino'}</td>
                            <td><fmt:formatDate value="${birth.fechaNacimiento}" pattern="dd/MM/yyyy"/></td>
                            <td>Centro ${birth.centro}</td>
                            <td>
                                <form action="${urlForm}" method="post">
                                    <input type="hidden" name="id" value="${birth.id}">
                                    <input type="submit" value="Eliminar">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
            </tbody>
        </table>
        <c:if test="${not empty responseText}">
            <h2><c:out value="${responseText}"/></h2>
        </c:if>
    </body>
</html>
