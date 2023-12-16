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
        <c:url var="urlForm" value="RegistroServlet" />
        <h1>Registrar Nacimiento</h1>
        <form action="${urlForm}" method="post" style="display: flex; flex-direction: column; max-width: 300px">
            <label for="id">ID:</label>
            <input type="number" name="id" />
            <label for="name">Nombre:</label>
            <input type="text" name="name" />
            <label for="weight">Peso:</label>
            <input type="number" name="weight" />
            <label for="premature">Prematuro:</label>
            <div style="display: flex; flex-direction: row;">
            <input selected type="radio" id="premature" name="premature" value="true" />Si
            <input type="radio" id="premature" name="premature" value="false" />No
            </div>
            <label for="sex">Sexo:</label>
            <div style="display: flex; flex-direction: row;">
            <input selected type="radio" name="sex" value="M" />Masculino
            <input type="radio" name="sex" value="F" />Femenino
            </div>
            <label for="center">Centro:</label>
            <select name="center" id="center">
                <option value="1">Hospital 1</option>
                <option value="2">Hospital 2</option>
                <option value="3">Hospital 3</option>
            </select>
            <input type="submit" value="Registrar" />
        </form>
        <c:if test="${not empty responseID}">
             <p><c:out value="${responseID}"/></p>
        </c:if>
        <c:if test="${not empty responseName}">
             <p><c:out value="${responseName}"/></p>
        </c:if>
        <c:if test="${not empty responseWeight}">
             <p><c:out value="${responseWeight}"/></p>
        </c:if>
        <c:if test="${not empty responsePremature}">
             <p><c:out value="${responsePremature}"/></p>
        </c:if>
        <c:if test="${not empty responseSex}">
             <p><c:out value="${responseSex}"/></p>
        </c:if>
        <c:if test="${not empty responseCenter}">
             <p><c:out value="${responseCenter}"/></p>
        </c:if>
    </body>
</html>
