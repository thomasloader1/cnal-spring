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
    <%@ include file = "partial/navbar.jsp" %>

    <div class="container">
        <div class="row">
            <div class="col-12">
                <h2 style="text-align: center; margin-top: 5%">Canchas</h2>
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
                                <form:form action="" method="get" modelAttribute="">
                                    <!--TODO EN VEZ DE IR A LA VISTA COMO TAL DEBERIA OBTENER EL DOMICILIO DE LA CANCHA Y PONERLO EN LA FORM DE CREAR PARTIDO-->
                                    <button class="btn text-white" style="background-color: #67b168" type="submit"><a class="nav-link" style="text-decoration: none; color:white" href="/proyecto_limpio_spring_war_exploded/registro-partido">Crear partido</a></button>
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
