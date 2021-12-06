package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Equipo;
import ar.edu.unlam.tallerweb1.modelo.PartidoTorneo;
import ar.edu.unlam.tallerweb1.modelo.Torneo;

import java.util.List;

public interface ServicioTorneo {
    List<Torneo> todosLosTorneos();

    Torneo buscarTorneo(Torneo torneo) throws Exception;

    void registrarTorneo(Torneo crearTorneo) throws ExceptionYaExiste;

    Boolean registrarEnTorneo(Long idTorneo, Long idUsuario) throws Exception;

    List<PartidoTorneo> generarCruceDeEquiposDeUnTorneo(Long idTorneo);

    Torneo buscarTorneoPorId(Long idTorneo);

    List<PartidoTorneo> buscarLosPartidosDeUnTorneo(Torneo torneo);

    List<Equipo> obtenerListaDeEquiposDelTorneo(Long idTorneo);

    boolean partidosExisten(Long idTorneo);

    List<PartidoTorneo> buscarTodosLosPartidosDeLosTorneos();

    void crearNuevoPartidoParaElTorneo(List<PartidoTorneo> partidos, String fase, Torneo torneo);

    void guardarEquipoGanador(Equipo equipoGanador, PartidoTorneo partido);

    PartidoTorneo buscarPartidoPorID(Long idPartido);

    PartidoTorneo buscarPartidoFinalDeUnTorneo(Torneo torneo);

    boolean fueronJugadosPartidos(List<PartidoTorneo> partidos, String fase);
}
