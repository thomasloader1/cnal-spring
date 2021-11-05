<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<%@ include file="partial/header.jsp" %>
<body>
<%@ include file="partial/navbarAdmin.jsp" %>

<div class="container">
    <div class="row">
        <div class="col-12">
            <div class="col-10">
                <h3>Lista de Reportes</h3>
            </div>

            <div class="col-2">
                <form:form action="/proyecto_limpio_spring_war_exploded/sancionarUsuario/${IDUSUARIO}" method="get">
                    <button class="btn btn-danger"type="submit">Sancionar Jugador</button>
                </form:form>
            </div>
        </div>
    </div>
</div>


<div class="container">
    <div class="row my-5">
        <div class="col-12">
            <table class="table text-center">
                <thead>
                <tr>
                    <th scope="col">Id Usuario</th>
                    <th scope="col">Motivo</th>
                    <th scope="col">Descripcion</th>
                    <th scope="col">Fecha Reporte</th>
                    <th scope="col">Aprobado</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${REPORTES}" var="REPORTES">
                    <tr class="table-active">
                        <th scope="row">${REPORTES.idUsuario}</th>
                        <td>${REPORTES.motivo}</td>
                        <td>${REPORTES.descripcion}</td>
                        <td>${REPORTES.fechaReporte}</td>
                        <td>${REPORTES.aprobado}</td>
                        <td>
                            <form:form action="/proyecto_limpio_spring_war_exploded/aprobar-reporte-usuario/${REPORTES.idReporte}" method="get">
                                <button class="btn text-white" style="background-color: #67b168" type="submit">Aprobar reporte</button>
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
