package ar.edu.unlam.tallerweb1.controladores;
import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.servicios.ServicioPartido;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ContoladorPartidoTest {

    private ServicioPartido servicioCrearPartido = mock(ServicioPartido.class);
    private ControladorPartido controladorPartido = new ControladorPartido(servicioCrearPartido);

    private static final Partido PARTIDO = new Partido(5L, 6, 0, "5", "Adulto", "21:00","San Justo");

    private DatosCrearPartido partido = new DatosCrearPartido(6, "5", "Adulto", "21:00","");
    private DatosCrearPartido partidoConCategoriaInvalida = new DatosCrearPartido(6, "11", "Niños", "20:00","");
    private DatosCrearPartido partidoConTipoInvalido = new DatosCrearPartido(6, "3", "Infantil", "20:00","");
    private DatosCrearPartido partidoConCantidadJugadoresInvalida = new DatosCrearPartido(25, "11", "adulto", "22:00","");
    private DatosCrearPartido partidoLleno = new DatosCrearPartido(10, "5", "Juvenil", "18:00","");

    //private Partido datosPartido = PARTIDO;

    @Test
    public void puedoCrearUnPartido(){
        givenQueUnPartidoNoExiste(partido);

        ModelAndView modeloVistaPartido = whenCreoUnNuevoPartido(partido);

        thenElPartidoSeCreaExitosamente(modeloVistaPartido);
    }

    @Test
    public void noPuedoCrearPartidoPorCategoriaInvalida(){
        givenQueUnPartidoNoExiste(partidoConCategoriaInvalida);

        ModelAndView modeloVistaPartido = whenCreoUnNuevoPartido(partidoConCategoriaInvalida);

        thenLaCreacionDelPartidoFalla(modeloVistaPartido);
    }

    @Test
    public void noPuedoCrearPartidoPorTipoInvalido(){
        givenQueUnPartidoNoExiste(partidoConTipoInvalido);

        ModelAndView modeloVistaPartido = whenCreoUnNuevoPartido(partidoConTipoInvalido);

        thenLaCreacionDelPartidoFallaPorTipoInvalido(modeloVistaPartido);
    }

    @Test
    public void noPuedoCrearPartidoPorCantidadJugadoresIncorrecta(){
        givenQueUnPartidoNoExiste(partidoConCantidadJugadoresInvalida);

        ModelAndView modeloVistaPartido = whenCreoUnNuevoPartido(partidoConCantidadJugadoresInvalida);

        thenLaCreacionDelPartidoFallaPorCantidadJugadores(modeloVistaPartido);
    }

    @Test
    public void puedoUnirmeAUnPartido(){
        givenUnPartidoConLugaresDisponibles(partido);

        //ModelAndView modeloVistaUnirmePartido = whenMeUnoAlPartido(partido);

        //thenLaUnionAlPartidoEsExitosa(modeloVistaUnirmePartido);
    }
    
/*
    @Test
    public void noPuedoUnirmeAUnPartidoLleno(){
        givenUnPartidoLleno(partidoLleno);

        ModelAndView modeloVistaUnirmePartido = whenMeUnoAlPartido(partidoLleno);

        thenLaUnionAlPartidoFalla(modeloVistaUnirmePartido);
    }


    private void givenUnPartidoLleno(DatosCrearPartido partidoLleno) {
    }

    private void thenLaUnionAlPartidoFalla(ModelAndView modeloVista) {
        assertThat(modeloVista.getViewName()).isEqualTo("unirme-al-partido");
        assertThat(modeloVista.getModel().get("msg")).isEqualTo("El partido seleccionado ya esta completo");
    }
*/



    private void givenUnPartidoConLugaresDisponibles(DatosCrearPartido partido) {
    }

    //private ModelAndView whenMeUnoAlPartido(DatosCrearPartido partido) {
        //return controladorPartido.unirseAUnPartido(partido);
    //}

    private void thenLaUnionAlPartidoEsExitosa(ModelAndView modeloVistaUnirmePartido) {
        assertThat(modeloVistaUnirmePartido.getViewName()).isEqualTo("union-a-partido");
        assertThat(modeloVistaUnirmePartido.getModel().get("msg")).isEqualTo("¡Te uniste al partido correctamente!");
    }


    private void givenQueUnPartidoNoExiste(DatosCrearPartido partido) {
    }
    private ModelAndView whenCreoUnNuevoPartido(DatosCrearPartido nuevoPartido) {

        return controladorPartido.registrarPartido(nuevoPartido);
    }
    private void thenElPartidoSeCreaExitosamente(ModelAndView modeloVistaPartido) {
        assertThat(modeloVistaPartido.getViewName()).isEqualTo("partido-registrado");
        assertThat(modeloVistaPartido.getModel().get("msg")).isEqualTo("El partido se creo con éxito");
        assertThat(modeloVistaPartido.getModel().get("categoria")).isEqualTo(partido.getCategoria());
        assertThat(modeloVistaPartido.getModel().get("horario")).isEqualTo(partido.getHorario());
    }

    private void thenLaCreacionDelPartidoFalla(ModelAndView modeloVistaPartido) {
        assertThat(modeloVistaPartido.getViewName()).isEqualTo("registro-partido");
        assertThat(modeloVistaPartido.getModel().get("msg")).isEqualTo("La categoría es incorrecta.");
        verify(servicioCrearPartido, never()).registrar(any());
    }

    private void thenLaCreacionDelPartidoFallaPorTipoInvalido(ModelAndView modeloVistaPartido) {
        assertThat(modeloVistaPartido.getViewName()).isEqualTo("registro-partido");
        assertThat(modeloVistaPartido.getModel().get("msg")).isEqualTo("El tipo de partido ingresado es incorrecto.");
        verify(servicioCrearPartido, never()).registrar(any());
    }

    private void thenLaCreacionDelPartidoFallaPorCantidadJugadores(ModelAndView modeloVistaPartido) {
        assertThat(modeloVistaPartido.getViewName()).isEqualTo("registro-partido");
        assertThat(modeloVistaPartido.getModel().get("msg")).isEqualTo("La cantidad de jugadores es inválida para el tipo de partido elegido");
        verify(servicioCrearPartido, never()).registrar(any());
    }





/*
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
*/

   /* @Test
    public void puedoUnirmeAUnaPartida(){
        givenPartidoExistente();
        whenCargoDatosDelPartido(datosPartido);
        thenPartidoConDatosCargados();
    }*/

/*
    private void givenPartidoExistente() {

    }


    private void whenCargoDatosDelPartido(Partido datosPartido) {
        controladorPartido.validarDatos(datosPartido);
    }

    private void thenPartidoConDatosCargados() {

    }
*/

    //private Boolean whenRegistroNuevoPartido(Partido partido) {
      //  return controladorPartido.registrarPartido(partido);
    //}

/*
    private void thenPartidoCreadoConExito(Boolean registro) {
        assertThat(registro).isEqualTo(true);
    }
*/

    //private Partido givenNuevoPartido(Partido partido) {
        //return new Partido(partido.getId(),partido.getCant_jugadores(),partido.getTipo(), partido.getHorario());
   // }
}
