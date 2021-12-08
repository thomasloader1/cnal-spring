<%--
  Created by IntelliJ IDEA.
  User: Scarlet
  Date: 05/12/2021
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <%@ include file = "partial/header.jsp" %>
    <title>Fixture Completo</title>
</head>
<body>
<%@ include file = "partial/navbarJugador.jsp" %>
<div class="container py-3 w-100" style="background-image: url('https://images.unsplash.com/photo-1556056504-5c7696c4c28d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=976&q=80'); background-size: cover;background-position: center; background-repeat: no-repeat">
    <h1 class="text-center" style="color: #ffffff; text-shadow: 3px 3px 5px black">TORNEO ${TORNEO.nombre.toUpperCase()}</h1>
    <div class="col-1 mb-1" style="margin: auto">
        <div class="card text-center" style="background-color: #EEEEEE; background-image: url('https://images.emojiterra.com/google/android-11/512px/1f3c6.png'); background-size: contain;background-position: center; background-repeat: no-repeat; height: 80px"></div>
    </div>
    <h3 class="text-center" style="margin-bottom: 1%; margin-top: 15px; color: #FFF323; -webkit-text-stroke: 2px #FFCA03;">CAMPEÓN: ${FINAL.equipoGanador.nombre.toUpperCase()}</h3><hr />
    <h3 class="text-center" style="margin-bottom: 1%; margin-top: -2px; color: #ffffff; text-shadow: 3px 3px 5px black">Final</h3>
    <div class="row justify-content-center">
            <div class="col-3 mb-1">
                <div class="card text-center" style="background-color: #EEEEEE; font-size: 13px;">
                    <div class="card-body">
                        <p class="card-text text-center fs-3 bg-primary text-white bg-gradient pt-1 pb-1">
                            <strong> ${FINAL.equipoUno.nombre.toUpperCase()} vs. ${FINAL.equipoDos.nombre.toUpperCase()} </strong>
                        </p>
                        <p class="card-text">
                            <strong>Torneo: </strong> ${FINAL.torneo.nombre}
                        </p>
                        <p class="card-text">
                            <strong>Horario: </strong> ${FINAL.torneo.horario}
                        </p>
                        <p class="card-text">
                            <strong>Categoría: </strong> ${FINAL.torneo.categoria}
                        </p>
                        <p style="text-shadow: 1px 1px 12px #ffca03"><strong> GANADOR: ¡${FINAL.equipoGanador.nombre.toUpperCase()}!</strong></p>
                    </div>
                </div>
            </div>
    </div>
    <h3 class="text-center" style="margin-bottom: 1%; margin-top: 3%; color: #ffffff; text-shadow: 3px 3px 5px black">Semifinal</h3>
    <div class="row justify-content-center">
        <c:forEach items="${SEMIFINAL}" var="PARTIDO">
            <div class="col-3 mb-1">
                <div class="card text-dark bg-light text-center" style="font-size: 13px;">
                    <div class="card-body">
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
                        <p style="text-shadow: 1px 1px 12px #ffca03"><strong> GANADOR: ¡${PARTIDO.equipoGanador.nombre.toUpperCase()}!</strong></p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <c:choose>
        <c:when test='${PARTIDOS.size() == 7}'>
            <h3 class="text-center" style="margin-bottom: 1%; margin-top: 3%; color: #ffffff; text-shadow: 3px 3px 5px black">Cuartos de Final</h3>
            <div class="row justify-content-center">
                <c:forEach items="${CUARTOSDEFINAL}" var="PARTIDO">
                    <div class="col-3 mb-1">
                        <div class="card text-dark bg-light text-center" style="font-size: 13px">
                            <div class="card-body">
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
                                <p style="text-shadow: 1px 1px 12px #ffca03"><strong> GANADOR: ¡${PARTIDO.equipoGanador.nombre.toUpperCase()}!</strong></p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </c:when>
    </c:choose>
    <div class="d-flex align-item-center">
        <a class="btn btn-secondary" href="/proyecto_limpio_spring_war_exploded/listar-mis-partidos">Volver</a>
    </div>
</div>
<%@ include file = "partial/scripts.jsp" %>
<%@ include file = "partial/footer.jsp" %>
</body>
</html>
