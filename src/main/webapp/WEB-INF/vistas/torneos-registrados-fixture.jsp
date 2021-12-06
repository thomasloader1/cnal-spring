<%--
  Created by IntelliJ IDEA.
  User: Scarlet
  Date: 11/11/2021
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Torneos</title>
    <%@ include file = "partial/header.jsp" %>
</head>
<body>
<%@ include file = "partial/navbarJugador.jsp" %>

<div class="container py-3" style="background-image: url('https://images.unsplash.com/photo-1556056504-5c7696c4c28d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=976&q=80'); background-size: cover; background-position: center; background-repeat: no-repeat">
    <div style="opacity: 1">
        <h1 class="text-center" style="margin-bottom: 3%; margin-top: 3%; color: white; text-shadow: 3px 3px 5px black">TORNEOS ACTUALES</h1>
        <div class="row justify-content-around">
            <c:forEach items="${TORNEOSEQUIPOS}" var="TORNEO">
                <div class="col-4">
                    <div class="card mb-4 text-center" style="background-color: #EEEEEE">
                        <div class="card-body">
                            <h5 class="card-title">Torneo: ${TORNEO.nombre}</h5>
                            <p class="card-text">
                                <strong>Localidad:</strong> ${TORNEO.localidad}
                            </p>
                            <p class="card-text">
                                <strong>Cantidad de Equipos:</strong> ${TORNEO.cantidadEquipos}
                            </p>
                            <c:choose>
                                <c:when test='${TORNEO.fixtureCreado==true}'>
                                    <form:form action="ver-fixture/${TORNEO.id}" method="POST" modelAttribute="ver-fixture">
                                        <button class="btn btn-primary" style="margin-top: 10px; padding-left: 20px; padding-right: 20px" type="submit">Ver fixture</button>
                                    </form:form>
                                </c:when>
                                <c:otherwise>
                                    <form:form action="crear-fixture/${TORNEO.id}" method="POST" modelAttribute="crear-fixture">
                                        <button class="btn btn-primary" style="margin-top: 10px; padding-left: 20px; padding-right: 20px" type="submit">Crear fixture</button>
                                    </form:form>
                                </c:otherwise>
                            </c:choose>

                        </div>
                    </div>
                </div>
            </c:forEach>

            <c:if test="${not empty error}">
                <div class="col-12">
                    <div class="alert alert-danger" role="alert">
                        <h6>${error}</h6>
                    </div>
                </div>
            </c:if>
        </div>
    </div>

    <input class="btn btn-secondary mt-5"  type="submit" value="Volver" onclick="history.back()"></input>
</div>


</body>
</html>
