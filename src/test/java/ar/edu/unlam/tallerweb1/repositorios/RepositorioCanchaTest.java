package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Cancha;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class RepositorioCanchaTest extends SpringTest {

    private static final String SANJUSTO = "San Justo";
    private static final String CIUDADELA = "Ciudadela";

    Cancha CANCHA = new Cancha("Monumental", "Nuñez", "Villegas", 100D, true, 1);
    Cancha CANCHA2 = new Cancha("Camp Nou", "España", "Pues Tio", 100D, true, 1);
    Usuario USUARIO = new Usuario("nahuel@asd.com", "asd", "Admin", "Nahuel", "Pepe", null);

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

    /*@Test
    @Rollback @Transactional
    public void buscarCanchasPorDuenio()
    {
        USUARIO.setId(1L);
        givenCanchasPorDuenio(USUARIO, CANCHA);
        givenCanchasPorDuenio(USUARIO, CANCHA2);
        List<Cancha> canchas = whenBuscoCanchasPorDuenio(USUARIO);
        thenEncuentroLasCanchasPorDuenio(canchas, 2);
    }

    private void givenCanchasPorDuenio(Usuario usuario, Cancha cancha)
    {
        for(Long i=0L; i<2L; i++){
            cancha.setId(i+1L);
            cancha.setUsuario(usuario);
            session().save(cancha);
        }
    }

    private List<Cancha> whenBuscoCanchasPorDuenio(Usuario usuario)
    {
        return repositorioCancha.todasLasCanchasPorAdmin(usuario);
    }

    private void thenEncuentroLasCanchasPorDuenio(List<Cancha> canchas,  int cantidadCanchasEncontradas)
    {
        assertThat(canchas).hasSize(cantidadCanchasEncontradas);
    }
*/

}
