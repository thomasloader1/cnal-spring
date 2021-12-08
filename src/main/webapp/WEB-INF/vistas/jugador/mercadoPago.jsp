<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<%@ include file = "../partial/header.jsp" %>
<body>
<%@ include file = "../partial/navbarJugador.jsp" %>
<form id="form-checkout" class="container-fluid">
    <div class="row g-3">
        <div class="col-sm-7">
            <input type="text" class="form-control" name="cardNumber" id="form-checkout__cardNumber" />
        </div>
        <div class="col-sm">
            <input type="text" name="cardExpirationMonth" class="form-control" id="form-checkout__cardExpirationMonth" />
        </div>
        <div class="col-sm">
            <input type="text" class="form-control" name="cardExpirationYear" id="form-checkout__cardExpirationYear" />
        </div>
    </div>
    <div class="col-sm-7">
        <input type="text"  class="form-control" name="cardholderName" id="form-checkout__cardholderName"/>

    </div>
    <div class="col-sm-7">
        <input type="email" class="form-control"  name="cardholderEmail" id="form-checkout__cardholderEmail"/>
    </div>
    <div class="col-sm-7">
        <input type="text"  class="form-control" name="securityCode" id="form-checkout__securityCode" />
    </div>
    <div class="col-sm-7">
        <select name="issuer"  class="form-control" id="form-checkout__issuer"></select>
    </div>
    <div class="col-sm">
        <select name="identificationType" class="form-control" id="form-checkout__identificationType"></select>
    </div>
    <div class="col-sm">
        <input type="text" name="identificationNumber"  class="form-control" id="form-checkout__identificationNumber"/>
    </div>
    <div class="col-sm-7">
        <select name="installments" class="form-control" id="form-checkout__installments"></select>
    </div>

    <button type="submit" class="btn btn-primary" id="form-checkout__submit">Pagar</button>

    <progress value="0" class="progress-bar">Cargando...</progress>
</form>

<%@ include file = "../partial/scripts.jsp" %>
<%@ include file = "../partial/footer.jsp" %>

</body>
</html>
