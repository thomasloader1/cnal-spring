<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "partial/header.jsp" %>
<html>
<head>
    <title>Registrar Partido</title>
</head>
<body>
<%@ include file = "partial/navbarJugador.jsp" %>
    <div class="container">
        <div class="row my-5">
            <div id="registrarPartido" class="col-md-12">
                <form:form action="/proyecto_limpio_spring_war_exploded/registrar-partido/${CANCHA.id}" method="POST" modelAttribute="partido-nuevo">
                    <h3 class="form-signin-heading">Registrar Partido </h3>
                    <hr class="colorgraph"><br>
                    <div class="form-outline mb-4">
                        <label class="form-label">Ingrese la cantidad de jugadores</label>
                        <input name="cant_jugadores" id="defaultRegisterFormCantidad" class="form-control" type="number"/>
                    </div>

                    <div class="form-outline mb-4">
                        <label class="form-label">Ingrese tipo de partido</label>
                        <select class="form-control" name="tipo">
                            <option selected>Seleccione el tipo de partido</option>
                            <option value="5">Futbol 5</option>
                            <option value="11">Futbol 11</option>
                        </select>
                    </div>

                    <div class="form-outline mb-4">
                        <label class="form-label">Ingrese la categoria</label>
                        <select class="form-control" name="categoria">
                            <option selected>Seleccione la categoria</option>
                            <option value="Infantil">Infantil</option>
                            <option value="Juvenil">Juvenil</option>
                            <option value="Adulto">Adulto</option>
                        </select>
                    </div>

                    <div class="form-outline mb-4">
                        <label class="form-label">Domicilio cancha</label>
                        <input name="direccion" id="defaultRegisterFormDireccion" class="form-control" value="${CANCHA.domicilio}" readonly/>
                    </div>

                    <div class="form-outline mb-4">
                        <label class="form-label">Localidad cancha</label>
                        <input name="localidad" id="defaultRegisterFormLocalidad" class="form-control" value="${CANCHA.localidad}" readonly/>
                    </div>

                    <div class="form-outline mb-4">
                        <label class="form-label">Ingrese la fecha</label>
                       <input name="fechaPartido" id="defaultRegisterFormFechaPartido" class="form-control"  type="date">

                    </div>

                    <div class="form-outline mb-4">
                        <label class="form-label">Ingrese el horario</label>
                        <select name="horario" id="defaultRegisterFormHorario" class="form-control">
                            <option selected>Seleccione el horario</option>
                            <option value="15:00">15:00</option>
                            <option value="16:00">16:00</option>
                            <option value="17:00">17:00</option>
                            <option value="18:00">18:00</option>
                            <option value="19:00">19:00</option>
                            <option value="20:00">20:00</option>
                            <option value="21:00">21:00</option>
                            <option value="22:00">22:00</option>
                        </select>
                    </div>
                    <button id="btn-registrar" class="btn btn-primary btn-block" Type="Submit"/>Registrar partido</button>
                </form:form>
                <div class="d-flex">
                    <a class="btn btn-secondary" href="/proyecto_limpio_spring_war_exploded/buscar-cancha">Volver a Canchas</a>
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
