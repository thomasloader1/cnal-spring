<%--
  Created by IntelliJ IDEA.
  User: Fede
  Date: 9/28/2021
  Time: 10:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Registrar Partido</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet" >
    <!-- Bootstrap theme -->
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>
    <div id="registrarPartido" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <form:form action="registrar" method="POST" modelAttribute="partidoNuevo">
            <h3 class="form-signin-heading">Registrar Partido </h3>
            <hr class="colorgraph"><br>

            <label for="">Ingrese la cantidad de juegadores</label>
            <form:input path="cant_jugadores" id="cantidad" class="form-control" />

            <label for="">Ingrese tipo de partido</label>
            <form:input path="tipo" id="tipo" class="form-control"/>

            <label for="">Ingrese la categoria</label>
            <form:input path="categoria" id="categoria" class="form-control"/>

            <label for="">Ingrese el horario</label>
            <form:input path="horario" id="horario" class="form-control"/>

            <button id="btn-registrar" class="btn btn-lg btn-primary btn-block" Type="Submit"/>Registrar partido</button>
        </form:form>

        <c:if test="${not empty error}">
            <h4><span>${error}</span></h4>
            <br>
        </c:if>
        ${msg}
    </div>


    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>
