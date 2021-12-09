package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Cancha;
import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.UsuarioPartido;
import ar.edu.unlam.tallerweb1.servicios.ServicioPartido;
import ar.edu.unlam.tallerweb1.servicios.ServicioPartidoImpl;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.annotation.Rollback;
import javax.transaction.Transactional;
import java.time.Instant;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class RepositorioPartidoTest extends SpringTest {

    private static final String Horario= "18:00";
    private static final String Localidad= "Ramos Mejía";
    private static final String Categoria= "Juvenil";
    private static final String SANJUSTO = "San Justo";
    private static final String CIUDADELA = "Ciudadela";
    private static final Long IDUSUARIO = 1L;

    Usuario USUARIO = new Usuario("email", "pass", "ADMIN", "nombre", "apellido", Date.from(Instant.now()));
    Partido PARTIDO = new Partido(9, 5, "5", "Juvenil", "20:00", "Merlo", "calle falsa 123", Date.from(Instant.now()));
    Partido PARTIDO2 = new Partido(8, 6, "5", "Juvenil", "21:00", "Merlo", "calle falsa 456", Date.from(Instant.now()));
    @Autowired
    private RepositorioPartido repositorioPartido;
    MockHttpSession session;
    @Autowired
    RepositorioCancha repositorioCancha;

    ServicioPartido servicioPartido = new ServicioPartidoImpl(repositorioPartido);


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
        givenGuardoPartido (PARTIDO);
        List<Partido> partidoEncontrado = thenEncuentroElPartido();
        whenEncontréElPartido(partidoEncontrado, 1);
    }

    private void whenEncontréElPartido(List<Partido> partidoEncontrado, int cantidadDeEncontrados) {
        assertThat(partidoEncontrado.size()).isEqualTo(cantidadDeEncontrados);
    }

    private List<Partido> thenEncuentroElPartido() {
        return repositorioPartido.todosLosPartidos();
    }

    private void givenGuardoPartido(Partido partido) {
        repositorioPartido.guardarPartido(partido);
    }

    @Test
    @Transactional
    @Rollback
    public void traerTodosLosPartidos(){
        givenGuardoPartido(PARTIDO);
        givenGuardoPartido(PARTIDO2);
        List<Partido> partidos = thenBuscoLosPartidos();
        whenTraigoLosPartidos(partidos, 2);
    }

    private void whenTraigoLosPartidos(List<Partido> partidos, int i) {
        assertThat(partidos.size()).isEqualTo(i);
    }

    private List<Partido> thenBuscoLosPartidos() {
        return repositorioPartido.todosLosPartidos();
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

    @Test
    @Transactional
    @Rollback
    public void buscarUsuarioPartido(){
        USUARIO.setId(1L);
        PARTIDO.setId(1L);
        givenUnoUsuarioAPartido(USUARIO.getId(), PARTIDO.getId());
        UsuarioPartido usuarioPartido = whenEncuentroUsuarioPartido(USUARIO.getId(), PARTIDO.getId());
        thenEncontreElUsusarioPartido(usuarioPartido);
    }

    private void thenEncontreElUsusarioPartido(UsuarioPartido usuarioPartido) {
        Long expected = 1L;
        Long actual = usuarioPartido.getPrimaryOne();
        Assert.assertEquals(expected, actual);
    }

    private UsuarioPartido whenEncuentroUsuarioPartido(Long idUsuario, Long idPartido){
        return repositorioPartido.buscarUsuarioPartido(idUsuario, idPartido);
    }

    private void givenUnoUsuarioAPartido( Long idUsuario, Long idPartido){
        UsuarioPartido usuarioPartido = new UsuarioPartido();

        usuarioPartido.setPrimaryOne(idUsuario);

        usuarioPartido.setPrimaryTwo(idPartido);

        session().save(usuarioPartido);
    }

    @Test
    @Transactional
    @Rollback
    public void buscarUsuarioPartido(){
        USUARIO.setId(1L);
        PARTIDO.setId(1L);
        givenUnoUsuarioAPartido(USUARIO.getId(), PARTIDO.getId());
        UsuarioPartido usuarioPartido = whenEncuentroUsuarioPartido(USUARIO.getId(), PARTIDO.getId());
        thenEncontreElUsusarioPartido(usuarioPartido);
    }

    private void thenEncontreElUsusarioPartido(UsuarioPartido usuarioPartido) {
        Long expected = 1L;
        Long actual = usuarioPartido.getPrimaryOne();
        Assert.assertEquals(expected, actual);
    }

    private UsuarioPartido whenEncuentroUsuarioPartido(Long idUsuario, Long idPartido){
        return repositorioPartido.buscarUsuarioPartido(idUsuario, idPartido);
    }

    private void givenUnoUsuarioAPartido( Long idUsuario, Long idPartido){
        UsuarioPartido usuarioPartido = new UsuarioPartido();

        usuarioPartido.setPrimaryOne(idUsuario);

        usuarioPartido.setPrimaryTwo(idPartido);

        session().save(usuarioPartido);
    }

}

}

