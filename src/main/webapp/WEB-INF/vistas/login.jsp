<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<%@ include file = "partial/header.jsp" %>
	<body>
	<%@ include file = "partial/navbarLogin.jsp" %>
		<div class = "container">
				<form:form action="validar-login" method="POST" modelAttribute="datosLogin">
						<div class="mb-3">
							<label for="email" class="form-label">Email</label>
							<input name="email" id="email" type="email" class="form-control" aria-describedby="emailHelp">
						</div>
						<div class="mb-3">
							<label for="password" class="form-label">Password</label>
							<input name="password" id="password" type="password" class="form-control" aria-describedby="passwordHelp">
						</div>
					<button class="btn btn-lg btn-primary btn-block" Type="Submit"/>Login</button>
				</form:form>
			<div class="d-flex justify-content-center">
				<a href="ir-a-registrarme"><button class="btn" Type="Submit"> Registrarme</button></a>
			</div>
				<c:if test="${not empty error}">
					<div class="col-12">
						<div class="alert alert-danger" role="alert">
							<h6>${msg}</h6>

						</div>
					</div>
		        </c:if>
		</div>
		<%@ include file = "partial/scripts.jsp" %>
		<%@ include file = "partial/footer.jsp" %>
	</body>
</html>
