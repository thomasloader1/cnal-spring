package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Torneo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import javax.transaction.Transactional;
import java.util.List;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class RepositorioTorneoTest extends SpringTest {
    Torneo TORNEO= new Torneo("5", "Juvenil", "4", "18:00", "28/10/2021", "Hurlingam", "Cornalitos");

    @Autowired
    private RepositorioTorneo repositorioTorneo;

    @Test
    @Transactional
    @Rollback
    public void queSeGuardeUnTorneo() throws Exception {
        givenGuardoTorneo(TORNEO);
        List<Torneo> torneitos= whenEncunetroElTorneo();
        thenSeGuardoConExito(torneitos, 1);
    }

    private void thenSeGuardoConExito(List<Torneo> torneo, int torneosEncontrados) {

        assertThat(torneo).hasSize(torneosEncontrados);
    }

    private List<Torneo> whenEncunetroElTorneo() {
        List<Torneo> torneos= repositorioTorneo.todosLosTorneos();
        return torneos;
    }

    private void givenGuardoTorneo(Torneo torneo) {
        TORNEO.setId(1L);
        repositorioTorneo.guardarTorneo(torneo);
    }



    @Test
    public void puedoObtenerLosEquiposDeUnTorneo(){

    }


    @Test
    public void puedoObtenerLosPartidosDeUnTorneo(){


    }
}
