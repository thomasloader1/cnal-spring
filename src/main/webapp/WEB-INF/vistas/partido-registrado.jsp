<%--
  Created by IntelliJ IDEA.
  User: lucas
  Date: 28/9/2021
  Time: 23:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<%@ include file = "partial/header.jsp" %>
    <title>Partido registrado</title>
</head>

<body>
<%@ include file = "partial/navbarJugador.jsp" %>
<div class="container">
    <div class="row my-5">
        <div class="col-12 d-flex justify-content-center">
            <div class="card">
                <img class="card-img-top" src="https://images.unsplash.com/photo-1575361204480-aadea25e6e68?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1171&q=80" alt="Card image cap" style="height: 300px">
                <div class="card-body">
                    <h5 class="card-title"><strong>Categoria: </strong>${partido.categoria}</h5>
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item"><strong>Horario: </strong>${partido.horario}</li>
                    <li class="list-group-item"><strong>Cantidad de jugadores: </strong>${partido.cant_jugadores}</li>
                    <li class="list-group-item"><strong>Tipo de partido: </strong>${partido.tipo}</li>
                    <li class="list-group-item"><strong>Localidad:</strong> ${partido.localidad}</li>
                </ul>
            </div>
        </div>
    </div>
</div>

<%@ include file = "partial/scripts.jsp" %>
<%@ include file = "partial/footer.jsp" %>

</body>
</html>
