<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<script type="text/javascript" src="js/jquery.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>--%>
<!-- JavaScript  files ========================================= -->
<script src="js/jquery.min.js"></script><!-- JQUERY.MIN JS -->
<script src="plugins/bootstrap/js/popper.min.js"></script><!-- BOOTSTRAP.MIN JS -->
<script src="plugins/bootstrap/js/bootstrap.min.js"></script><!-- BOOTSTRAP.MIN JS -->
<script src="plugins/bootstrap-select/bootstrap-select.min.js"></script><!-- FORM JS -->
<script src="plugins/bootstrap-touchspin/jquery.bootstrap-touchspin.js"></script><!-- FORM JS -->
<script src="plugins/magnific-popup/magnific-popup.js"></script><!-- MAGNIFIC POPUP JS -->
<script src="plugins/counter/waypoints-min.js"></script><!-- WAYPOINTS JS -->
<script src="plugins/counter/counterup.min.js"></script><!-- COUNTERUP JS -->
<script src="plugins/countdown/jquery.countdown.js"></script><!-- COUNTDOWN JS -->
<script src="plugins/imagesloaded/imagesloaded.js"></script><!-- IMAGESLOADED -->
<script src="plugins/masonry/masonry-3.1.4.js"></script><!-- MASONRY -->
<script src="plugins/masonry/masonry.filter.js"></script><!-- MASONRY -->
<script src="plugins/owl-carousel/owl.carousel.js"></script><!-- OWL SLIDER -->
<script src="plugins/lightgallery/js/lightgallery-all.js"></script><!-- LIGHT GALLERY -->
<script src="js/dz.ajax.js"></script><!-- CONTACT JS  -->

<script src="js/custom.min.js"></script><!-- CUSTOM FUCTIONS  -->
<script src="js/dz.carousel.min.js"></script><!-- SORTCODE FUCTIONS  -->
<!-- revolution JS FILES -->
<script src="plugins/revolution/revolution/js/jquery.themepunch.tools.min.js"></script>
<script src="plugins/revolution/revolution/js/jquery.themepunch.revolution.min.js"></script>
<!-- Slider revolution 5.0 Extensions  (Load Extensions only on Local File Systems !  The following part can be removed on Server for On Demand Loading) -->
<script src="plugins/revolution/revolution/js/extensions/revolution.extension.actions.min.js"></script>
<script src="plugins/revolution/revolution/js/extensions/revolution.extension.carousel.min.js"></script>
<script src="plugins/revolution/revolution/js/extensions/revolution.extension.kenburn.min.js"></script>
<script src="plugins/revolution/revolution/js/extensions/revolution.extension.layeranimation.min.js"></script>
<script src="plugins/revolution/revolution/js/extensions/revolution.extension.migration.min.js"></script>
<script src="plugins/revolution/revolution/js/extensions/revolution.extension.navigation.min.js"></script>
<script src="plugins/revolution/revolution/js/extensions/revolution.extension.parallax.min.js"></script>
<script src="plugins/revolution/revolution/js/extensions/revolution.extension.slideanims.min.js"></script>
<script src="plugins/revolution/revolution/js/extensions/revolution.extension.video.min.js"></script>
<script src="js/rev.slider.js"></script>
<script src="https://sdk.mercadopago.com/js/v2"></script>
<script>     
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
                },
                eventClick: function(info) {
                    console.log(info.event)
                    $("#genericModal").modal("toggle")
                    console.log()
                }
            });
    });	/*ready*/
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
            label: 'Pagar', // Cambia el texto del botón de pago (opcional)
        }
    });
</script>
