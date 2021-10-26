package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.modelo.Torneo;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioTorneo;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ServicioTorneoTest {

    public static final Torneo TORNEO = new Torneo("11", "Juvenil", "4", "18/11/2021", "Ciudad Evita", "NombreDelTorneo");
    public static final Torneo TORNEO_NO_EXISTENTE = new Torneo("11", "Juvenil", "8", "12/12/2021", "Ciudad Evita", "NombreDelTorneo2");
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

    @Test (expected = Exception.class)
    public void buscoUnTorneoQueNoExiste() {
        givenTorneoQueNoExiste();
        thenTorneoQueNoExiste(TORNEO_NO_EXISTENTE);
    }

    private void thenTorneoQueNoExiste(Torneo torneoNoExistente) {
        verify(repositorioTorneo,never()).buscarTorneo(torneoNoExistente);
    }

    private void givenTorneoQueNoExiste()  {
        when(repositorioTorneo.buscarTorneo(any())).thenThrow(new Exception());
    }

    @Test
    public void queSePuedaRegistrarUnTorneo(){
        TORNEO.setId(2L);
        givenTorneoExiste(TORNEO);
        whenRegistroTorneo(TORNEO);
        thenElTorneoSeGuarda(TORNEO);
    }

    private void givenTorneoExiste(Torneo torneo) {
        when(repositorioTorneo.buscarTorneo(torneo)).thenReturn(null);
    }

    private void whenRegistroTorneo(Torneo torneo) {
        try {
            servicioTorneo.registrarTorneo(torneo);
        } catch (ExceptionYaExiste e) {
            e.printStackTrace();
        }
    }

    private void thenElTorneoSeGuarda(Torneo torneo){
        verify(repositorioTorneo,times(1)).guardarTorneo(torneo);
    }

}
