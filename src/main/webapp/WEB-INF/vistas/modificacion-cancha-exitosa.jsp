<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<%@ include file="partial/header.jsp" %>
<body>
<%@ include file="partial/navbarAdmin.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modificar cancha</title>
</head>
<body>
    <h5>Cancha modificada exitosamente</h5>

    <div class="d-flex">
        <a class="btn btn-secondary" href="/proyecto_limpio_spring_war_exploded/lista-canchas-admin">Volver a Mis Canchas</a>
    </div>
    <%@ include file="partial/scripts.jsp" %>
    <%@ include file="partial/footer.jsp" %>
</body>
</html>
