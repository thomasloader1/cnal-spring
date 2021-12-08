
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Unirme al partido</title>
    <%@ include file = "partial/header.jsp" %>
</head>
<body>
<%@ include file = "partial/navbarJugador.jsp" %>


    <div class="container">
        <div class="row">
            <div class="col-12">
                <h2 style="text-align: center; margin-top: 5%">Partidos</h2>
            </div>
        </div>
    </div>

    <div class="container">
        <div class="row">
            <div class="col-1">
                <h5>Filtros</h5>
            </div>
            <div class="col-11">
                <form:form action="listar-partidos-filtrados" method="get">
                    <div class="d-flex">
                    <select class="form-control col-3" name="localidad" id="">
                            <option>Localidad</option>
                        <c:forEach items="${LOCALIDAD}" var="LOCALIDAD">
                            <option scope="row" name="localidad">${LOCALIDAD.descripcion}</option>
                        </c:forEach>
                    </select>

                    <select name="categoria" class="form-control col-3">
                        <option>Categoria</option>
                        <option>Juvenil</option>
                        <option>Adulto</option>
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
    </div>

    <div class="container">
        <div class="row my-5">
            <div class="col-12">
                <table class="table text-center">
                    <thead>
                    <tr>
                        <th scope="col">Ubicacion</th>
                        <th scope="col">Localidad</th>
                        <th scope="col">Categoria</th>
                        <th scope="col">Tipo</th>
                        <th scope="col">Horario</th>
                        <th scope="col">Cantidad de lugares disponibles</th>
                        <th scope="col"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${PARTIDOS}" var="PARTIDO">
                    <tr class="table-active">
                        <th scope="row">${PARTIDO.direccion}</th>
                        <td>${PARTIDO.localidad}</td>
                        <td>${PARTIDO.categoria}</td>
                        <td>${PARTIDO.tipo}</td>
                        <td>${PARTIDO.horario}</td>
                        <td>${PARTIDO.cant_lugaresDisp}</td>
                        <td>
                           <form:form action="/proyecto_limpio_spring_war_exploded/union-partido/${PARTIDO.id}" method="get" modelAttribute="unirse-a-partido">
                               <c:choose>
                                   <c:when test="${PARTIDO.cant_lugaresDisp  == 0}">
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

    </div>




<%@ include file = "partial/scripts.jsp" %>

<%@ include file = "partial/footer.jsp" %>
</body>
</html>
