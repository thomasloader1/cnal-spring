<%--
  Created by IntelliJ IDEA.
  User: Scarlet
  Date: 04/12/2021
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Equipo Ganador</title>
    <%@ include file = "partial/header.jsp" %>
</head>
<body>
<%@ include file = "partial/navbarJugador.jsp" %>

<div class="container">
    <div class="row my-5">
        <div class="col-12 d-flex justify-content-center">
            <div class="card">
                <img class="card-img-top" src="https://scmfutbol.files.wordpress.com/2019/08/soccer-goal.jpg" alt="Card image cap" style="height: 300px">
                <div class="card-body">
                    <h5 class="card-title text-center"><strong>Ganador: ${EQUIPO.nombre.toUpperCase()}</strong></h5>
                </div>
            </div>
        </div>
        <div class="d-flex align-item-center">
            <a class="btn btn-secondary" href="/proyecto_limpio_spring_war_exploded/listar-torneos-equipos">Volver</a>
        </div>
    </div>
</div>


<%@ include file = "partial/footer.jsp" %>


</body>
</html>
