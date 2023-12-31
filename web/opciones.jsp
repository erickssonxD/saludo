<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<h1>Campeonato</h1>
<p>
    Opciones:
    <a href="<c:url value="/AgregarParticipanteServlet" />" >Agregar Participante</a>
    |
    <a href="<c:url value="/ListarParticipanteServlet" />" >Listar Participante</a>
</p>
<hr/>
