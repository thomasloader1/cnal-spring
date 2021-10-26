package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Equipo;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioEquipo;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ServicioEquipoTest {

    private RepositorioEquipo repositorioEquipo = mock(RepositorioEquipo.class);
    private ServicioEquipo servicioEquipo = new ServicioEquipoImpl(repositorioEquipo);

    private static final Usuario USUARIO = new Usuario("scortes@mail.com", "123");
    private static final Equipo EQUIPO = new Equipo("El Mejor", 3, 5, "Juvenil");
    private static final Equipo EQUIPO_LLENO = new Equipo("El Mejor", 11, 11, "Juvenil");

    private static final Equipo RIVER = new Equipo("River", 3, 5, "Juvenil");
    private static final Equipo SAN_LORENZO = new Equipo("San Lorenzo", 6, 11, "Juvenil");
    private static final Equipo BOCA = new Equipo("Boca", 2, 5, "Juvenil");

    /*
    @Test
*/
    public void queMePuedaUnirAUnEquipo() throws Exception {
        givenUnUsuarioExistente(USUARIO);
        EQUIPO.setId(2L);
        givenUnEquipoExistente(EQUIPO);

        whenMeUnoAlEquipo(EQUIPO, USUARIO);

        thenSeAgregaUnJugadorMasAlEquipo();
    }


    private void givenUnUsuarioExistente(Usuario usuario) {
    }

    private void givenUnEquipoExistente(Equipo equipo) {
        when(repositorioEquipo.buscarEquipo(equipo.getId())).thenReturn(EQUIPO);
    }

    private void whenMeUnoAlEquipo(Equipo equipo, Usuario usuario) throws Exception {
        servicioEquipo.registrarEnEquipo(equipo.getId(), usuario);
    }

    private void thenSeAgregaUnJugadorMasAlEquipo() {
        verify(repositorioEquipo, times(1)).actualizarEquipo(EQUIPO);
    }




/*
    @Test
*/
    public void queNoMePuedaUnirAUnEquipoCompleto() throws Exception {
        givenUnUsuarioExistente(USUARIO);
        EQUIPO_LLENO.setId(3L);
        givenUnEquipoLleno(EQUIPO_LLENO);

        whenMeUnoAlEquipo(EQUIPO_LLENO, USUARIO);

        thenNoSeAgregaUnJugadorMasAlEquipo();
    }


    private void givenUnEquipoLleno(Equipo equipo) {
        doThrow(Exception.class).when(repositorioEquipo).buscarEquipo(equipo.getId());
    }

    private void thenNoSeAgregaUnJugadorMasAlEquipo() {
        verify(repositorioEquipo, never()).actualizarEquipo(EQUIPO_LLENO);
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


/*
    @Test
    public void queNoMePuedaUnirAUnEquipoSiYaMeUni(){

    }
*/

}
