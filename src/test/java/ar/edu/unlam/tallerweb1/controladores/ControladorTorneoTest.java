package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Torneo;
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

    @Test
    public void puedoCrearUnTorneo(){
        ModelAndView modeloVistaTorneo = whenCreoUnNuevoTorneo(torneo);
        thenElTorneoSeCreóConExito(modeloVistaTorneo);
    }

    private void thenElTorneoSeCreóConExito(ModelAndView modeloVistaTorneo) {
        assertThat(modeloVistaTorneo.getViewName()).isEqualTo("torneo-registrado");
        assertThat(modeloVistaTorneo.getModel().get("msg")).isEqualTo("El torneo se creo con éxito");
    }

    private ModelAndView whenCreoUnNuevoTorneo(DatosTorneo torneo) {
        return controladorTorneo.registrarTorneo(torneo);
    }

}
