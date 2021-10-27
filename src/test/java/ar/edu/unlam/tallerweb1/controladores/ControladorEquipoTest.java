package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Equipo;
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

    private static final Usuario USUARIO = new Usuario("scortes@mail.com", "123","admin");
    private static final DatosEquipo EQUIPO_COMPLETO = new DatosEquipo("Pirulo", 11, 11, "Juvenil");
    private static final DatosEquipo EQUIPO_INCOMPLETO = new DatosEquipo("Pirulo", 3, 5, "Juvenil");

    private static final Equipo EQUIPO_CON_LUGARES = new Equipo("El Mejor", 3, 5, "Juvenil");
    private static final Equipo EQUIPO_LLENO = new Equipo("El Mejor", 11, 11, "Juvenil");


    @Test
    public void puedoUnirmeAUnEquipoConLugaresDisponibles(){
        givenUnUsuario(USUARIO);
        EQUIPO_CON_LUGARES.setId(5L);
        givenUnEquipoIncompleto(EQUIPO_CON_LUGARES);

        ModelAndView modeloVista = whenMeUnoAlEquipo(EQUIPO_CON_LUGARES, USUARIO);

        thenMeUnoCorrectamente(modeloVista);
    }

    private void givenUnUsuario(Usuario usuario) {
    }

    private void givenUnEquipoIncompleto(Equipo equipo) {

    }

    private ModelAndView whenMeUnoAlEquipo(Equipo equipo, Usuario usuario) {
        return controladorEquipo.unirmeAUnEquipo(equipo, usuario, EQUIPO_CON_LUGARES.getId());
    }

    private void thenMeUnoCorrectamente(ModelAndView modeloVista) {
        assertThat(modeloVista.getViewName()).isEqualTo("union-equipo-exitosa");
        //assertThat(modeloVista.getModel().get("msg")).isEqualTo("Te uniste correctamente");
    }


    @Test
    public void noPuedoUnirmeAUnEquipoCompleto() throws Exception {
        givenUnUsuario(USUARIO);
        givenUnEquipoCompleto(EQUIPO_LLENO);

        ModelAndView modeloVista = whenMeUnoAlEquipo(EQUIPO_LLENO, USUARIO);

        thenNoMePuedoUnirAlEquipo(modeloVista);
    }


    private void givenUnEquipoCompleto(Equipo equipoCompleto) throws Exception {
        doThrow(Exception.class).when(servicioEquipo).registrarEnEquipo(EQUIPO_LLENO.getId(), USUARIO);
    }

    private void thenNoMePuedoUnirAlEquipo(ModelAndView modeloVista) {
        assertThat(modeloVista.getViewName()).isEqualTo("unirme-a-equipo");
        assertThat(modeloVista.getModel().get("error")).isEqualTo("El equipo ya esta completo");
    }


}
