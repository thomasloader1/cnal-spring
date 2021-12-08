<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Scarlet
  Date: 05/12/2021
  Time: 3:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file = "partial/header.jsp" %>
    <title>Final del Torneo</title>
</head>
<body>
<%@ include file = "partial/navbarJugador.jsp" %>
<div class="container" style="background-image: url('https://images.unsplash.com/photo-1556056504-5c7696c4c28d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=976&q=80'); background-size: cover;background-position: center; background-repeat: no-repeat">
    <h1 class="text-center pt-3" style="color: #ffffff; text-shadow: 3px 3px 5px black">TORNEO ${TORNEO.nombre.toUpperCase()}</h1>
    <h2 class="text-center" style="margin-bottom: 3%; margin-top: 3%; color: #ffffff; text-shadow: 3px 3px 5px black">Final de la Copa</h2>
    <div class="row my-5 justify-content-around">
        <div class="col-4 mb-3">
            <div class="card text-dark bg-light text-center" style="background-color: #EEEEEE">
                <div class="card-body">
                    <p class="card-text text-center fs-3 bg-primary text-white bg-gradient pt-1 pb-1">
                        <strong> ${PARTIDOFINAL.equipoUno.nombre.toUpperCase()} vs. ${PARTIDOFINAL.equipoDos.nombre.toUpperCase()} </strong>
                    </p>
                    <p class="card-text">
                        <strong>Torneo: </strong> ${PARTIDOFINAL.torneo.nombre}
                    </p>
                    <p class="card-text">
                        <strong>Horario: </strong> ${PARTIDOFINAL.torneo.horario}
                    </p>
                    <p class="card-text">
                        <strong>Categoría: </strong> ${PARTIDOFINAL.torneo.categoria}
                    </p>
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
                </div>
            </div>
        </div>

    </div>
    <div style="text-align: center">
        <c:choose>
            <c:when test="${PARTIDOFINAL.equipoGanador!=null}">
                <form:form action="../fixture-completo/${PARTIDOFINAL.torneo.id}" method="post" modelAttribute="fixture-completo">
                    <button class="btn btn-primary mt-5 col-3 pt-2 pb-2" type="submit">Ver fixture completo</button>
                </form:form>
            </c:when>
        </c:choose>
    </div>
    <div class="d-flex align-item-center">
        < <a class="btn btn-secondary" href="/proyecto_limpio_spring_war_exploded/listar-torneos-equipos">Volver</a>    </div>
</div>

<%@ include file = "partial/scripts.jsp" %>
<%@ include file = "partial/footer.jsp" %>


</body>
</html>
