package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioEquipo;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

public class ControladorEquipoTest {

    private ServicioEquipo servicioEquipo = mock(ServicioEquipo.class);
    private ControladorEquipo controladorEquipo = new ControladorEquipo(servicioEquipo);

    private static final Usuario USUARIO = new Usuario("scortes@mail.com", "123");
    private static final DatosEquipo EQUIPO_COMPLETO = new DatosEquipo("Pirulo", 11, 11, "Juvenil");
    private static final DatosEquipo EQUIPO_INCOMPLETO = new DatosEquipo("Pirulo", 3, 5, "Juvenil");

    @Test
    public void puedoUnirmeAUnEquipoConLugaresDisponibles(){
        givenUnUsuario(USUARIO);
        givenUnEquipoIncompleto(EQUIPO_INCOMPLETO);

        ModelAndView modeloVista = whenMeUnoAlEquipo(EQUIPO_INCOMPLETO, USUARIO);

        thenMeUnoCorrectamente(modeloVista);
    }

    private void givenUnUsuario(Usuario usuario) {
    }

    private void givenUnEquipoIncompleto(DatosEquipo equipo) {

    }

    private ModelAndView whenMeUnoAlEquipo(DatosEquipo equipo, Usuario usuario) {
        return controladorEquipo.unirmeAUnEquipo(equipo, usuario);
    }

    private void thenMeUnoCorrectamente(ModelAndView modeloVista) {
        assertThat(modeloVista.getViewName()).isEqualTo("union-equipo-exitosa");
        assertThat(modeloVista.getModel().get("msg")).isEqualTo("Te uniste correctamente");
    }


    @Test
    public void noPuedoUnirmeAUnEquipoCompleto() throws Exception {
        givenUnUsuario(USUARIO);
        givenUnEquipoCompleto(EQUIPO_COMPLETO);

        ModelAndView modeloVista = whenMeUnoAlEquipo(EQUIPO_COMPLETO, USUARIO);

        thenNoMePuedoUnirAlEquipo(modeloVista);
    }


    private void givenUnEquipoCompleto(DatosEquipo equipoCompleto) throws Exception {
        doThrow(Exception.class).when(servicioEquipo).registrarEnEquipo(EQUIPO_COMPLETO.getNombre(), USUARIO);
    }

    private void thenNoMePuedoUnirAlEquipo(ModelAndView modeloVista) {
        assertThat(modeloVista.getViewName()).isEqualTo("union-a-equipo");
        assertThat(modeloVista.getModel().get("error")).isEqualTo("El equipo ya esta completo");
    }


}
