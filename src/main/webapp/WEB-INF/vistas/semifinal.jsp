<%--
  Created by IntelliJ IDEA.
  User: Scarlet
  Date: 06/12/2021
  Time: 23:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <%@ include file = "partial/header.jsp" %>
    <title>Semifinal</title>
</head>
<body>
<%@ include file = "partial/navbarJugador.jsp" %>
<div class="container py-3" style="background-image: url('https://images.unsplash.com/photo-1556056504-5c7696c4c28d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=976&q=80'); background-size: cover; background-position: center; background-repeat: no-repeat">
    <div style="opacity: 1">
        <h1 class="text-center" style="margin-bottom: 3%; margin-top: 3%; color: white; text-shadow: 3px 3px 5px black">TORNEO ${TORNEO.nombre.toUpperCase()}</h1>
        <h2 class="text-center" style="margin-bottom: 3%; margin-top: 3%; color: #ffffff; text-shadow: 3px 3px 5px black">Semifinal</h2>
        <div class="row justify-content-around">
            <c:forEach items="${PARTIDOSSEMIFINAL}" var="PARTIDO">
                <div class="col-4 mb-3">
                    <div class="card text-dark bg-light text-center" style="background-color: #EEEEEE">
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
                            <c:choose>
                                <c:when test='${PARTIDO.equipoGanador==null}'>
                                    <form:form action="../equipo-ganador/${PARTIDO.id}" method="POST" modelAttribute="equipo-ganador">
                                        <div class="d-flex justify-content-center mb-3">
                                            <select name="equipoGanador" class="form-control col-10">
                                                <option>Elegir equipo ganador</option>
                                                <option>${PARTIDO.equipoUno.nombre}</option>
                                                <option>${PARTIDO.equipoDos.nombre}</option>
                                            </select>
                                        </div>
                                        <button class="btn btn-outline-primary mt-3 col-6"  type="submit">Guardar</button>
                                    </form:form>
                                </c:when>
                                <c:otherwise>
                                    <p style="text-shadow: 2px 2px 12px #ffca03"><strong> GANADOR: ¡${PARTIDO.equipoGanador.nombre.toUpperCase()}!</strong></p>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="text-center">
            <c:choose>
                <c:when test="${PARTIDOSTORNEO.size()==7}">
                    <form:form action="../ver-partido-final/${PARTIDOSSEMIFINAL.get(0).torneo.id}" method="post" modelAttribute="final">
                        <button class="btn btn-primary mt-5 col-4 pt-2 pb-2" type="submit">Ver Partido Final</button>
                    </form:form>
                </c:when>
                <c:otherwise>
                    <c:if test="${!not empty error}">
                        <form:form action="../crear-partido-final/${PARTIDOSSEMIFINAL.get(0).torneo.id}" method="post" modelAttribute="partido-final">
                            <button class="btn btn-primary mt-5 col-4 pt-2 pb-2" type="submit">Crear Partido Final</button>
                        </form:form>
                    </c:if>
                </c:otherwise>
            </c:choose>
        </div>
        <c:if test="${not empty error}">
            <div class="col-12">
                <div class="alert alert-danger" role="alert">
                    <h6>${error}</h6>
                </div>
            </div>
        </c:if>
    </div>
    <a class="btn btn-secondary" href="/proyecto_limpio_spring_war_exploded/listar-torneos-equipos">Volver</a>
</div>


</body>
</html>
