<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "partial/header.jsp" %>
<html>
<head>
    <title>Registrar Cancha</title>
</head>
<body>
<%@ include file = "partial/navbar.jsp" %>
<div class="container">
    <div class="row my-5">
        <div id="registrarCancha" class="col-md-12">
            <form:form action="registrar-cancha" method="POST" modelAttribute="cancha-nueva">
                <h3 class="form-signin-heading">Registrar Cancha </h3>
                <hr class="colorgraph"><br>
                <div class="form-outline mb-4">
                    <label class="form-label">Ingrese el nombre de la cancha</label>
                    <input name="nombre" id="defaultRegisterFormNombre" class="form-control" />
                </div>

                <div class="form-outline mb-4">
                    <label class="form-label">Ingrese el domicilio</label>
                    <input name="domicilio" id="defaultRegisterFormDomicilio" class="form-control"/>
                </div>

                <div class="form-outline mb-4">
                    <label class="form-label">Ingrese la localidad</label>
                    <input name="localidad" id="defaultRegisterFormLocalidad" class="form-control"/>
                </div>

                <button id="btn-registrar" class="btn btn-primary btn-block" Type="Submit"/>Registrar cancha</button>
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
