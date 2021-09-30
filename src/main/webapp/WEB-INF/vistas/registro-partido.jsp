<%--
  Created by IntelliJ IDEA.
<<<<<<< HEAD
  User: Fede
  Date: 9/28/2021
  Time: 10:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "partial/header.jsp" %>
<html>
<head>
    <title>Registrar Partido</title>
</head>
<body>
    <div id="registrarPartido" class="col-md-6  d-flex align-items-center justify-content-center">
        <form:form action="registrar-partido" method="POST" modelAttribute="partido-nuevo">
            <h3 class="form-signin-heading">Registrar Partido </h3>
            <hr class="colorgraph"><br>
            <div class="form-outline mb-4">
                <input name="cantidad" id="defaultRegisterFormCantidad" class="form-control" />
                <label class="form-label">Ingrese la cantidad de juegadores</label>
            </div>

            <div class="form-outline mb-4">
                <input name="tipo" id="defaultRegisterFormTipo" class="form-control"/>
                <label class="form-label">Ingrese tipo de partido</label>
            </div>

            <div class="form-outline mb-4">
                <input name="categoria" id="defaultRegisterFormCategoria" class="form-control"/>
                <label class="form-label">Ingrese la categoria</label>
            </div>

            <div class="form-outline mb-4">
                <input name="horario" id="defaultRegisterFormCategoria" class="form-control"/>
                <label class="form-label">Ingrese el horario</label>
            </div>
            <button id="btn-registrar" class="btn btn-primary btn-block" Type="Submit"/>Registrar partido</button>
        </form:form>

        <c:if test="${not empty error}">
            <h4><span>${error}</span></h4>
            <br>
        </c:if>
        ${msg}
    </div>

    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>

    <%@ include file = "partial/footer.jsp" %>
</body>
</html>
