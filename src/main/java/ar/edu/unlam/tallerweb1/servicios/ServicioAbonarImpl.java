package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Preference;
import com.mercadopago.resources.datastructures.advancedpayment.Payment;
import com.mercadopago.resources.datastructures.preference.BackUrls;
import com.mercadopago.resources.datastructures.preference.Identification;
import com.mercadopago.resources.datastructures.preference.Item;
import com.mercadopago.resources.datastructures.preference.Payer;
import org.springframework.stereotype.Service;

@Service
public class ServicioAbonarImpl implements  ServicioAbonar{


//    @Override
//    public Preference reservarCancha(Partido partido, Usuario usuario) throws MPException {
//        MercadoPago.SDK.setAccessToken("APP_USR-5072808580066530-102323-ab3d5e7be2477a88a050f18851ae92d7-174501329");
//        Preference preference = new Preference();
//
////        String notificationUrlSuccess = "http://localhost:8080/proyecto_limpio_spring_war_exploded/ver-curso/nueva-recomendacion/recomendacion?id="+partido.getId();
////        String notificationUrlFailure = "http://localhost:8080/proyecto_limpio_spring_war_exploded/listar-cursos";
////
////        preference.setBackUrls(
////                new BackUrls().setSuccess(notificationUrlSuccess)
////                        .setPending(notificationUrlFailure)
////                        .setFailure(notificationUrlFailure)
////        );
//
//        Payer payer = new Payer();
//        payer.setName("TEST2YSV0MGR");
//        payer.setEmail("test_user_28437149@testuser.com");
//
//        preference.setPayer(payer);
//
//        Item item = new Item();
//        item.setTitle(partido.getDireccion())
//                .setQuantity(1)
//                .setUnitPrice(500.00f);
//        preference.appendItem(item);
//
//        preference.save();
//
//        return preference;
//    }

    @Override
    public Preference reservarCancha(Partido partido, Usuario usuario) throws MPException {
        MercadoPago.SDK.setAccessToken("TEST-5072808580066530-102323-9a2da9d8fd4359c68f0ec22589723fdd-174501329");
        Preference preference = new Preference();

//        String notificationUrlSuccess = "http://localhost:8080/proyecto_limpio_spring_war_exploded/ver-curso/nueva-recomendacion/recomendacion?id="+curso.getId();
//        String notificationUrlFailure = "http://localhost:8080/proyecto_limpio_spring_war_exploded/listar-cursos";
//
//        preference.setBackUrls(
//                new BackUrls().setSuccess(notificationUrlSuccess)
//                        .setPending(notificationUrlFailure)
//                        .setFailure(notificationUrlFailure)
//        );

        Payer payer = new Payer();
        payer.setName("TETE348775");
        payer.setEmail("test_user_96104108@testuser.com");

        preference.setPayer(payer);

        Item item = new Item();
        item.setTitle(partido.getLocalidad())
                .setQuantity(1)
                .setUnitPrice(partido.getCancha().getPrecio().floatValue());
        preference.appendItem(item);

        preference.save();

        return preference;
    }
}
