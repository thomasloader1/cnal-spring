<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>Unirme al partido</title>
  <%@ include file = "partial/header.jsp" %>
</head>
<body>
<%@ include file = "partial/navbarJugador.jsp" %>


<div class="container">
  <div class="row">
    <div class="col-12">
      <h2 style="text-align: center; margin-top: 5%">Mis Reportes</h2>
    </div>
  </div>
</div>

<div class="container">
  <div class="row">
    <div class="col-6">
      <h4 style="text-align: left; margin-top: 5%">Estado actual del jugador:
        <c:choose>
          <c:when test="${ESTADO == 'Activo'}">
            <h4 style="color:green">${ESTADO}</h4>
          </c:when>
          <c:otherwise>
            <h4 style="color: red">${ESTADO}</h4>
          </c:otherwise>
        </c:choose>
      </h4>
    </div>
  </div>
</div>

<div class="container">
  <div class="row my-5">
    <div class="col-12">
      <table class="table text-center">
        <thead>
        <tr>
          <th scope="col">Motivo</th>
          <th scope="col">Descripcion</th>
          <th scope="col">Fecha Reporte</th>
          <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${REPORTES}" var="REPORTES">
          <tr class="table-active">
            <th scope="row">${REPORTES.motivo}</th>
            <td>${REPORTES.descripcion}</td>
            <td>${REPORTES.fechaReporte}</td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
  </div>

</div>




<%@ include file = "partial/scripts.jsp" %>

<%@ include file = "partial/footer.jsp" %>
</body>
</html>