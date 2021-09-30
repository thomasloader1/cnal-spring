<html>
<head>
    <title>Unirme al partido</title>
    <%@ include file = "partial/header.jsp" %>
</head>
<body>
<%@ include file = "partial/navbar.jsp" %>

    <div class="container">
        <div class="row my-5">
            <div class="col-12">
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
        </div>
    </div>
<%@ include file = "partial/scripts.jsp" %>

<%@ include file = "partial/footer.jsp" %>
</body>
</html>
