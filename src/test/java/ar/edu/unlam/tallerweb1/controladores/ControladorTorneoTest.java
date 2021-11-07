package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Torneo;
import ar.edu.unlam.tallerweb1.servicios.ExceptionYaExiste;
import ar.edu.unlam.tallerweb1.servicios.ServicioTorneo;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ControladorTorneoTest {

    private ServicioTorneo servicioTorneo= mock(ServicioTorneo.class);
    private ControladorTorneo controladorTorneo= new ControladorTorneo(servicioTorneo);

    private static final Torneo TORNEO= new Torneo();

    private DatosTorneo torneo= new DatosTorneo("11", "Juvenil", "4", "18/11/2021", "Ciudad Evita", "Corre Forest, corre!");

    private Torneo elTorneo = new Torneo("11", "Juvenil", "4", "18hs", "18/11/2021", "Ciudad Evita", "Corre Forest, corre!");


    @Test
    public void puedoCrearUnTorneo() throws ExceptionYaExiste {
        ModelAndView modeloVistaTorneo = whenCreoUnNuevoTorneo(torneo);
        thenElTorneoSeCreoConExito(modeloVistaTorneo);
    }

    private void thenElTorneoSeCreoConExito(ModelAndView modeloVistaTorneo) {
        assertThat(modeloVistaTorneo.getViewName()).isEqualTo("torneo-registrado");
        assertThat(modeloVistaTorneo.getModel().get("msg")).isEqualTo("El torneo se creo con éxito");
    }

    private ModelAndView whenCreoUnNuevoTorneo(DatosTorneo torneo) throws ExceptionYaExiste {
        return controladorTorneo.registrarTorneo(torneo);
    }



    @Test
    public void queNoPuedaCrearElFixtureDeUnTorneoIncompleto(){
        givenUnTorneoIncompleto(elTorneo);

        ModelAndView modeloVista = whenRealizoElCruceDeEquipos(elTorneo);

        thenElCruceNoSeRealiza(modeloVista);
    }

    private void givenUnTorneoIncompleto(Torneo torneo) {
        doThrow(Exception.class).when(servicioTorneo).generarCruceDeEquiposDeUnTorneo(elTorneo);
    }


    private ModelAndView whenRealizoElCruceDeEquipos(Torneo torneo) {
        return controladorTorneo.generarCruceDeEquipos(torneo);
    }

    private void thenElCruceNoSeRealiza(ModelAndView modeloVista) {
        //si el torneo elegido esta incompleto, me lleva a la misma vista (vista de todos los torneos con equipos unidos).
        assertThat(modeloVista.getViewName()).isEqualTo("torneos-registrados");
        assertThat(modeloVista.getModel().get("error")).isEqualTo("El torneo está incompleto. No se puede generar el fixture");
    }



    @Test
    public void queSeGenereElFixtureDelTorneoSiEstaCompleto(){
        givenUnTorneoCompleto(elTorneo);

        ModelAndView modeloVista = whenRealizoElCruceDeEquipos(elTorneo);

        thenElCruceSeRealiza(modeloVista);
    }

    private void givenUnTorneoCompleto(Torneo torneo) {

    }

    private void thenElCruceSeRealiza(ModelAndView modeloVista) {
        assertThat(modeloVista.getViewName()).isEqualTo("fixture-generado"); //TODO HACER vista!
    }


}
