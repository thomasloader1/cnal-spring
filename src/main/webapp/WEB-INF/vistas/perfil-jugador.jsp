@@ -1,65 +0,0 @@
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<%@ include file = "partial/header.jsp" %>
<body>
<%@ include file = "partial/navbarJugador.jsp" %>
<div class="container mt-2">

    <div class="row">
        <div class="col-md-3">
            <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                <a class="btn btn-outline-secondary waves-effect mb-1" id="v-pills-home-tab" data-toggle="pill" href="#v-pills-home" role="tab" aria-controls="v-pills-home" aria-selected="true"><strong>Informacion personal</strong></a>
                <a class="btn btn-outline-secondary waves-effect mb-1" id="v-pills-profile-tab" data-toggle="pill" href="#v-pills-profile" role="tab" aria-controls="v-pills-profile" aria-selected="false"><strong>Datos de facturacion</strong></a>
                <a class="btn btn-outline-secondary waves-effect mb-1" id="v-pills-messages-tab" data-toggle="pill" href="#v-pills-messages" role="tab" aria-controls="v-pills-messages" aria-selected="false"><strong>Cambiar contrasena</strong></a>
                <form:form class="nav flex-column nav-pills" id="v-pills-tab" action="/proyecto_limpio_spring_war_exploded/ver-mis-reportes" method="GET">
                    <button class="btn btn-outline-secondary waves-effect mb-1 col-mb-3" type="submit"><strong>Mis Reportes</strong></button>
                    <!--<a class="btn btn-outline-secondary waves-effect mb-1" id="v-pills-report-tab" data-toggle="pill" role="tab" aria-controls="v-pills-report" aria-selected="false"><strong>Mis Reportes</strong></a>-->
                </form:form>
                <a class="btn btn-secondary waves-effect" href="/proyecto_limpio_spring_war_exploded/cerrarSesion"><strong>Cerrar sesion</strong></a>
            </div>

        </div>
        <div class="col-8 mt-2">
            <div class="tab-content" id="v-pills-tabContent">
                <div class="tab-pane fade show active" id="v-pills-home" role="tabpanel" aria-labelledby="v-pills-home-tab">
                    <div class = "container mt-2 mb-2">
                        <h1 class="text-center">Informacion personal</h1>
                        <hr>
                    </div>
                    <label>Usuario</label>
                    <input type="text" class="form-control mb-4" placeholder="${usuario.email}" readonly>
                    <label>Nombre y apellido</label>
                    <input type="text" class="form-control mb-4" placeholder="${usuario.nombre}${usuario.apellido}" readonly>
                    <label>Equipo</label>
                    <input type="text" class="form-control mb-4" placeholder="${usuario.equipo.nombre}" readonly>
                    <label>Fecha sancion</label>
                    <input type="text" class="form-control mb-4" placeholder="${usuario.fechaSancion}" readonly>
                </div>
                <div class="tab-pane fade show " id="v-pills-profile" role="tabpanel" aria-labelledby="v-pills-profile-tab">
                    <div class = "container mt-2 mb-2">
                        <h1 class="text-center">Datos de facturacion</h1>
                        <hr>
                    </div>
                    <label>Numero de tarjeta</label>
                    <input type="text" class="form-control mb-4" placeholder="5547 0000 5481 9863" readonly>
                    <label>Cod de seguridad</label>
                    <input type="text" class="form-control mb-4" placeholder="001" readonly>
                    <label>Fecha de vencimiento</label>
                    <input type="text" class="form-control mb-4" placeholder="11/25" readonly>
                </div>
                <div class="tab-pane fade show " id="v-pills-messages" role="tabpanel" aria-labelledby="v-pills-messages-tab">
                    <div class = "container mt-2 mb-2">
                        <h1 class="text-center">Cambiar contrasena</h1>
                        <hr>
                    </div>
                    <label>Contrasena actual</label>
                    <input type="password" class="form-control mb-4">
                    <label>Nueva contrasena</label>
                    <input type="password" class="form-control mb-4">
                    <button class="btn btn-dark float-right" type="button">Confirmar</button>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file = "partial/scripts.jsp" %>
<%@ include file = "partial/footer.jsp" %>
</body>
</html>