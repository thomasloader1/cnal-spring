<%--
  Created by IntelliJ IDEA.
  User: Scarlet
  Date: 09/11/2021
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file = "partial/header.jsp" %>
    <title>Fixture del Torneo</title>
</head>
<body>
    <%@ include file = "partial/navbarJugador.jsp" %>
    <div class="container py-3">
        <h3 style="margin-bottom: 3%; margin-top: 3%">Encuentros Primera Fase</h3>

        <div class="row">
            <c:forEach items="${PARTIDOSTORNEO}" var="PARTIDO">
                <div class="col-4">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Partido: ${PARTIDO.nombre}</h5>
                            <p class="card-text">
                                <strong>Equipo 1:</strong> ${PARTIDO.equipoUno}
                            </p>
                            <p class="card-text">
                                <strong>Equipo 2:</strong> ${PARTIDO.equipoDos}
                            </p>
                            <a href="#!" class="btn btn-primary">Ver jugadores</a> //opcional! Ver si se implementa más adelante
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    <%@ include file = "partial/scripts.jsp" %>
    <%@ include file = "partial/footer.jsp" %>
</body>
</html>
