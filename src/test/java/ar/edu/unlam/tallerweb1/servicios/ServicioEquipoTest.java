package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Equipo;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioEquipo;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ServicioEquipoTest {

    private static final Usuario USUARIO = new Usuario("scortes@mail.com", "123", "usuario");
    private static final Usuario USUARIO2 = new Usuario("mail@mail.com", "123", "usuario");
    private static final Usuario USUARIO3 = new Usuario("scortes@mail.com", "123", "usuario");
    private static final Usuario USUARIO4 = new Usuario("scortes@mail.com", "123", "usuario");
    private static final Usuario USUARIO5 = new Usuario("scortes@mail.com", "123", "usuario");
    private static final Usuario USUARIO6 = new Usuario("scortes@mail.com", "123", "usuario");

    private RepositorioEquipo repositorioEquipo = mock(RepositorioEquipo.class);
    private ServicioEquipo servicioEquipo = new ServicioEquipoImpl(repositorioEquipo);


    private static final Equipo EQUIPO = new Equipo("El Mejor", 3, 5, "Juvenil");
    private static final Equipo EQUIPO_LLENO = new Equipo("El Mejor", 11, 11, "Juvenil");

    private static final Equipo RIVER = new Equipo("River", 3, 5, "Juvenil");
    private static final Equipo SAN_LORENZO = new Equipo("San Lorenzo", 6, 11, "Juvenil");
    private static final Equipo BOCA = new Equipo("Boca", 2, 5, "Juvenil");


    @Test
    public void queMePuedaUnirAUnEquipo() throws Exception {
        USUARIO.setId(2L);
        givenUnUsuarioExistente(USUARIO);
        EQUIPO.setId(2L);
        givenUnEquipoExistente(EQUIPO);

        whenMeUnoAlEquipo(EQUIPO, USUARIO);

        thenSeAgregaUnJugadorMasAlEquipo();
    }


    private void givenUnUsuarioExistente(Usuario usuario) {
        when(repositorioEquipo.buscarJugador(usuario.getId())).thenReturn(usuario);
    }

    private void givenUnEquipoExistente(Equipo equipo) {
        when(repositorioEquipo.buscarEquipo(equipo.getId())).thenReturn(equipo);
    }

    private void whenMeUnoAlEquipo(Equipo equipo, Usuario usuario) throws Exception {
        servicioEquipo.registrarEnEquipo(equipo.getId(), usuario.getId());
    }

    private void thenSeAgregaUnJugadorMasAlEquipo() {
        verify(repositorioEquipo, times(1)).actualizarEquipo(EQUIPO);
    }



    @Test
    public void queNoMePuedaUnirAUnEquipoCompleto() throws Exception {
        USUARIO.setId(1L);
        USUARIO.setEquipo(EQUIPO_LLENO);
        givenUnUsuarioExistente(USUARIO);
        USUARIO2.setId(2L);
        USUARIO2.setEquipo(EQUIPO_LLENO);
        givenUnUsuarioExistente(USUARIO2);
        USUARIO3.setId(3L);
        USUARIO3.setEquipo(EQUIPO_LLENO);
        givenUnUsuarioExistente(USUARIO3);
        USUARIO4.setId(4L);
        USUARIO4.setEquipo(EQUIPO_LLENO);
        givenUnUsuarioExistente(USUARIO4);
        USUARIO5.setId(5L);
        USUARIO5.setEquipo(EQUIPO_LLENO);
        givenUnUsuarioExistente(USUARIO5);
        USUARIO6.setId(6L);
        USUARIO6.setEquipo(EQUIPO_LLENO);
        givenUnUsuarioExistente(USUARIO6);

        List<Usuario> jugadores = new LinkedList<Usuario>();
        jugadores.add(USUARIO);
        jugadores.add(USUARIO2);
        jugadores.add(USUARIO3);
        jugadores.add(USUARIO4);
        jugadores.add(USUARIO5);

        EQUIPO_LLENO.setId(3L);
        givenUnEquipoLleno(EQUIPO_LLENO);

        whenMeUnoAlEquipoLleno(jugadores, EQUIPO_LLENO, USUARIO6);

        thenNoSeAgregaUnJugadorMasAlEquipo(EQUIPO_LLENO);
    }


    private void givenUnEquipoLleno(Equipo equipo) {
        when(repositorioEquipo.buscarEquipo(equipo.getId())).thenReturn(equipo);
    }

    private void whenMeUnoAlEquipoLleno(List<Usuario> jugadores, Equipo equipo, Usuario usuario) throws Exception {
        when(repositorioEquipo.buscarJugadoresDeUnEquipo(equipo)).thenReturn(jugadores);
        servicioEquipo.registrarEnEquipo(equipo.getId(), usuario.getId());
    }

    private void thenNoSeAgregaUnJugadorMasAlEquipo(Equipo equipo) {
        int expected = 5;
        int jugadoresActuales = equipo.getCantidadJugadores();
        assertEquals(expected, jugadoresActuales);
    }


    @Test
    public void puedoListarLosEquipos(){
        givenQueExisteEquipo(RIVER);
        givenQueExisteEquipo(SAN_LORENZO);
        givenQueExisteEquipo(BOCA);

        whenBuscoLosEquipos();

        thenEncuentroLosEquipos();
    }

    private void givenQueExisteEquipo(Equipo equipo) {

    }

    private void whenBuscoLosEquipos() {
        servicioEquipo.buscarTodosLosEquipos();
    }

    private void thenEncuentroLosEquipos() {
        verify(repositorioEquipo, times(1)).traerListaDeEquipos();
    }


}
