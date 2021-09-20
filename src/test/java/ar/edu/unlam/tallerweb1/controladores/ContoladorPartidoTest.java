package ar.edu.unlam.tallerweb1.controladores;
import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.servicios.ServicioCrearPartido;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.mock;

public class ContoladorPartidoTest {

    private ServicioCrearPartido servicioCrearPartido = mock(ServicioCrearPartido.class);
    private ControladorPartido controladorPartido = new ControladorPartido(servicioCrearPartido);

    private static final Partido PARTIDO = new Partido();
    private Partido datosPartido = PARTIDO;

    @Test
    public void puedoCrearUnPartido(){
        //Partido nuevoPartido = givenNuevoPartido(PARTIDO);
        //Boolean registro = whenRegistroNuevoPartido(nuevoPartido);
        //thenPartidoCreadoConExito(registro);
    }

    @Test
    public void unPartidoLeFaltanJugadores(){
        //givenPartidoExistente(PARTIDO);
        Boolean resultado = whenElPartidoTieneEquipoIncompleto(PARTIDO);
        thenElPartidoLeFaltanJugadores(resultado);
    }

    private void thenElPartidoLeFaltanJugadores(Boolean resultado) {

        assertThat(resultado).isTrue();
    }

    private Boolean whenElPartidoTieneEquipoIncompleto(Partido partido) {
        return controladorPartido.veficarCantidadDeJugadores(partido.getCant_jugadores());
    }

   /* @Test
    public void puedoUnirmeAUnaPartida(){
        givenPartidoExistente();
        whenCargoDatosDelPartido(datosPartido);
        thenPartidoConDatosCargados();
    }*/

    private void givenPartidoExistente() {

    }


    private void whenCargoDatosDelPartido(Partido datosPartido) {
        controladorPartido.validarDatos(datosPartido);
    }

    private void thenPartidoConDatosCargados() {

    }

    private Boolean whenRegistroNuevoPartido(Partido partido) {
        return controladorPartido.registrarPartido(partido);
    }

    private void thenPartidoCreadoConExito(Boolean registro) {
        assertThat(registro).isEqualTo(true);
    }

    //private Partido givenNuevoPartido(Partido partido) {
        //return new Partido(partido.getId(),partido.getCant_jugadores(),partido.getTipo(), partido.getHorario());
   // }
}
