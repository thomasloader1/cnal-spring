package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosTorneo;
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
}
