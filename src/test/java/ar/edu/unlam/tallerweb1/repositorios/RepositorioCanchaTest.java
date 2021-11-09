package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Cancha;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class RepositorioCanchaTest extends SpringTest {

    private static final String SANJUSTO = "San Justo";
    private static final String CIUDADELA = "Ciudadela";

    @Autowired
    private RepositorioCancha repositorioCancha;


    @Test
    @Rollback @Transactional
    public void buscarCanchasPorLocalidadDeberiaTraerSoloPorEsaLocalidad(){

        givenQueExistenCanchasConLocalidad(SANJUSTO, 3);
        givenQueExistenCanchasConLocalidad(CIUDADELA, 2);

        List<Cancha> canchas = whenBuscoCanchasPorLocalidad(SANJUSTO);

        thenEncuentroLasCanchas(canchas, 3);
    }

    private void givenQueExistenCanchasConLocalidad(String localidad, int cantidadCanchas) {
        for(int i=0; i<cantidadCanchas; i++){
            Cancha canchaNueva = new Cancha();
            canchaNueva.setNombre("Canchita"+i);
            canchaNueva.setLocalidad(localidad);
            canchaNueva.setDomicilio("Arieta "+ i);

            session().save(canchaNueva);
        }
    }

    private List<Cancha> whenBuscoCanchasPorLocalidad(String localidad) {
        return repositorioCancha.buscarCanchaPorLocalidad(localidad);
    }

    private void thenEncuentroLasCanchas(List<Cancha> canchas, int cantidadCanchasEncontradas) {
        assertThat(canchas).hasSize(cantidadCanchasEncontradas);
    }


}
