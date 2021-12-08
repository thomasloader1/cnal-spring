<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Fede
  Date: 31/10/2021
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<%@ include file = "../partial/header.jsp" %>
<body>

<c:choose>
    <c:when test="${USUARIO_ACTUAL.rol == 'Jugador'}">
        <%@ include file = "../partial/navbarJugador.jsp" %>
    </c:when>
    <c:otherwise>
        <%@ include file = "../partial/navbarAdmin.jsp" %>
    </c:otherwise>
</c:choose>

<div class="container">
    <div class="row my-5">
        <div class="col-12">
            <table class="table text-center">
                <thead>
                <tr>
                    <th scope="col">Email</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Apellido</th>
                    <th scope="col">Equipo</th>
                    <th scope="col">Fecha Sancion</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${USUARIO}" var="USUARIO">
                    <tr class="table-active">
                        <th scope="row">${USUARIO.email}</th>
                        <td>${USUARIO.nombre}</td>
                        <td>${USUARIO.apellido}</td>
                        <td>${USUARIO.equipo.nombre}</td>
                        <td>${USUARIO.fechaSancion}</td>
                        <td>
                            <form:form action="/proyecto_limpio_spring_war_exploded/reportar-usuario/${USUARIO.id}" method="GET">
                                <button class="btn btn-danger" type="submit">Reportar Jugador</button>
                            </form:form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>



<%@ include file = "../partial/scripts.jsp" %>
<%@ include file = "../partial/footer.jsp" %>
</body>
</html>
