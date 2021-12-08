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
    <%@ include file = "partial/header.jsp" %>
    <title>Fixture del Torneo</title>
</head>
<body>

    <%@ include file = "partial/navbarJugador.jsp" %>
    <div class="container py-3 w-100" style="background-image: url('https://images.unsplash.com/photo-1556056504-5c7696c4c28d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=976&q=80'); background-size: cover;background-position: center; background-repeat: no-repeat">
        <h1 class="text-center" style="color: #ffffff; text-shadow: 3px 3px 5px black">TORNEO ${TORNEO.nombre.toUpperCase()}</h1>
        <c:choose>
            <c:when test='${PARTIDOSJUGADOS.size() == 7 || (PARTIDOSJUGADOS.size() == 3 && TORNEO.cantidadEquipos.equals("4"))}'>
                <form:form action="../fixture-completo/${PARTIDOSJUGADOS.get(0).torneo.id}" method="post" modelAttribute="partidos-semifinal">
                    <button class="btn btn-primary mt-5 col-4 pt-2 pb-2" type="submit">Ver fixture completo</button>
                </form:form>
            </c:when>
            <c:otherwise>
                <c:choose>
                    <c:when test='${TORNEO.cantidadEquipos.equals("8")}'>
                        <h2 class="text-center" style="margin-bottom: 3%; margin-top: 3%; color: #ffffff; text-shadow: 3px 3px 5px black">Cuartos de Final</h2>
                        <div class="row justify-content-around">
                            <c:forEach items="${PARTIDOSTORNEO}" var="PARTIDO">
                                <c:choose>
                                    <c:when test='${PARTIDO.fase.equals("Cuartos de Final")}'>
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
                                    </c:when>
                                </c:choose>
                            </c:forEach>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <c:choose>
                            <c:when test="${PARTIDOSJUGADOS.size()==6}">
                                <c:choose>
                                    <c:when test='${PARTIDOFINAL.equipoGanador==null}'>
                                        <form:form action="../equipo-ganador/${PARTIDOFINAL.id}" method="POST" modelAttribute="equipo-ganador">
                                            <div class="d-flex justify-content-center mb-3">
                                                <select name="equipoGanador" class="form-control col-10">
                                                    <option>Elegir equipo ganador</option>
                                                    <option>${PARTIDOFINAL.equipoUno.nombre}</option>
                                                    <option>${PARTIDOFINAL.equipoDos.nombre}</option>
                                                </select>
                                            </div>
                                            <button class="btn btn-outline-primary mt-3 col-6"  type="submit">Guardar</button>
                                        </form:form>
                                    </c:when>
                                    <c:otherwise>
                                        <p style="color: #000000; text-shadow: 2px 2px 12px #ffca03; font-size: 18px"><strong>CAMPEÓN: <br>¡${PARTIDOFINAL.equipoGanador.nombre.toUpperCase()}!</strong></p>
                                    </c:otherwise>
                                </c:choose>
                            </c:when>
                            <c:otherwise>
                                <h2 class="text-center" style="margin-bottom: 3%; margin-top: 3%; color: #ffffff; text-shadow: 3px 3px 5px black">Semifinal</h2>
                                <div class="row justify-content-around">
                                    <c:forEach items="${PARTIDOSTORNEO}" var="PARTIDO">
                                        <c:choose>
                                            <c:when test='${PARTIDO.fase.equals("Semifinal")}'>
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
                                            </c:when>
                                        </c:choose>
                                    </c:forEach>
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </c:otherwise>
                </c:choose>

            <div class="text-center">
                    <c:choose>
                        <c:when test='${TORNEO.cantidadEquipos.equals("8")}'>
                            <c:choose>
                                <c:when test="${PARTIDOSTORNEO.size() >= 6}">
                                    <form:form action="../ver-semifinal/${PARTIDOSTORNEO.get(0).torneo.id}" method="post" modelAttribute="semifinal">
                                        <button class="btn btn-primary mt-5 col-4 pt-2 pb-2" type="submit">Ver Partidos Semifinal</button>
                                    </form:form>
                                </c:when>
                                <c:otherwise>
                                    <c:if test="${!not empty error}">
                                         <form:form action="../crear-partidos-semifinal/${PARTIDOSTORNEO.get(0).torneo.id}" method="post" modelAttribute="partidos-semifinal">
                                             <button class="btn btn-primary mt-5 col-4 pt-2 pb-2" type="submit">Crear Partidos Semifinal</button>
                                         </form:form>
                                     </c:if>
                                </c:otherwise>
                            </c:choose>
                        </c:when>
                        <c:otherwise>
                            <c:choose>
                                <c:when test="${PARTIDOSTORNEO.size()==3}">
                                    <form:form action="../ver-partido-final/${PARTIDOSTORNEO.get(0).torneo.id}" method="post" modelAttribute="final">
                                        <button class="btn btn-primary mt-5 col-4 pt-2 pb-2" type="submit">Ver Partido Final</button>
                                    </form:form>
                                </c:when>
                                <c:otherwise>
                                    <c:if test="${!not empty error}">
                                        <form:form action="../crear-partido-final/${PARTIDOSTORNEO.get(0).torneo.id}" method="post" modelAttribute="partido-final">
                                            <button class="btn btn-primary mt-5 col-4 pt-2 pb-2" type="submit">Crear Partido Final</button>
                                        </form:form>
                                    </c:if>
                                </c:otherwise>
                            </c:choose>
                        </c:otherwise>
                    </c:choose>
                    <c:if test="${not empty error}">
                        <div class="col-12">
                            <div class="alert alert-danger" role="alert">
                                <h6>${error}</h6>
                            </div>
                        </div>
                    </c:if>
                </div>
                <a class="btn btn-secondary" href="/proyecto_limpio_spring_war_exploded/listar-torneos-equipos">Volver</a>

            </c:otherwise>
        </c:choose>
    </div>
    <%@ include file = "partial/scripts.jsp" %>
    <%@ include file = "partial/footer.jsp" %>
</body>
</html>
