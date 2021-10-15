package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPartido;
import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.never;

public class ServicioPartidoTest {

    public static final Partido PARTIDO = new Partido(5, 17, "11","Juvenil","18:00","San Justo");
    private RepositorioPartido repositorioPartido = mock(RepositorioPartido.class);
    private ServicioPartido servicioPartido = new ServicioPartidoImpl(repositorioPartido);


    @Test(expected = Exception.class)
    public void siRegistroConHoraOcupadaDaError() throws Exception {
        givenPartidoYaExiste(PARTIDO);
        whenResgistro(PARTIDO);
        thenElPartidoNoSeGuarda();
    }

    private void givenPartidoYaExiste(Partido partido) {
        try {
            when(repositorioPartido.buscarPartido(partido.getHorario(), partido.getCategoria())).thenReturn(PARTIDO);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void whenResgistro(Partido partido)  throws Exception{
        try {
            servicioPartido.consultarPartido(partido.getHorario(), partido.getCategoria());
            servicioPartido.registrarPartido(partido);

        } catch (Exception e) {
            throw new Exception();
        }
    }

    private void thenElPartidoNoSeGuarda() {
        verify(repositorioPartido, never()).guardarPartido(any());
    }

    @Test
    public void puedoRegistrarUnPartido() throws Exception {
        PARTIDO.setId(2L);
        PARTIDO.setHorario("20:00");
        givenPartidoNoExiste(PARTIDO);
        whenResgistroPartido(PARTIDO);
        thenElPartidoSeGuarda();
    }

    private void givenPartidoNoExiste(Partido partido) {
        try {
            when(repositorioPartido.buscarPartido(partido.getHorario(), partido.getCategoria())).thenReturn(PARTIDO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void whenResgistroPartido(Partido partido) throws Exception {
        try {
            servicioPartido.registrarPartido(partido);

        } catch (Exception e) {
            throw new Exception("whenResgistroPartidoException");
        }
    }

    private void thenElPartidoSeGuarda() {
        verify(repositorioPartido, times(1)).guardarPartido(any());
    }

    @Test
    public void puedoUnirmeAUnPartido() throws Exception {
        PARTIDO.setId(3L);
        PARTIDO.setCant_jugadores(PARTIDO.getCant_jugadores() + 1);
        givenPartidoCompleto(PARTIDO);
        whenUnirmePartido(PARTIDO);
        thenSeSumaUnJugador();
    }

    private void givenPartidoCompleto(Partido partido) {
        try {
            servicioPartido.partidoLleno(partido);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void whenUnirmePartido(Partido partido)throws Exception {
        try {
            servicioPartido.unirmeAlPartido(partido);
        } catch (Exception e) {
            throw new Exception("whenUnirmeAlPartidoException");
        }
    }
    private void thenSeSumaUnJugador() {
        verify(repositorioPartido,times(1)).unirmeAlPartido(PARTIDO);
    }

    @Test
    public void puedoListarTodosLosPartidos(){
        givenListarPartidos();
        thenListarPartidos();
    }
    private void givenListarPartidos(){servicioPartido.todosLosPartidos();}
    private void thenListarPartidos() {verify(repositorioPartido,times(1)).todosLosPartidos();}

    @Test
    public void puedoFiltrarUnPartido(){
        givenPartidoConFiltros(PARTIDO);
        whenFiltarPartido(PARTIDO);
    }

    private void givenPartidoConFiltros(Partido partido) {
        servicioPartido.partidoConFiltros(partido);
    }

    private void whenFiltarPartido(Partido partido) {
        servicioPartido.filtrarPartidos(partido.getLocalidad(), partido.getCategoria());
    }
//
//    @Test
//    public void queResteUnLugar(){
//        PARTIDO.setId(2L);
//        givenUnirmePartido(PARTIDO);
//        thenSeResta();
//    }
//
//    private void givenUnirmePartido(Partido partido) {
//        servicioPartido.unirmeAlPartido(PARTIDO);
//    }
//
//    private void thenSeResta() {
//        Integer expected=16;
//        Integer actual = PARTIDO.getCant_lugaresDisp();
//        assertEquals(expected, actual);
//    }

}

