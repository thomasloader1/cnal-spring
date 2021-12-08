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
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>

<script src="https://sdk.mercadopago.com/js/v2"></script>
<script>
    const mp = new MercadoPago('TEST-d629bab3-7a69-4606-8e5c-c4c40a5ecde7', {
        locale: 'es-AR'
    })

    const cardForm = mp.cardForm({
        amount: '100.5',
        autoMount: true,
        processingMode: 'aggregator',
        form: {
            id: 'form-checkout',
            cardholderName: {
                id: 'form-checkout__cardholderName',
                placeholder: 'Titular de la tarjeta',
            },
            cardholderEmail: {
                id: 'form-checkout__cardholderEmail',
                placeholder: 'Email',
            },
            cardNumber: {
                id: 'form-checkout__cardNumber',
                placeholder: 'Número de la tarjeta',
            },
            cardExpirationMonth: {
                id: 'form-checkout__cardExpirationMonth',
                placeholder: 'Mes de vencimiento'
            },
            cardExpirationYear: {
                id: 'form-checkout__cardExpirationYear',
                placeholder: 'Año de vencimiento'
            },
            securityCode: {
                id: 'form-checkout__securityCode',
                placeholder: 'Código de seguridad',
            },
            installments: {
                id: 'form-checkout__installments',
                placeholder: 'Cuotas'
            },
            identificationType: {
                id: 'form-checkout__identificationType',
                placeholder: 'Tipo de documento'
            },
            identificationNumber: {
                id: 'form-checkout__identificationNumber',
                placeholder: 'Número de documento'
            },
            issuer: {
                id: 'form-checkout__issuer',
                placeholder: 'Banco emisor'
            }
        },
        callbacks: {
            onFormMounted: error => {
                if (error) return console.warn('Form Mounted handling error: ', error)
                console.log('Form mounted')
            },
            onFormUnmounted: error => {
                if (error) return console.warn('Form Unmounted handling error: ', error)
                console.log('Form unmounted')
            },
            onIdentificationTypesReceived: (error, identificationTypes) => {
                if (error) return console.warn('identificationTypes handling error: ', error)
                console.log('Identification types available: ', identificationTypes)
            },
            onPaymentMethodsReceived: (error, paymentMethods) => {
                if (error) return console.warn('paymentMethods handling error: ', error)
                console.log('Payment Methods available: ', paymentMethods)
            },
            onIssuersReceived: (error, issuers) => {
                if (error) return console.warn('issuers handling error: ', error)
                console.log('Issuers available: ', issuers)
            },
            onInstallmentsReceived: (error, installments) => {
                if (error) return console.warn('installments handling error: ', error)
                console.log('Installments available: ', installments)
            },
            onCardTokenReceived: (error, token) => {
                if (error) return console.warn('Token handling error: ', error)
                console.log('Token available: ', token)
            },
            onSubmit: (event) => {
                event.preventDefault();
                const cardData = cardForm.getCardFormData();
                console.log('CardForm data available: ', cardData)
            },
            onFetching:(resource) => {
                console.log('Fetching resource: ', resource)

                // Animate progress bar
                const progressBar = document.querySelector('.progress-bar')
                progressBar.removeAttribute('value')

                return () => {
                    progressBar.setAttribute('value', '0')
                }
            },
        }
    })
</script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>

<script src="https://sdk.mercadopago.com/js/v2"></script>
<script>
    const mp = new MercadoPago('TEST-d629bab3-7a69-4606-8e5c-c4c40a5ecde7', {
        locale: 'es-AR'
    })

    const cardForm = mp.cardForm({
        amount: '100.5',
        autoMount: true,
        processingMode: 'aggregator',
        form: {
            id: 'form-checkout',
            cardholderName: {
                id: 'form-checkout__cardholderName',
                placeholder: 'Titular de la tarjeta',
            },
            cardholderEmail: {
                id: 'form-checkout__cardholderEmail',
                placeholder: 'Email',
            },
            cardNumber: {
                id: 'form-checkout__cardNumber',
                placeholder: 'Número de la tarjeta',
            },
            cardExpirationMonth: {
                id: 'form-checkout__cardExpirationMonth',
                placeholder: 'Mes de vencimiento'
            },
            cardExpirationYear: {
                id: 'form-checkout__cardExpirationYear',
                placeholder: 'Año de vencimiento'
            },
            securityCode: {
                id: 'form-checkout__securityCode',
                placeholder: 'Código de seguridad',
            },
            installments: {
                id: 'form-checkout__installments',
                placeholder: 'Cuotas'
            },
            identificationType: {
                id: 'form-checkout__identificationType',
                placeholder: 'Tipo de documento'
            },
            identificationNumber: {
                id: 'form-checkout__identificationNumber',
                placeholder: 'Número de documento'
            },
            issuer: {
                id: 'form-checkout__issuer',
                placeholder: 'Banco emisor'
            }
        },
        callbacks: {
            onFormMounted: error => {
                if (error) return console.warn('Form Mounted handling error: ', error)
                console.log('Form mounted')
            },
            onFormUnmounted: error => {
                if (error) return console.warn('Form Unmounted handling error: ', error)
                console.log('Form unmounted')
            },
            onIdentificationTypesReceived: (error, identificationTypes) => {
                if (error) return console.warn('identificationTypes handling error: ', error)
                console.log('Identification types available: ', identificationTypes)
            },
            onPaymentMethodsReceived: (error, paymentMethods) => {
                if (error) return console.warn('paymentMethods handling error: ', error)
                console.log('Payment Methods available: ', paymentMethods)
            },
            onIssuersReceived: (error, issuers) => {
                if (error) return console.warn('issuers handling error: ', error)
                console.log('Issuers available: ', issuers)
            },
            onInstallmentsReceived: (error, installments) => {
                if (error) return console.warn('installments handling error: ', error)
                console.log('Installments available: ', installments)
            },
            onCardTokenReceived: (error, token) => {
                if (error) return console.warn('Token handling error: ', error)
                console.log('Token available: ', token)
            },
            onSubmit: (event) => {
                event.preventDefault();
                const cardData = cardForm.getCardFormData();
                console.log('CardForm data available: ', cardData)
            },
            onFetching:(resource) => {
                console.log('Fetching resource: ', resource)

                // Animate progress bar
                const progressBar = document.querySelector('.progress-bar')
                progressBar.removeAttribute('value')

                return () => {
                    progressBar.setAttribute('value', '0')
                }
            },
        }
    })
</script>
