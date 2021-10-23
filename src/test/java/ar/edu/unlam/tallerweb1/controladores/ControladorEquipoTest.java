package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.servicios.ServicioEquipo;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

public class ControladorEquipoTest {

    private ServicioEquipo servicioEquipo = mock(ServicioEquipo.class);
    private ControladorEquipo controladorEquipo = new ControladorEquipo(servicioEquipo);

    private static final DatosEquipo EQUIPO_COMPLETO = new DatosEquipo("Pirulo", 11);
    private static final DatosEquipo EQUIPO_INCOMPLETO = new DatosEquipo("Pirulo", 3);

    @Test
    public void puedoUnirmeAUnEquipoConLugaresDisponibles(){
        givenUnEquipoIncompleto(EQUIPO_INCOMPLETO);

        ModelAndView modeloVista = whenMeUnoAlEquipo(EQUIPO_INCOMPLETO);

        thenMeUnoCorrectamente(modeloVista);
    }

    private void givenUnEquipoIncompleto(DatosEquipo equipo) {

    }

    private ModelAndView whenMeUnoAlEquipo(DatosEquipo equipo) {
        return controladorEquipo.unirmeAUnEquipo(equipo);
    }

    private void thenMeUnoCorrectamente(ModelAndView modeloVista) {
        assertThat(modeloVista.getViewName()).isEqualTo("union-equipo-exitosa");
        assertThat(modeloVista.getModel().get("msg")).isEqualTo("Te uniste correctamente");
    }


    @Test
    public void noPuedoUnirmeAUnEquipoCompleto() throws Exception {
        givenUnEquipoCompleto(EQUIPO_COMPLETO);

        ModelAndView modeloVista = whenMeUnoAlEquipo(EQUIPO_COMPLETO);

        thenNoMePuedoUnirAlEquipo(modeloVista);
    }


    private void givenUnEquipoCompleto(DatosEquipo equipoCompleto) throws Exception {
        doThrow(Exception.class).when(servicioEquipo).registrarEnEquipo(EQUIPO_COMPLETO.getNombre());
    }

    private void thenNoMePuedoUnirAlEquipo(ModelAndView modeloVista) {
        assertThat(modeloVista.getViewName()).isEqualTo("union-a-equipo");
        assertThat(modeloVista.getModel().get("error")).isEqualTo("El equipo ya esta completo");
    }


}
