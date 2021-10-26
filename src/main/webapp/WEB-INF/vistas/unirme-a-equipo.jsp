<%--
  Created by IntelliJ IDEA.
  User: Scarlet
  Date: 24/10/2021
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Unirme a equipo</title>
    <%@ include file = "partial/header.jsp" %>
</head>
<body>
<%@ include file = "partial/navbar.jsp" %>

<div class="container">
    <div class="row my-5">
        <div class="col-12">
            <table class="table text-center">
                <thead>
                <tr>
                    <th scope="col">Nombre</th>
                    <th scope="col">Tipo</th>
                    <th scope="col">Jugadores Inscriptos</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${EQUIPOS}" var="EQUIPO">
                    <tr class="table-active">
                        <td>${EQUIPO.nombre}</td>
                        <td>${EQUIPO.tipoPartido}</td>
                        <td>${EQUIPO.cantidadJugadores}</td>
                        <td>
                            <form:form action="unirse-a-equipo/${EQUIPO.id}" method="get" modelAttribute="unirse-a-equipo">
                                <c:choose>
                                    <c:when test="${EQUIPO.cantidadJugadores == EQUIPO.tipoPartido}">
                                        <button class="btn text-white" style="background-color: #67b168" type="submit" disabled>Unirme</button>
                                    </c:when>
                                    <c:otherwise>
                                        <button class="btn text-white" style="background-color: #67b168" type="submit" >Unirme</button>
                                    </c:otherwise>
                                </c:choose>
                            </form:form>
                        </td>

                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <c:if test="${not empty error}">
        <div class="col-12">
            <div class="alert alert-danger" role="alert">
                <h6>${error}</h6>
            </div>
        </div>
    </c:if>

</div>




<%@ include file = "partial/scripts.jsp" %>

<%@ include file = "partial/footer.jsp" %>
</body>
</html>
