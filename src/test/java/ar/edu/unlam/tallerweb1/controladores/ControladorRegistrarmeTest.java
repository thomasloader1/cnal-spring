package ar.edu.unlam.tallerweb1.controladores;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.assertThat;

public class ControladorRegistrarmeTest {

    private ControladorRegistrarme controladorRegistrarme = new ControladorRegistrarme();
    private static final DatosRegistro USUARIO_CON_MAIL_INCORRECTO
            = new DatosRegistro("seba.com", "1234", "1234");;
    private static final DatosRegistro USUARIO
            = new DatosRegistro("seba@seba.com", "1234", "1234");

    @Test
    public void puedoRegistrarmeConUsuarioNuevoYClaveCorrecta() {
        givenQueElUsuarioNoExiste(USUARIO);
        ModelAndView mav = whenRegistroElUsuario(USUARIO);
        thenElRegistroEsExitoso(mav);
    }

    @Test
    public void noPuedoRegistrarmeConMailDeUsuarioIncorrecto(){
        ModelAndView mav = whenRegistroElUsuario(USUARIO_CON_MAIL_INCORRECTO);
        thenElRegistroFalla(mav);
    }

    private void givenQueElUsuarioNoExiste(DatosRegistro usuario) {
    }

    private ModelAndView whenRegistroElUsuario(DatosRegistro datos) {
        return controladorRegistrarme.registrarUsuario(datos);
    }

    private void thenElRegistroEsExitoso(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("login");
        assertThat(mav.getModel().get("msg")).isEqualTo("Registro Exitoso");
        assertThat(mav.getModel().get("email")).isEqualTo(USUARIO.getEmail());
    }

    private void thenElRegistroFalla(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("registrarme");
        assertThat(mav.getModel().get("msg")).isEqualTo("Registro Fallido por mail incorrecto");
    }
}
