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
<%@ include file = "partial/header.jsp" %>
<body>
<c:choose>
    <c:when test="${USUARIO_ACTUAL.rol == 'Jugador'}">
        <%@ include file = "partial/navbarJugador.jsp" %>
    </c:when>
    <c:otherwise>
        <%@ include file = "partial/navbarAdmin.jsp" %>
    </c:otherwise>
</c:choose>

<div class="container">
    <div class="row my-5">
        <div class="col-12 d-flex justify-content-center">
            <div class="card">
                <h3>Reporte enviado con exito</h3>
                <img class="card-img-top" src="https://images.unsplash.com/photo-1575361204480-aadea25e6e68?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1171&q=80" alt="Card image cap" style="height: 300px">
                <div class="card-body">
                    <h5 class="card-title"><strong>Motivo: </strong>${REPORTE.motivo}</h5>
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item"><strong>Descripcion: </strong>${REPORTE.descripcion}</li>
                </ul>
            </div>
        </div>
    </div>
</div>

<%@ include file = "partial/scripts.jsp" %>
<%@ include file = "partial/footer.jsp" %>
</body>
</html>
