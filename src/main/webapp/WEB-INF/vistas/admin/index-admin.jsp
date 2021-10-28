<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<%@ include file="../partial/header.jsp" %>
<body>
<%@ include file="../partial/navbar.jsp" %>

<div class="container py-3">
    <h3 style="margin-bottom: 3%; margin-top: 3%">Usuarios registrados</h3>
</div>

<div class="container">
    <div class="row my-5">
        <div class="col-12">
            <table class="table text-center">
                <thead>
                <tr>
                    <th scope="col">Email</th>
                    <th scope="col">Equipo</th>
                    <th scope="col">Rol</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${USUARIOS}" var="USUARIO">
                    <tr class="table-active">
                        <th scope="row">${USUARIO.email}</th>
                        <td>${USUARIO.password}</td>
                        <td>${USUARIO.rol}</td>
                        <td>
                            <form:form action="cambio-rol/${USUARIO.id}" method="get">
                                <button class="btn text-white" style="background-color: #67b168" type="submit">Cambiar Rol</button>
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



<%@ include file="../partial/scripts.jsp" %>
<%@ include file="../partial/footer.jsp" %>
</body>
</html>