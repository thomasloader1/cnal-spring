package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.modelo.UsuarioPartido;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.annotation.Rollback;
import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class RepositorioPartidoTest extends SpringTest {

    private static final String Horario= "18:00";
    private static final String Localidad= "Ramos Mejía";
    private static final String Categoria= "Juvenil";
    private static final String SANJUSTO = "San Justo";
    private static final String CIUDADELA = "Ciudadela";
    private static final Long IDUSUARIO = 1L;

    @Autowired
    private RepositorioPartido repositorioPartido;
    MockHttpSession session;


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
        givenQueExistenPartidosConLocalidadYCategoria(SANJUSTO, Categoria, 3);

        List<Partido> partido = whenBuscoPartidoPorCategoriaYLocalidad(SANJUSTO, Categoria);

        thenEncuentroLosPartidosFiltrados(partido, 3);
    }

    private void givenQueExistenPartidosConLocalidadYCategoria(String localidad, String categoria, int cantidadPartidos) {
        for(int i=0; i<cantidadPartidos; i++){
            Partido partidoNuevo = new Partido();
            partidoNuevo.setCant_jugadores(0);
            partidoNuevo.setCant_lugaresDisp(10);
            partidoNuevo.setTipo("5");
            partidoNuevo.setCategoria(categoria);
            partidoNuevo.setLocalidad(localidad);
            partidoNuevo.setHorario("18:00");
            partidoNuevo.setDireccion("Calle "+i);

            session().save(partidoNuevo);
        }
    }

    private List<Partido> whenBuscoPartidoPorCategoriaYLocalidad(String localidad, String categoria) {
        return repositorioPartido.partidosFiltrados(localidad, categoria);
    }

    private void thenEncuentroLosPartidosFiltrados(List<Partido> partidos, int cantidadPartidosEncontrados) {
        assertThat(partidos).hasSize(cantidadPartidosEncontrados);
    }


    @Test
    @Transactional
    @Rollback
    public void traerPartidosPorUsuario(){

        givenPartidosPorUsuario(IDUSUARIO, 1L);

        givenPartidosPorUsuario(IDUSUARIO, 2L);

        givenPartidosPorUsuario(IDUSUARIO, 3L);

        List<Partido> partidos = whenBuscoPartidosPorUsuario(IDUSUARIO);

        thenEncuentroCantidadDePartidosPorUsuario(partidos , 3);
    }

    private void givenPartidosPorUsuario(Long idUsuario, Long idPartido){

            UsuarioPartido usuarioPartido = new UsuarioPartido();

            usuarioPartido.setPrimaryOne(idUsuario);

            usuarioPartido.setPrimaryTwo(idPartido);

            session().save(usuarioPartido);
    }

   private List<Partido> whenBuscoPartidosPorUsuario(Long idUsuario){
        return repositorioPartido.todosLosPartidosPorUsuario(idUsuario);
   }

   private void thenEncuentroCantidadDePartidosPorUsuario(List<Partido> partidos, int cantidadPartidosEncontrados){
       assertThat(partidos).hasSize(cantidadPartidosEncontrados);
   }

}
