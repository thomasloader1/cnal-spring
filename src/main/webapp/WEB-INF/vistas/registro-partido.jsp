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
<%@ include file = "partial/navbar.jsp" %>
    <div class="container">
        <div class="row my-5">
            <div id="registrarPartido" class="col-md-12">
                <form:form action="registrar-partido" method="POST" modelAttribute="partido-nuevo">
                    <h3 class="form-signin-heading">Registrar Partido </h3>
                    <hr class="colorgraph"><br>
                    <div class="form-outline mb-4">
                        <label class="form-label">Ingrese la cantidad de jugadores</label>
                        <input name="cant_jugadores" id="defaultRegisterFormCantidad" class="form-control" />
                    </div>

                    <div class="form-outline mb-4">
                        <label class="form-label">Ingrese tipo de partido</label>
                        <input name="tipo" id="defaultRegisterFormTipo" class="form-control"/>
                    </div>

                    <div class="form-outline mb-4">
                        <label class="form-label">Ingrese la categoria</label>
                        <input name="categoria" id="defaultRegisterFormCategoria" class="form-control"/>
                    </div>

                    <div class="form-outline mb-4">
                        <label class="form-label">Ingrese el horario</label>
                        <input name="horario" id="defaultRegisterFormCategoria" class="form-control"/>
                    </div>
                    <button id="btn-registrar" class="btn btn-primary btn-block" Type="Submit"/>Registrar partido</button>
                </form:form>

                        <c:if test="${not empty msg}">
                <div class="col-12">
                    <div class="alert alert-danger" role="alert">
                            <h6>${msg}</h6>

                    </div>
                </div>
                        </c:if>

            </div>
        </div>
    </div>

    <%@ include file = "partial/scripts.jsp" %>
    <%@ include file = "partial/footer.jsp" %>
</body>
</html>
