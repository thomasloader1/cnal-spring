<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <div class="row">
        <div class="col-12">

        <form:form modelAttribute="datos-reporte" action="/proyecto_limpio_spring_war_exploded/enviar-reporte-usuario/${IDUSUARIO}" method="post">
                <div>
                    <h3>Formulario de Reporte</h3>
                </div>
                <div class="mb-3">
                    <label for="motivo" class="form-label">Motivo del reporte</label>
                    <input path="motivo" name="motivo" id="motivo" class="form-control">
                </div>

                <div class="mb-3">
                    <label for="descripcion" class="form-label">Descripcion del problema</label>
                    <textarea path="descripcion" name="descripcion" id="descripcion" class="form-control"></textarea>
                </div>
                <button class="btn btn-lg btn-primary btn-block" Type="Submit">Enviar reporte</button>
            </form:form>
        </div>
        </div>
</div>



<%@ include file = "../partial/scripts.jsp" %>
<%@ include file = "../partial/footer.jsp" %>
</body>
</html>