<%--
  Created by IntelliJ IDEA.
  User: Fede
  Date: 10/14/2021
  Time: 7:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Buscar cancha</title>
    <%@ include file = "partial/header.jsp" %>
</head>
<body>
    <%@ include file = "partial/navbarJugador.jsp" %>

    <div class="container">
        <div class="row">
            <div class="col-12">
                <h2 style="text-align: center; margin-top: 5%">Canchas</h2>
            </div>
        </div>
    </div>

    <div class="container">
        <div class="row">
            <div class="col-1">
                <h5>Filtros</h5>
            </div>
            <div class="col-11 ">
                <form:form action="listar-canchas-filtradas" method="get">
                    <div class="d-flex">
                    <select class="form-control col-3" name="localidad" id="">
                        <option>Localidad</option>
                            <c:forEach items="${LOCALIDAD}" var="LOCALIDAD">
                                <option scope="row" name="localidad">${LOCALIDAD.descripcion}</option>
                            </c:forEach>
                    </select>
                    <button class="btn btn-primary my-2 my-sm-0 " type="submit">Buscar</button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>

    <div class="container">
        <div class="row my-5">
            <div class="col-12">
                <table class="table text-center">
                    <thead>
                    <tr>
                        <th scope="col">Nombre</th>
                        <th scope="col">Docimilio</th>
                        <th scope="col">Localidad</th>
                        <th scope="col"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${CANCHA}" var="CANCHA">
                        <tr class="table-active">
                            <th scope="row">${CANCHA.nombre}</th>
                            <td>${CANCHA.domicilio}</td>
                            <td>${CANCHA.localidad}</td>
                            <td>
                                <form:form action="/proyecto_limpio_spring_war_exploded/reservar-cancha/${CANCHA.id}" method="POST">
                                    <button class="btn btn-primary" type="submit">Crear partido en esta cancha</button>
                                </form:form>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="d-flex">
                    <a class="btn btn-secondary" href="/proyecto_limpio_spring_war_exploded/listar-mis-partidos">Volver al Inicio</a>
                </div>
            </div>
        </div>
        <c:if test="${not empty msg}">
            <div class="col-12">
                <div class="alert alert-danger" role="alert">
                    <h6>${msg}</h6>
                </div>
            </div>
        </c:if>

    </div>

    <%@ include file = "partial/scripts.jsp" %>

    <%@ include file = "partial/footer.jsp" %>
</body>
</html>
