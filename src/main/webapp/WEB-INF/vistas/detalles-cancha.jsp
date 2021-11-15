<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "partial/header.jsp" %>
<html>
<head>
    <title>Detalles cancha</title>
</head>
<body>
<%@ include file = "partial/navbarJugador.jsp" %>



<div class="container">
    <h3  style="margin-bottom: 3%; margin-top: 3%; text-align: center">Detalles cancha</h3>

    <div class="row">
        <div class="col-2"></div>
            <div class="col-8" style="margin-bottom: 5%">
                <div class="card">
                    <img
                            src="https://images.unsplash.com/photo-1575361204480-aadea25e6e68?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1171&q=80"
                            class="card-img-top"
                            alt="..."
                    />
                    <div class="card-body">
                        <h5 class="card-title">Nombre: ${CANCHA.nombre}</h5>
                        <p class="card-text">
                            <strong>Ubicacion:</strong> ${CANCHA.domicilio}
                        </p>
                        <p class="card-text">
                            <strong>Localidad:</strong> ${CANCHA.localidad}
                        </p>
                        <p class="card-text">
                            <strong>Cantidad de canchas:</strong> ${CANCHA.cant_canchas}
                        </p>
                        <p class="card-text">
                            <strong>Precio por hora:</strong> ${CANCHA.precio}
                        </p>
                        <p class="card-text">
                            <strong>Dispone de bar:</strong> ${RESPUESTA}
                        </p>

                        <div style="margin-left: 40%">
                            <form:form action="/proyecto_limpio_spring_war_exploded/registro-partido/${CANCHA.id}" method="post">
                                <button class="btn btn-primary" type="submit">Reservar partido</button>
                            </form:form>
                        </div>

                    </div>
                </div>
            </div>
    </div>

</div>





<%@ include file = "partial/scripts.jsp" %>
<%@ include file = "partial/footer.jsp" %>
</body>
</html>
