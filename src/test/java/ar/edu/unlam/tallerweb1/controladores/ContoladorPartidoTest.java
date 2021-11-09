package ar.edu.unlam.tallerweb1.controladores;
import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.servicios.ServicioLocalidad;
import ar.edu.unlam.tallerweb1.servicios.ServicioPartido;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ContoladorPartidoTest {

    private ServicioPartido servicioCrearPartido = mock(ServicioPartido.class);
    private ServicioLocalidad servicioLocalidad = mock(ServicioLocalidad.class);
    private ServicioUsuario servicioUsuario = mock(ServicioUsuario.class);
    private ControladorPartido controladorPartido = new ControladorPartido(servicioCrearPartido, servicioLocalidad,servicioUsuario);

    private static final Partido PARTIDO = new Partido(6, 0, "5", "Adulto", "21:00","San Justo", "");

    private DatosCrearPartido partido = new DatosCrearPartido(6, "5", "Adulto", "21:00","", "");
    private DatosCrearPartido nuevoPartido = new DatosCrearPartido(6, "5", "Adulto", "21:00","", "");
    private DatosCrearPartido partidoConCategoriaInvalida = new DatosCrearPartido(6, "11", "Niños", "20:00","", "");
    private DatosCrearPartido partidoConTipoInvalido = new DatosCrearPartido(6, "3", "Infantil", "20:00","", "");
    private DatosCrearPartido partidoConCantidadJugadoresInvalida = new DatosCrearPartido(25, "11", "adulto", "22:00","", "");
    private DatosCrearPartido partidoLleno = new DatosCrearPartido(10, "5", "Juvenil", "18:00","","");

    //private Partido datosPartido = PARTIDO;

    @Test
    public void puedoCrearUnPartido() throws Exception {
/*
        givenQueUnPartidoNoExiste(partido);
*/
        ModelAndView modeloVistaPartido = whenCreoUnNuevoPartido(nuevoPartido);
        thenElPartidoSeCreaExitosamente(modeloVistaPartido);
    }
    private void givenQueUnPartidoNoExiste(DatosCrearPartido partido) throws Exception {
        try {
            servicioCrearPartido.consultarPartido(partido.getHorario(),partido.getCategoria());
        }
        catch (Exception e) {
            throw new Exception("givenQueUnPartidoNoExiste");
        }
    }
    private ModelAndView whenCreoUnNuevoPartido(DatosCrearPartido nuevoPartido) {
        return controladorPartido.registrarPartido(nuevoPartido);
    }
    private void thenElPartidoSeCreaExitosamente(ModelAndView modeloVistaPartido) {
        assertThat(modeloVistaPartido.getViewName()).isEqualTo("partido-registrado");
        assertThat(modeloVistaPartido.getModel().get("msg")).isEqualTo("El partido se creo con éxito");
        //TODO testear que el modelo que ingresa es de la misma categoria
        //EJemplo: assertThat(modeloVistaPartido.getModel().get("partido.categoria")).isEqualTo(partido.getCategoria());
       // assertThat(modeloVistaPartido.getModel().get("categoria")).isEqualTo(partido.getCategoria());
    }

    @Test
    public void noPuedoCrearPartidoPorCategoriaInvalida() throws Exception {
        givenQueUnPartidoNoExiste(partidoConCategoriaInvalida);
        ModelAndView modeloVistaPartido = whenCreoUnNuevoPartido(partidoConCategoriaInvalida);
        thenLaCreacionDelPartidoFalla(modeloVistaPartido);
    }
    private void thenLaCreacionDelPartidoFalla(ModelAndView modeloVistaPartido) {
        assertThat(modeloVistaPartido.getViewName()).isEqualTo("registro-partido");
        assertThat(modeloVistaPartido.getModel().get("msg")).isEqualTo("La categoría es incorrecta.");
        verify(servicioCrearPartido, never()).registrarPartido(any());
    }

    @Test
    public void noPuedoCrearPartidoPorTipoInvalido() throws Exception {
        givenQueUnPartidoNoExiste(partidoConTipoInvalido);
        ModelAndView modeloVistaPartido = whenCreoUnNuevoPartido(partidoConTipoInvalido);
        thenLaCreacionDelPartidoFallaPorTipoInvalido(modeloVistaPartido);
    }
    private void thenLaCreacionDelPartidoFallaPorTipoInvalido(ModelAndView modeloVistaPartido) {
        assertThat(modeloVistaPartido.getViewName()).isEqualTo("registro-partido");
        assertThat(modeloVistaPartido.getModel().get("msg")).isEqualTo("El tipo de partido ingresado es incorrecto.");
        verify(servicioCrearPartido, never()).registrarPartido(any());
    }
    
    @Test
    public void noPuedoCrearPartidoPorCantidadJugadoresIncorrecta() throws Exception {
        givenQueUnPartidoNoExiste(partidoConCantidadJugadoresInvalida);
        ModelAndView modeloVistaPartido = whenCreoUnNuevoPartido(partidoConCantidadJugadoresInvalida);
        thenLaCreacionDelPartidoFallaPorCantidadJugadores(modeloVistaPartido);
    }

    private void thenLaCreacionDelPartidoFallaPorCantidadJugadores(ModelAndView modeloVistaPartido) {
        assertThat(modeloVistaPartido.getViewName()).isEqualTo("registro-partido");
        assertThat(modeloVistaPartido.getModel().get("msg")).isEqualTo("La cantidad de jugadores es inválida para el tipo de partido elegido");
        verify(servicioCrearPartido, never()).registrarPartido(any());
    }


    @Test
    public void puedoUnirmeAUnPartido() throws Exception {
        givenUnPartidoConLugaresDisponibles(partido);
        //ModelAndView modeloVistaUnirmePartido = whenMeUnoAlPartido(partido);
        //thenLaUnionAlPartidoEsExitosa(modeloVistaUnirmePartido);
    }
    private void givenUnPartidoConLugaresDisponibles(DatosCrearPartido partido) throws Exception {
        try {
            servicioCrearPartido.consultarPartido(partido.getHorario(),partido.getCategoria());
        }
        catch (Exception e) {
            throw new Exception("givenUnPartidoConLugaresDisponibles");
        }
    }
    //private ModelAndView whenMeUnoAlPartido(DatosCrearPartido partido) {return controladorPartido.unirseAUnPartido(partido , PARTIDO.getId());}

    private void thenLaUnionAlPartidoEsExitosa(ModelAndView modeloVistaUnirmePartido) {
        assertThat(modeloVistaUnirmePartido.getViewName()).isEqualTo("union-a-partido");
        assertThat(modeloVistaUnirmePartido.getModel().get("msg")).isEqualTo("¡Te uniste al partido correctamente!");
    }


    @Test
    public void noPuedoUnirmeAUnPartidoLleno() throws Exception {
        givenUnPartidoLleno(partidoLleno);
        //ModelAndView modeloVistaUnirmePartido = whenNoMeUnoAlPartido(partidoLleno);
        //thenLaUnionAlPartidoFalla(modeloVistaUnirmePartido);
    }
    private void givenUnPartidoLleno(DatosCrearPartido partidoLleno) throws Exception {
        try {
            servicioCrearPartido.consultarPartido(partidoLleno.getHorario(),partidoLleno.getCategoria());
        }
        catch (Exception e) {
            throw new Exception("givenUnPartidoLleno");
        }
    }
    /*private ModelAndView whenNoMeUnoAlPartido(DatosCrearPartido partido) {
        return controladorPartido.unirseAUnPartido(partido , PARTIDO.getId());
    }*/
    private void thenLaUnionAlPartidoFalla(ModelAndView modeloVista) {
        assertThat(modeloVista.getViewName()).isNotEqualTo("unirme-al-partido");
    }


    @Test
    public void unPartidoLeFaltanJugadores(){
        //givenPartidoExistente(PARTIDO);
        Boolean resultado = whenElPartidoTieneEquipoIncompleto(PARTIDO);
        thenElPartidoLeFaltanJugadores(resultado);
    }

    private void thenElPartidoLeFaltanJugadores(Boolean resultado) {
        assertThat(resultado).isFalse();
    }

    private Boolean whenElPartidoTieneEquipoIncompleto(Partido partido) {
        return controladorPartido.veficarCantidadDeJugadores(partido);
    }

}
