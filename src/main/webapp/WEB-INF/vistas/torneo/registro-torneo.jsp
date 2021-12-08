<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "../partial/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registrar Torneo</title>
</head>
<body>
<%@ include file = "../partial/navbarJugador.jsp" %>
<div class="container">
    <div class="row my-5">
        <div id="registrarTorneo" class="col-md-12">
            <form:form action="registrar-torneo" method="POST" modelAttribute="torneo-nuevo">
                <h3 class="form-signin-heading">Registrar Torneo </h3>
                <hr class="colorgraph"><br>
                <div class="form-outline mb-4">
                    <label class="form-label">Ingrese el nombre </label>
                    <input name="nombre" id="defaultRegisterFormNombre" class="form-control" />
                </div>

                <div class="form-outline mb-4">
                    <label class="form-label">Ingrese tipo</label>
                    <select class="form-control" name="tipo">
                        <option selected>Seleccione el tipo de partido</option>
                        <option value="5">Futbol 5</option>
                        <option value="11">Futbol 11</option>
                    </select>

                </div>

                <div class="form-outline mb-4">
                    <label class="form-label">Ingrese categoria</label>
                    <select class="form-control" name="categoria">
                        <option selected>Seleccione la categoria</option>
                        <option value="Infantil">Infantil</option>
                        <option value="Juvenil">Juvenil</option>
                        <option value="Adulto">Adulto</option>
                    </select>
                </div>

                <div class="form-outline mb-4">
                    <label class="form-label">Ingrese cantidad de equipos</label>
                    <select class="form-control" name="cantidadEquipos">
                        <option selected>Seleccione la cantidad</option>
                        <option value="4">4</option>
                        <option value="8">8</option>
                    </select>
                </div>

                <div class="form-outline mb-4">
                    <label class="form-label">Ingrese el horario en el que inicia el torneo</label>
                    <input name="horario" id="defaultRegisterFormHorary" class="form-control" />
                </div>

                <div class="form-outline mb-4">
                    <label class="form-label">Ingrese la localidad</label>
                    <select class="form-control col-3" name="localidad" id="">
                        <option>Localidad</option>
                        <c:forEach items="${LOCALIDAD}" var="LOCALIDAD">
                            <option scope="row" name="localidad">${LOCALIDAD.descripcion}</option>
                        </c:forEach>
                    </select>
                </div>

                <button id="btn-registrar" class="btn btn-primary btn-block" Type="Submit"/>Registrar Torneo</button>
            </form:form>
            <div class="d-flex">
                <a class="btn btn-secondary" href="/proyecto_limpio_spring_war_exploded/listar-mis-partidos">Volver al Inicio</a>
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
</body>
</html>
