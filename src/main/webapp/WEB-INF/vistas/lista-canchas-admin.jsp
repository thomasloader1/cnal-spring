<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<%@ include file="partial/header.jsp" %>
<body>
<%@ include file="partial/navbarAdmin.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista canchas</title>
</head>
<body>


<div class="container">
    <div class="row my-5">
        <div class="col-12">
            <table class="table text-center">
                <thead>
                <tr>
                    <th scope="col">Nombre</th>
                    <th scope="col">Domicilio</th>
                    <th scope="col">Localidad</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${CANCHA}" var="CANCHA">
                    <tr class="table-active">
                        <th scope="row">${CANCHA.nombre}</th>
                        <td>${CANCHA.domicilio}</td>
                        <td>${CANCHA.domicilio}</td>
                        <td>
                            <form:form action="/proyecto_limpio_spring_war_exploded/partidos-por-cancha/${CANCHA.id}" method="get">
                                <button class="btn btn-primary" type="submit">Ver partidos</button>
                            </form:form>
                        </td>

                        <td>
                            <form:form action="/proyecto_limpio_spring_war_exploded/ir-a-modificar-datos-cancha/${CANCHA.id}" method="get">
                                <button class="btn btn-primary" type="submit">Modificar datos cancha</button>
                            </form:form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

<%@ include file="partial/scripts.jsp" %>
<%@ include file="partial/footer.jsp" %>
</body>
</html>
