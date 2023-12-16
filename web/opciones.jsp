<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<p>
    Opciones:
    <a href="<c:url value="/index.jsp" />" >Nuevo Mensaje</a>
    <a href="<c:url value="/listar_session.jsp" />" >Listar Tus Mensajes</a>
    <a href="<c:url value="/listar_application.jsp" />" >Listar Todos los Mensajes</a>
</p>
<hr/>
