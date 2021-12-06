<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Scarlet
  Date: 05/12/2021
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file = "partial/header.jsp" %>
    <title>Campeón del Torneo</title>
</head>
<body>
<%@ include file = "partial/navbarJugador.jsp" %>
<div class="container" style="background-image: url('https://acegif.com/wp-content/gif/confetti-31.gif'); background-size: cover;background-position: center; background-repeat: no-repeat">
    <h1 class="text-center pt-3" style="color: #000000">CAMPEÓN DEL TORNEO ${TORNEO.nombre.toUpperCase()}</h1>
    <div class="row my-5 justify-content-around">
        <div class="col-4 mb-3">
            <div class="card text-dark bg-light text-center" style="background-color: #EEEEEE; background-image: url('https://images.emojiterra.com/google/android-11/512px/1f3c6.png'); background-size: contain;background-position: center; background-repeat: no-repeat; height: 400px;">
                <div class="card-body" >
                    <h2 class="card-text text-center fs-3 pt-1 pb-1" style="position: absolute; bottom: 15%; left: 20%; right: 20%; font-size: 13px">
                        <strong> ${nombreEquipo.toUpperCase()} </strong>
                    </h2>
                </div>
            </div>
        </div>
    </div>
    <div style="text-align: center">
        <c:choose>
            <c:when test="${PARTIDOFINAL.equipoGanador!=null}">
                <form:form action="../fixture-completo/${PARTIDOFINAL.torneo.id}" method="post" modelAttribute="fixture-completo">
                    <button class="btn btn-primary col-3 pt-1 pb-2" type="submit">Ver fixture completo</button>
                </form:form>
            </c:when>
        </c:choose>
    </div>
    <div class="d-flex align-item-center">
        <a class="btn btn-secondary" href="/proyecto_limpio_spring_war_exploded/listar-torneos-equipos">Volver</a>
    </div>
</div>

<%@ include file = "partial/scripts.jsp" %>
<%@ include file = "partial/footer.jsp" %>
</body>
</html>
