<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "partial/header.jsp" %>
<html>
<head>
    <title>Modificar Cancha</title>
</head>
<body>
<%@ include file = "partial/navbarAdmin.jsp" %>
<div class="container">
    <div class="row my-5">
        <div id="registrarCancha" class="col-md-12">
            <form:form action="/proyecto_limpio_spring_war_exploded/modificar-datos-cancha/${CANCHA.id}" method="get" modelAttribute="modificar-cancha">
                <h3 class="form-signin-heading">Registrar Cancha </h3>
                <hr class="colorgraph"><br>
                <div class="form-outline mb-4">
                    <label class="form-label">Ingrese el nombre de la cancha</label>
                    <input name="nombre" id="defaultRegisterFormNombre" class="form-control" value="${CANCHA.nombre}" required/>
                </div>

                <div class="form-outline mb-4">
                    <label class="form-label">Ingrese la cantidad de canchas disponibles para alquilar</label>
                    <select name="cant_canchas" id="defaultRegisterFormCantCanchas" class="form-control" required>
                        <option selected>Seleccione una opcion</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                    </select>
                </div>

                <div class="form-outline mb-4">
                    <label class="form-label">Ingrese el domicilio</label>
                    <input name="domicilio" id="defaultRegisterFormDomicilio" class="form-control" value="${CANCHA.domicilio}" required/>
                </div>

                <div class="form-outline mb-4">
                    <label class="form-label">Ingrese la localidad</label>
                    <input name="localidad" id="defaultRegisterFormLocalidad" class="form-control" value="${CANCHA.localidad}" required/>
                </div>

                <div class="form-outline mb-4">
                    <label class="form-label">Ingrese el precio por hora</label>
                    <input name="precio" id="defaultRegisterFormPrecio" class="form-control" value="${CANCHA.precio}" required/>
                </div>

                <div class="form-outline mb-4">
                    <label class="form-label">Posee servicio de bar</label>
                    <select name="bar" id="defaultRegisterFormBar" class="form-control" required>
                        <option selected>Seleccione la opcion</option>
                        <option value="true">Si</option>
                        <option value="false">No</option>
                    </select>
                </div>

                <button id="btn-registrar" class="btn btn-primary btn-block" Type="Submit"/>Modificar datos cancha</button>
            </form:form>
            <div class="d-flex">
                <a class="btn btn-secondary" href="/proyecto_limpio_spring_war_exploded/lista-canchas-admin">Volver a Mis Canchas</a>
            </div>

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
