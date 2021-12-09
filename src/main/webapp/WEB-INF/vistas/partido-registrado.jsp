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
                    <h5 class="card-title"><strong>Cancha: </strong>${CANCHA.nombre}</h5>
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item"><strong>Categoria: </strong>${partido.categoria}</li>
                    <li class="list-group-item"><strong>Horario: </strong>${partido.horario}</li>
                    <li class="list-group-item"><strong>Cantidad de jugadores: </strong>${partido.cant_jugadores}</li>
                    <li class="list-group-item"><strong>Tipo de partido: </strong>${partido.tipo}</li>
                    <li class="list-group-item"><strong>Direccion:</strong> ${partido.direccion}</li>
                    <li class="list-group-item"><strong>Localidad:</strong> ${partido.localidad}</li>
                    <li class="list-group-item"> <div class="cho-container"></div> </li>
                </ul>

            </div>

        </div>
    </div>
</div>

<%@ include file = "partial/scripts.jsp" %>
<%@ include file = "partial/footer.jsp" %>
<script src="https://sdk.mercadopago.com/js/v2"></script>
<script>
    // Agrega credenciales de SDK
    const mp = new MercadoPago('TEST-d629bab3-7a69-4606-8e5c-c4c40a5ecde7', {
        locale: 'es-AR'
    });
    // Inicializa el checkout
    mp.checkout({
        preference: {
            id: '174501329-d59f8b06-3475-4f0a-8561-24ac3b1ee519'
        },
        render: {
            container: '.cho-container', // Indica el nombre de la clase donde se mostrará el botón de pago
            label: 'Mercado pago', // Cambia el texto del botón de pago (opcional)
        }
    });
</script>
</body>
</html>
