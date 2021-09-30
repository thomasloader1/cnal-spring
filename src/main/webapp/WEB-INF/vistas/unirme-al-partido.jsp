<%@ include file = "partial/header.jsp" %>
<html>
<head>
    <title>Unirme al partido</title>
</head>
<body>
    <div class="container-fluid">
        <table class="table text-center">
            <thead>
            <tr>
                <th scope="col">Ubicacion</th>
                <th scope="col">Categoria</th>
                <th scope="col">Horario</th>
                <th scope="col">Cantidad de lugares disponibles</th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <tr class="table-active">
                <th scope="row">Calle 123</th>
                <td>Juvenil</td>
                <td>18:00</td>
                <td>2</td>
                <td><button class="btn text-white" style="background-color: #67b168" onclick="alert('Te has unido correctamente')">Unirme</button></td>
            </tr>
            <tr>
                <th scope="row">Calle 123</th>
                <td>Juvenil</td>
                <td>18:00</td>
                <td>2</td>
                <td><button class="btn text-white" style="background-color: #67b168" onclick="alert('Te has unido correctamente')">Unirme</button></td>
            </tr>
            <tr class="table-active">
                <th scope="row">Calle 123</th>
                <td>Juvenil</td>
                <td>18:00</td>
                <td>2</td>
                <td><button class="btn text-white" style="background-color: #67b168" onclick="alert('Te has unido correctamente')">Unirme</button></td>
            </tr>
            </tbody>
        </table>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
    <%@ include file = "partial/footer.jsp" %>
</body>
</html>
