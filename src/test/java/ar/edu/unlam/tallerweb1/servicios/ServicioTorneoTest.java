package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Equipo;
import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.modelo.PartidoTorneo;
import ar.edu.unlam.tallerweb1.modelo.Torneo;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioTorneo;
import org.junit.Test;
import org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Java6Assertions.assertThat;


import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ServicioTorneoTest {

    public static final Torneo TORNEO = new Torneo("11", "Juvenil", "4", "18:00", "18/11/2021", "Ciudad Evita", "NombreDelTorneo");
    public static final Torneo TORNEO_NO_EXISTENTE = new Torneo("11", "Juvenil", "8", "20:00", "12/12/2021", "Ciudad Evita", "NombreDelTorneo2");
    public static final List<Torneo> TORNEOS = new ArrayList<Torneo>(10);

    public List<Equipo> equipos = new ArrayList<>();
    public Equipo river = new Equipo();
    public Equipo sanLorenzo = new Equipo();
    public Equipo boca = new Equipo();
    public Equipo racing = new Equipo();

    public List<Equipo> listaEquiposIncompleta = new ArrayList<>();


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


    @Test
    public void puedoRealizarElCruceDeEquiposDeUnTorneo(){
        sanLorenzo.setId(1L);
        sanLorenzo.setNombre("San Lorenzo");
        river.setId(2L);
        river.setNombre("River");
        boca.setId(3L);
        boca.setNombre("Boca");
        racing.setId(4L);
        racing.setNombre("Racing");

        equipos.add(sanLorenzo);
        equipos.add(river);
        equipos.add(boca);
        equipos.add(racing);

        givenUnaListaDeEquiposDeUnTorneo(TORNEO, equipos);

        List<PartidoTorneo> partidosGenerados = whenRealizoElCruceDeLosEquipos(TORNEO);

        thenElCruceEsExitoso(partidosGenerados);
    }

    private void givenUnaListaDeEquiposDeUnTorneo(Torneo torneo, List<Equipo> equipos) {
        when(repositorioTorneo.buscarTorneo(torneo)).thenReturn(torneo);
        when(repositorioTorneo.buscarEquiposDeUnTorneo(torneo)).thenReturn(equipos);
    }

    private List<PartidoTorneo> whenRealizoElCruceDeLosEquipos(Torneo torneo) {
        return servicioTorneo.generarCruceDeEquiposDeUnTorneo(torneo);
    }

    private void thenElCruceEsExitoso(List<PartidoTorneo> partidos) {
        assertThat(partidos).isNotNull();
        assertThat(partidos.size()).isEqualTo(2);
    }


    @Test
    public void noPuedoGenerarCruceDeEquiposEnTorneoIncompleto(){
        sanLorenzo.setId(1L);
        sanLorenzo.setNombre("San Lorenzo");
        boca.setId(3L);
        boca.setNombre("Boca");
        listaEquiposIncompleta.add(sanLorenzo);
        listaEquiposIncompleta.add(boca);

        givenUnaListaIncompletaDeEquiposDeUnTorneo(TORNEO, listaEquiposIncompleta);

        List<PartidoTorneo> partidosTorneo = whenRealizoElCruceDeLosEquipos(TORNEO);

        thenElCruceFalla(partidosTorneo);
    }

    private void givenUnaListaIncompletaDeEquiposDeUnTorneo(Torneo torneo, List<Equipo> listaEquiposIncompleta) {
        when(repositorioTorneo.buscarTorneo(torneo)).thenReturn(torneo);
        when(repositorioTorneo.buscarEquiposDeUnTorneo(torneo)).thenReturn(listaEquiposIncompleta);
    }

    private void thenElCruceFalla(List<PartidoTorneo> partidosTorneo) {
        assertThat(partidosTorneo).isNull();
    }


}
