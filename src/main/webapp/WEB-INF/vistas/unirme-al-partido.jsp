
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Unirme al partido</title>
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
                        <th scope="col">Ubicacion</th>
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
                        <th scope="row">Calle 124</th>
                        <td>${PARTIDO.categoria}</td>
                        <td>${PARTIDO.tipo}</td>
                        <td>${PARTIDO.horario}</td>
                        <td>${PARTIDO.cant_lugaresDisp}</td>
                        <td>
                           <form:form action="union-partido/${PARTIDO.id}" method="get" modelAttribute="unirse-a-partido">
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
