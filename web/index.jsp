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
            <input type="number" name="id" value="${id}"/>
            <label for="name">Nombre:</label>
            <input type="text" name="name" value="${name}"/>
            <label for="weight">Peso:</label>
            <input type="number" name="weight" value="${weight}"/>
            <label for="premature">Prematuro:</label>
            <div style="display: flex; flex-direction: row;">
                <input selected type="radio" id="premature" name="premature" value="true"
                       <c:if test="${premature == true}">checked</c:if>
                           />Si
                       <input type="radio" id="premature" name="premature" value="false"
                       <c:if test="${premature == false}">checked</c:if>
                           />No
                </div>
                <label for="sex">Sexo:</label>
                <div style="display: flex; flex-direction: row;">
                    <input selected type="radio" name="sex" value="M"
                    <c:if test="${sex == 'M'}">checked</c:if>
                        />Masculino
                    <input type="radio" name="sex" value="F"
                    <c:if test="${sex == 'F'}">checked</c:if>
                        />Femenino
                </div>
                <label for="center">Centro:</label>
                <select name="center" id="center">
                    <option value="" disabled
                    <c:if test="${center == null}">selected</c:if>
                        >--Seleccionar--</option>
                    <option value="1" <c:if test="${center == 1}">selected</c:if>>Hospital 1</option>
                <option value="2" <c:if test="${center == 2}">selected</c:if>>Hospital 2</option>
                <option value="3 <c:if test="${center == 3}">selected</c:if>">Hospital 3</option>
                </select>
                <input type="submit" value="Registrar" />git
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
