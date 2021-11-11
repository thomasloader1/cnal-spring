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

<div class="container py-3">
    <h3 style="margin-bottom: 3%; margin-top: 3%">Torneos Actuales</h3>

    <div class="row">
        <c:forEach items="${TORNEOSEQUIPOS}" var="TORNEO">
            <div class="col-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Torneo: ${TORNEO.nombre}</h5>
                        <p class="card-text">
                            <strong>Localidad:</strong> ${TORNEO.localidad}
                        </p>
                        <p class="card-text">
                            <strong>Cantidad de Equipos:</strong> ${TORNEO.cantidadEquipos}
                        </p>
                        <p class="card-text">
                            <strong>Equipos:</strong>
                        </p>

                        <form:form action="crear-fixture/${TORNEO.id}" method="POST" modelAttribute="crear-fixture">

                            <button class="btn text-white" style="background-color: #67b168" type="submit">Crear el fixture</button>

                        </form:form>
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


</body>
</html>
