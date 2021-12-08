<%--
  Created by IntelliJ IDEA.
  User: Marcela
  Date: 2/11/2021
  Time: 00:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file = "partial/header.jsp" %>
    <title>Torneo registrado</title>
</head>

<body>
<%@ include file = "partial/navbarJugador.jsp" %>
<div class="container">
    <div class="row my-5">
        <div class="col-12 d-flex justify-content-center">
            <div class="card">
                <img class="card-img-top" src="https://images.unsplash.com/photo-1575361204480-aadea25e6e68?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1171&q=80" alt="Card image cap" style="height: 300px">
                <div class="card-body">
                    <h5 class="card-title"><strong>Categoria: </strong>${torneo.categoria}</h5>
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item"><strong>Horario: </strong>${torneo.horario}</li>
                    <li class="list-group-item"><strong>Cantidad de equipos: </strong>${torneo.cantidadEquipos}</li>
                    <li class="list-group-item"><strong>Tipo de partido: </strong>${torneo.tipo}</li>
                    <li class="list-group-item"><strong>Localidad:</strong> ${torneo.localidad}</li>
                </ul>
            </div>
        </div>
        <div class="d-flex">
            <a class="btn btn-secondary" href="/proyecto_limpio_spring_war_exploded/listar-torneos-equipos">Ir al Fixture</a>
        </div>
        <div class="d-flex">
            <a class="btn btn-secondary" href="/proyecto_limpio_spring_war_exploded/listar-mis-partidos">Volver al Inicio</a>
        </div>
    </div>
</div>

<%@ include file = "partial/scripts.jsp" %>
<%@ include file = "partial/footer.jsp" %>

</body>
</html>