<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "partial/header.jsp" %>
<html>
<head>
    <title>Registrar Equipo</title>
</head>
<body>
<%@ include file = "partial/navbar.jsp" %>
<div class="container">
    <div class="row my-5">
        <div id="registrarEquipo" class="col-md-12">
            <form:form action="registrar-equipo" method="POST" modelAttribute="equipo-nuevo">
                <h3 class="form-signin-heading">Registrar Equipo </h3>
                <hr class="colorgraph"><br>
                    <div class="form-outline mb-4">
                        <label class="form-label">Ingrese el nombre </label>
                        <input name="nombre" id="defaultRegisterFormNombre" class="form-control" />
                    </div>

                    <div class="form-outline mb-4">
                        <label class="form-label">Ingrese tipo</label>
                        <input type="number" name="tipoPartido" id="defaultRegisterFormDomicilio" class="form-control"/>
                    </div>

                    <div class="form-outline mb-4">
                        <label class="form-label">Ingrese categoria</label>
                        <input name="categoria" id="defaultRegisterFormLocalidad" class="form-control"/>
                    </div>

<%--
                <div class="form-outline mb-4">
                    <label class="form-label">Ingrese cantidad jugadores</label>
                        <input type="number" name="cantidadJugadores" id="defaultRegisterFormCantidad" class="form-control"/>
                </div>
--%>


                <button id="btn-registrar" class="btn btn-primary btn-block" Type="Submit"/>Registrar Equipo</button>
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
