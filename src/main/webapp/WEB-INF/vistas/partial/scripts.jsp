<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/main.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/locales-all.min.js"></script>
<script>
    document.addEventListener('DOMContentLoaded', function() {
        var calendarEl = document.getElementById('calendar');
        var calendar = new FullCalendar.Calendar(calendarEl, {
            themeSystem: 'bootstrap',
            initialView: 'timeGridWeek',
            slotMinTime: '07:00:00',
            slotMaxTime: '24:00:00',
            allDaySlot: false,
            selectable: true,
            height: 650,
            contentHeight: 600,
            eventSources: {
                url: 'http://localhost:8080/proyecto_limpio_spring_war_exploded/partidos',
                method: 'GET'
            },
            select: function (info){
                console.group("select f():")
                console.info(info)
                console.groupEnd()
            },
            dateClick: function (event){
                console.group("dateCLick f():")
                console.info(event)
                console.groupEnd()
            }
        });
        calendar.render();
    });

</script>
<script src="https://sdk.mercadopago.com/js/v2"></script>
<script>
    // Agrega credenciales de SDK
    const mp = new MercadoPago('TEST-d629bab3-7a69-4606-8e5c-c4c40a5ecde7', {
        locale: 'es-AR'
    });
    // Inicializa el checkout
    mp.checkout({
        preference: {
            id: '174501329-d59f8b06-3475-4f0a-8561-24ac3b1ee519'
        },
        render: {
            container: '.cho-container', // Indica el nombre de la clase donde se mostrará el botón de pago
            label: 'Mercado pago', // Cambia el texto del botón de pago (opcional)
        }
    });
</script>