<!DOCTYPE html>
<html>
	<%@ include file = "partial/header.jsp" %>
	<body>
	<%@ include file = "partial/navbar.jsp" %>
	<div class="text-center p-5"  style="background-color: #67b168">
		<h1 class="mb-3" >Reserva tu cancha al instante</h1>
		<h4 class="mb-3">Solo por hoy 25% off en todo el sitio</h4>
		<a class="btn text-white" href="" role="button" style="background-color: #2b542c">Reservar</a>
	</div>
	<div class="container py-3">
		<h3 style="margin-bottom: 3%; margin-top: 3%">Partidos disponibles</h3>

		<div class="row">
			<c:forEach items="${PARTIDOS}" var="PARTIDO">
			<div class="col-4">
				<div class="card">
					<img
							src="https://images.unsplash.com/photo-1575361204480-aadea25e6e68?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1171&q=80"
							class="card-img-top"
							alt="..."
					/>
					<div class="card-body">
						<h5 class="card-title">Categoria: ${PARTIDO.categoria}</h5>
						<p class="card-text">
							<strong>Futbol:</strong> ${PARTIDO.tipo}
						</p>
						<p class="card-text">
							<strong>Localidad:</strong> ${PARTIDO.localidad}
						</p>
						<p class="card-text">
							<strong>Horario:</strong> ${PARTIDO.horario}
						</p>
						<a href="#!" class="btn btn-primary">Reservar</a>
					</div>
				</div>
			</div>
			</c:forEach>
		</div>

	</div>



	<div class="container" style="margin-bottom: 5%">
		<c:if test="${not empty MIS_PARTIDOS}">
		<h3 style="margin-bottom: 3%; margin-top: 3%">Tus partidos</h3>
		</c:if>
		<div class="row">
			<c:forEach items="${MIS_PARTIDOS}" var="MIS_PARTIDOS">
				<div class="col-4">
					<div class="card">
						<img
								src="https://images.unsplash.com/photo-1575361204480-aadea25e6e68?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1171&q=80"
								class="card-img-top"
								alt="..."
						/>
						<div class="card-body">
							<h5 class="card-title">Categoria: ${MIS_PARTIDOS.categoria}</h5>
							<p class="card-text">
								<strong>Ubicacion:</strong> ${MIS_PARTIDOS.direccion}
							</p>
							<p class="card-text">
								<strong>Localidad:</strong> ${MIS_PARTIDOS.localidad}
							</p>
							<p class="card-text">
								<strong>Horario:</strong> ${MIS_PARTIDOS.horario}
							</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>


		<%@ include file = "partial/scripts.jsp" %>
		<%@ include file = "partial/footer.jsp" %>
	</body>
</html>