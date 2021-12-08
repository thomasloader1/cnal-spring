package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Equipo;
import ar.edu.unlam.tallerweb1.modelo.PartidoTorneo;
import ar.edu.unlam.tallerweb1.modelo.Torneo;
import ar.edu.unlam.tallerweb1.servicios.ExceptionYaExiste;
import ar.edu.unlam.tallerweb1.servicios.ServicioLocalidad;
import ar.edu.unlam.tallerweb1.servicios.ServicioTorneo;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ControladorTorneoTest {

    private ServicioTorneo servicioTorneo= mock(ServicioTorneo.class);
    private ServicioLocalidad servicioLocalidad= mock(ServicioLocalidad.class);
    private ControladorTorneo controladorTorneo= new ControladorTorneo(servicioTorneo,servicioLocalidad);

    private static final Torneo TORNEO= new Torneo();

    private DatosTorneo torneo= new DatosTorneo("11", "Juvenil", "4", "18/11/2021", "Ciudad Evita", "Corre Forest, corre!");

    private Torneo elTorneo = new Torneo("11", "Juvenil", "4", "18hs", "18/11/2021", "Ciudad Evita", "Corre Forest, corre!");

    List<PartidoTorneo> partidosDelTorneo = new ArrayList<>();
    private static final PartidoTorneo PARTIDO = new PartidoTorneo();
    private static final Equipo EQUIPOUNO = new Equipo();
    private static final Equipo EQUIPODOS = new Equipo();

    @Test
    public void puedoCrearUnTorneo() throws ExceptionYaExiste {
        ModelAndView modeloVistaTorneo = whenCreoUnNuevoTorneo(torneo);
        thenElTorneoSeCreoConExito(modeloVistaTorneo);
    }

    private void thenElTorneoSeCreoConExito(ModelAndView modeloVistaTorneo) {
        assertThat(modeloVistaTorneo.getViewName()).isEqualTo("torneo-registrado");
        assertThat(modeloVistaTorneo.getModel().get("msg")).isEqualTo("El torneo se creo con éxito");
    }

    private ModelAndView whenCreoUnNuevoTorneo(DatosTorneo torneo) throws ExceptionYaExiste {
        return controladorTorneo.registrarTorneo(torneo);
    }



    @Test
    public void queNoPuedaCrearElFixtureDeUnTorneoIncompleto(){
        elTorneo.setId(15L);
        givenUnTorneoIncompleto(elTorneo.getId());

        ModelAndView modeloVista = whenRealizoElCruceDeEquipos(elTorneo.getId());

        thenElCruceNoSeRealiza(modeloVista);
    }

    private void givenUnTorneoIncompleto(Long idTorneo) {
        doThrow(Exception.class).when(servicioTorneo).generarCruceDeEquiposDeUnTorneo(idTorneo);
    }


    private ModelAndView whenRealizoElCruceDeEquipos(Long idTorneo) {
        return controladorTorneo.generarCruceDeEquipos(idTorneo);
    }

    private void thenElCruceNoSeRealiza(ModelAndView modeloVista) {
        //si el torneo elegido esta incompleto, me lleva a la misma vista (vista de todos los torneos con equipos unidos).
        assertThat(modeloVista.getViewName()).isEqualTo("torneos-registrados-fixture");
        assertThat(modeloVista.getModel().get("error")).isEqualTo("Ha ocurrido un error. Volver a intertar");
    }



    @Test
    public void queSeGenereElFixtureDelTorneoSiEstaCompleto(){
        elTorneo.setId(10L);
        givenUnTorneoCompleto(elTorneo.getId());

        ModelAndView modeloVista = whenRealizoElCruceDeEquipos(elTorneo.getId());

        thenElCruceSeRealiza(modeloVista);
    }

    private void givenUnTorneoCompleto(Long idTorneo) {

    }

    private void thenElCruceSeRealiza(ModelAndView modeloVista) {
        assertThat(modeloVista.getViewName()).isEqualTo("fixture-generado"); //TODO HACER vista!
    }


    @Test
    public void queNOSePuedaGenerarElFixtureYPartidosInicialesDeUnTorneoSiYaFueCreado(){
        elTorneo.setId(10L);
        givenUnTorneoConFixtureYPartidosInicialesCreados(elTorneo);

        ModelAndView modeloVistaFixture = whenIntentoCrearElFixtureInicialDeNuevo(elTorneo.getId());

        thenFallaLaCreacion(modeloVistaFixture);
    }

    private void givenUnTorneoConFixtureYPartidosInicialesCreados(Torneo elTorneo) {
        when(servicioTorneo.partidosExisten(elTorneo.getId())).thenReturn(true);
    }

    private ModelAndView whenIntentoCrearElFixtureInicialDeNuevo(Long id) {
        return controladorTorneo.generarCruceDeEquipos(id);
    }

    private void thenFallaLaCreacion(ModelAndView modeloVistaFixture) {
        assertThat(modeloVistaFixture.getViewName()).isEqualTo("torneos-registrados-fixture");
        assertThat(modeloVistaFixture.getModel().get("error")).isEqualTo("El fixture ya esta creado");
    }


    @Test
    public void quePuedaObtenerAlFixtureDeUnTorneoSiYaEstaCreado(){
        elTorneo.setId(10L);
        givenUnTorneoConFixtureYPartidosCreados(elTorneo);

        ModelAndView modeloVistaFixture = whenIntentoObtenerElFixtureInicial(elTorneo.getId());

        thenObtengoElFixtureConPartidosIniciales(modeloVistaFixture);

    }

    private void givenUnTorneoConFixtureYPartidosCreados(Torneo elTorneo) {
        when(servicioTorneo.buscarTorneoPorId(elTorneo.getId())).thenReturn(elTorneo);

        partidosDelTorneo.add(new PartidoTorneo());
        partidosDelTorneo.add(new PartidoTorneo());
        partidosDelTorneo.add(new PartidoTorneo());
        partidosDelTorneo.add(new PartidoTorneo());

        when(servicioTorneo.buscarLosPartidosDeUnTorneo(elTorneo)).thenReturn(partidosDelTorneo);
    }

    private ModelAndView whenIntentoObtenerElFixtureInicial(Long id) {
        return controladorTorneo.mostrarFixture(elTorneo.getId());
    }

    private void thenObtengoElFixtureConPartidosIniciales(ModelAndView modeloVistaFixture) {
        assertThat(modeloVistaFixture.getViewName()).isEqualTo("fixture-generado");
    }

    //Tests equipo ganador

    @Test
    public void quePuedaCrearNuevoPartidoParaLoEquiposGanadores(){
        givenDosEquiposGanadores();
        ModelAndView modeloVista = whenCreoElNuevoPartido(EQUIPOUNO.getNombre(), PARTIDO.getId());
        thenQuedaRegistradoExitosamente(modeloVista);
    }

    private void givenDosEquiposGanadores() {
    }

    private ModelAndView whenCreoElNuevoPartido(String equipo, Long idPartido) {
        return controladorTorneo.guardarEquipoGanadorDelPartido(equipo, idPartido);
    }

    private void thenQuedaRegistradoExitosamente(ModelAndView modeloVista) {
        assertThat(modeloVista.getViewName()).isEqualTo("fixture-generado");
        assertThat(modeloVista.getModel().get("msj")).isEqualTo("Partido creado exitosamente");
    }


}
