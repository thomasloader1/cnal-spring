<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<%@ include file="../partial/header.jsp" %>
<body>

<%@ include file="../partial/navbarAdmin.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Partidos por cancha</title>
</head>
<body>

<div class="container">
    <div class="row my-5">
        <div class="col-12">
            <table class="table text-center">
                <thead>
                <tr>
                    <th scope="col">Categoria</th>
                    <th scope="col">Tipo partido</th>
                    <th scope="col">Direccion</th>
                    <th scope="col">Localidad</th>
                    <th scope="col">Horario</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${PARTIDO}" var="PARTIDO">
                    <tr class="table-active">
                        <th scope="row">${PARTIDO.categoria}</th>
                        <td>${PARTIDO.tipo}</td>
                        <td>${PARTIDO.direccion}</td>
                        <td>${PARTIDO.localidad}</td>
                        <td>${PARTIDO.horario}</td>
                        <td>
                            <form:form action="/proyecto_limpio_spring_war_exploded/ver-jugadores-partido/${PARTIDO.id}" method="get">
                                <button class="btn btn-primary" type="submit">Ver jugadores</button>
                            </form:form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="d-flex">
                <a class="btn btn-secondary" href="/proyecto_limpio_spring_war_exploded/lista-canchas-admin">Volver a Mis Canchas</a>
            </div>
        </div>
    </div>

<%@ include file="../partial/scripts.jsp" %>
<%@ include file="../partial/footer.jsp" %>
</body>
</html>
