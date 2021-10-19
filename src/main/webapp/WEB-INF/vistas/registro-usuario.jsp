<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<%@ include file = "partial/header.jsp" %>
<body>
<%@ include file = "partial/navbarLogin.jsp" %>
<div class = "container d-flex justify-content-center">
    <div id="loginbox" style="margin-top:50px;margin-bottom: 50px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2 ">
        <form:form action="registrarme" method="POST" modelAttribute="datos">
            <h3 class="form-signin-heading">Registrarse</h3>
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input name="email" id="email" type="email" class="form-control" aria-describedby="emailHelp">
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input name="password" id="password" type="password" class="form-control" aria-describedby="passwordHelp">
            </div>
            <div class="mb-3">
                <label for="repeatPassword" class="form-label">Repeat Password</label>
                <input name="repeatPassword" id="repeatPassword" type="password" class="form-control" aria-describedby="passwordHelp">
            </div>
            <button class="btn btn-lg btn-primary btn-block" Type="Submit"/>Login</button>

        </form:form>

        <c:if test="${not empty msg}">
            <h4><span>${msg}</span></h4>
            <br>
        </c:if>
    </div>
</div>

<%@ include file = "partial/scripts.jsp" %>
<%@ include file = "partial/footer.jsp" %>
</body>
</html>