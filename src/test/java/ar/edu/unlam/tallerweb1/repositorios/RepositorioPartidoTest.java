package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Partido;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import javax.transaction.Transactional;

public class RepositorioPartidoTest extends SpringTest {

    private static final String Horario= "18:00";
    private static final String Localidad= "Ramos Mejía";
    private static final String Categoria= "Juvenil";

    @Autowired
    private RepositorioPartido repositorioPartido;

    @Test
    @Transactional
    @Rollback
    public void buscarPartidoPorHoraYCategoria() throws Exception {

        givenQueExistenPartidosConHoraYCategoria(Horario, Categoria);

        Partido partido= whenBuscoPartidosPorHoraYCategoria(Horario, Categoria);

        thenEncuentroLosPartidos(partido);
    }

    private void thenEncuentroLosPartidos(Partido partido) {
        Assert.assertNotNull(partido);
    }

    private Partido whenBuscoPartidosPorHoraYCategoria(String horario, String categoria) throws Exception {
        return repositorioPartido.buscarPartido(horario, categoria);
    }

    private void givenQueExistenPartidosConHoraYCategoria(String horario, String categoria) {

        Partido partido= new Partido();
        partido.setCategoria(categoria);
        partido.setHorario(horario);

        session().save(partido);
    }


    @Test
    @Transactional
    @Rollback
    public void guardarPartido(){

    }

    @Test
    @Transactional
    @Rollback
    public void traerTodosLosPartidos(){

    }

    @Test
    @Transactional
    @Rollback
    public void traerPartidosFiltradosPorCategoriaYLocalidad(){

    }

}
