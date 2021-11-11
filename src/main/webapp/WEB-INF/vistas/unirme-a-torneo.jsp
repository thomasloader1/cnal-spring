<%--
  Created by IntelliJ IDEA.
  User: Marcela
  Date: 3/11/2021
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Unirme a un torneo</title>
    <%@ include file = "partial/header.jsp" %>
</head>
<body>
<%@ include file = "partial/navbarJugador.jsp" %>

<%-- <div class="container">
    <div class="row">
        <div class="col-1">
            <h5>Filtros</h5>
        </div>
        <div class="col-11">
            <form:form action="listar-equipos-filtrados" method="get">
                <div class="d-flex">
                    <select name="tipoPartido" class="form-control col-3">
                        <option value="0">Tipo de Partido</option>
                        <option value="5">Futbol 5</option>
                        <option value="11">Futbol 11</option>
                    </select>
                    <button class="btn btn-primary my-2 my-sm-0" type="submit">Buscar</button>
                </div>
            </form:form>
        </div>
    </div>
</div>

<div class="container">
    <div class="row">
        <c:if test="${not empty msg}">
            <div class="col-12">
                <div class="alert text-danger" role="alert">
                    <h6>${msg}</h6>
                </div>
            </div>
        </c:if>
    </div>
</div>--%>

<div class="container">
    <div class="row my-5">
        <div class="col-12">
            <table class="table text-center">
                <thead>
                <tr>
                    <th scope="col">Nombre</th>
                    <th scope="col">Tipo</th>
                    <th scope="col">Equipos Inscriptos</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${torneos}" var="torneo">
                    <tr class="table-active">
                        <td>${torneo.nombre}</td>
                        <td>${torneo.tipo}</td>
                        <td>${torneo.cantidadEquipos}</td>
                        <td>
                            <%--@elvariable id="unirse-a-torneo" type=""--%>
                            <form:form action="unirse-a-torneo/${torneo.id}" method="get" modelAttribute="unirse-a-torneo">
                                <c:choose>
                                    <c:when test="${torneo.equiposInscriptos.size() == 4  && torneo.cantidadEquipos == 4 || torneo.equiposInscriptos.size() == 8 && torneo.cantidadEquipos == 8 }">
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
