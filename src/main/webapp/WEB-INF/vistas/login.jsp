<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<%@ include file = "partial/header.jsp" %>
	<body>
	<%@ include file = "partial/navbarLogin.jsp" %>
		<%--<div class = "container">
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
		</div>--%>
	<div class="page-wrapers">
		<!-- Content -->
		<div class="page-content dez-login p-t50 p-lr15 nav">
			<div class="login-form">
				<div class="tab-content">
					<div id="login" class="tab-pane active text-center">

						<form:form action="validar-login" class="p-a25 dez-form p-b0 m-t100" method="POST" modelAttribute="datosLogin">
							<h3 class="form-title m-t0">Ingresar al sistema</h3>
							<div class="dez-separator-outer m-b5">
								<div class="dez-separator bg-primary style-liner"></div>
							</div>
							<p>Ingresa tu e-mail y tu contraseña. </p>
							<div class="form-group">
								<input name="email" id="email" type="email" required="" class="form-control" placeholder="E-Mail" />
							</div>

							<div class="form-group">
								<input name="password" id="password" required="" class="form-control " placeholder="Contraseña" type="password"/>
							</div>


							<div class="form-group text-left">
								<button class="site-button m-r5 login-switch">Ingresar</button>
								<label>
									<input id="check1" type="checkbox">
									<label for="check1">Manter sesion iniciada</label>
								</label>
								<a data-toggle="tab" href="#forgot-password" class="m-l15"><i class="fa fa-unlock-alt"></i> Olvide mi contraseña</a> </div>
						</form:form>

						<c:if test="${not empty error}">
							<div class="col-12">
								<div class="alert alert-danger" role="alert">
									<h6>${msg}</h6>

								</div>
							</div>
						</c:if>

						<%--<form class="p-a25 dez-form p-b0 m-t100">
							<h3 class="form-title m-t0">Sign In</h3>
							<div class="dez-separator-outer m-b5">
								<div class="dez-separator bg-primary style-liner"></div>
							</div>
							<p>Enter your e-mail address and your password. </p>
							<div class="form-group">
								<input name="dzName" required="" class="form-control" placeholder="User Name" type="text"/>
							</div>
							<div class="form-group">
								<input name="dzName" required="" class="form-control " placeholder="Type Password" type="password"/>
							</div>
							<div class="form-group text-left">
								<button class="site-button m-r5 login-switch">login</button>
								<label>
									<input id="check1" type="checkbox">
									<label for="check1">Remember me</label>
								</label>
								<a data-toggle="tab" href="#forgot-password" class="m-l15"><i class="fa fa-unlock-alt"></i> Forgot Password</a> </div>
						</form>--%>
						<div class="bg-primary p-a15 "> <a data-toggle="tab" href="#developement-1" class="text-white">Crear una cuenta</a> </div>
					</div>
					<div id="forgot-password" class="tab-pane fade ">
						<form class="p-a25 dez-form m-t100 text-center">
							<h3 class="form-title m-t0">Forget Password ?</h3>
							<div class="dez-separator-outer m-b5">
								<div class="dez-separator bg-primary style-liner"></div>
							</div>
							<p>Enter your e-mail address below to reset your password. </p>
							<div class="form-group">
								<input name="dzName" required="" class="form-control" placeholder="Email Id" type="text"/>
							</div>
							<div class="form-group text-left"> <a class="site-button outline gray" data-toggle="tab" href="#login">Back</a>
								<button class="site-button pull-right">Submit</button>
							</div>
						</form>
					</div>
					<div id="developement-1" class="tab-pane fade">
						<form class="p-a25 dez-form text-center text-center">
							<h3 class="form-title m-t0">Sign Up</h3>
							<div class="dez-separator-outer m-b5">
								<div class="dez-separator bg-primary style-liner"></div>
							</div>
							<p>Enter your personal details below: </p>
							<div class="form-group">
								<input name="dzName" required="" class="form-control" placeholder="Full Name" type="text"/>
							</div>
							<div class="form-group">
								<input name="dzName" required="" class="form-control" placeholder="Email Id" type="text"/>
							</div>
							<div class="form-group">
								<input name="dzName" required="" class="form-control" placeholder="Address" type="text"/>
							</div>
							<div class="form-group">
								<input name="dzName" required="" class="form-control" placeholder="City/Town" type="text"/>
							</div>
							<label class="text-left m-b20">Enter your account details below: </label>
							<div class="form-group">
								<input name="dzName" required="" class="form-control" placeholder="User Name" type="text"/>
							</div>
							<div class="form-group">
								<input name="dzName" required="" class="form-control" placeholder="Password" type="text"/>
							</div>
							<div class="">
								<input name="dzName" required="" class="form-control" placeholder="Re-type Your Password" type="text"/>
							</div>
							<label class="m-b30">
								<input type="checkbox"/>
								<label>I agree to the <a href="#">Terms of Service </a>& <a href="#">Privacy Policy </label>
							</label>
							<div class="form-group text-left "> <a class="site-button outline gray" data-toggle="tab" href="#login">Back</a>
								<button class="site-button pull-right">Submit</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<!-- Content END-->
	</div>
		<%@ include file = "partial/scripts.jsp" %>
		<%--<%@ include file = "partial/footer.jsp" %>--%>
	</body>
</html>
