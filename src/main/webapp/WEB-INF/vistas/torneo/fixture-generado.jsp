<%--
  Created by IntelliJ IDEA.
  User: Scarlet
  Date: 09/11/2021
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <%@ include file = "../partial/header.jsp" %>
    <title>Fixture del Torneo</title>
</head>
<body>
    <%@ include file = "../partial/navbarJugador.jsp" %>
    <div class="container py-3">
        <h3 style="margin-bottom: 3%; margin-top: 3%">Encuentros Primera Fase</h3>

        <div class="row">
            <c:forEach items="${PARTIDOSTORNEO}" var="PARTIDO">
                <div class="col-4 mb-3">
                    <div class="card">
                        <div class="card-body">
                            <%--<h5 class="card-title">Partido: ${PARTIDO.nombre}</h5>--%>
                            <p class="card-text text-center fs-3 bg-primary text-white bg-gradient pt-1 pb-1">
                                <strong> ${PARTIDO.equipoUno.nombre.toUpperCase()} vs. ${PARTIDO.equipoDos.nombre.toUpperCase()} </strong>
                            </p>
                            <p class="card-text">
                                <strong>Torneo: </strong> ${PARTIDO.torneo.nombre}
                            </p>
                            <p class="card-text">
                                <strong>Horario: </strong> ${PARTIDO.torneo.horario}
                            </p>
                            <p class="card-text">
                                <strong>Categoría: </strong> ${PARTIDO.torneo.categoria}
                            </p>
                            <p class="card-text">
                                <strong>Localidad: </strong> ${PARTIDO.torneo.localidad}
                            </p>
                            <%--<a href="#!" class="btn btn-primary">Ver jugadores</a> //opcional! Ver si se implementa más adelante--%>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    <%@ include file = "../partial/scripts.jsp" %>
    <%@ include file = "../partial/footer.jsp" %>
</body>
</html>
