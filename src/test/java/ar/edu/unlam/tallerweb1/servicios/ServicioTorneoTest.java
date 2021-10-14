package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Torneo;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioTorneo;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ServicioTorneoTest {

    public static final Torneo TORNEO = new Torneo(1L,"11", "Juvenil", "18:00", "Ciudad Evita", "NombreDelTorneo");
    public static final List<Torneo> TORNEOS = new ArrayList<Torneo>(10);

    private RepositorioTorneo repositorioTorneo = mock(RepositorioTorneo.class);
    private ServicioTorneo servicioTorneo = new ServicioTorneoImpl(repositorioTorneo);


    @Test
    public void puedoListarTodosLosTorneos(){
        givenListaDeTorneos();
        whenListaDeTorneos();
        thenListadoDeTorneos();
    }

    private void whenListaDeTorneos() {
        verify(repositorioTorneo, times(1)).todosLosTorneos();
        TORNEOS.add(TORNEO);
    }

    private void thenListadoDeTorneos() {
        assertEquals(1,TORNEOS.size());
    }

    private void givenListaDeTorneos() {
        servicioTorneo.todosLosTorneos();
    }

    @Test
    public void buscoUnTorneoEspecifico(){
        givenTorneo(TORNEO);
        thenTorneo();
    }

    private void thenTorneo() {
        verify(repositorioTorneo, times(1)).buscarTorneo(TORNEO);
    }


    private void givenTorneo(Torneo torneo) {
        try {
            servicioTorneo.buscarTorneo(torneo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

/*    @Test (expected = Exception.class)
    public void buscoUnTorneoQueNoExiste(){
        givenTorneoQueNoExiste(TORNEO);
        thenTorneo();
    }*/


}
