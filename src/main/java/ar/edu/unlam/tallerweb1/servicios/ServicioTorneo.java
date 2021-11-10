package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosTorneo;
import ar.edu.unlam.tallerweb1.modelo.PartidoTorneo;
import ar.edu.unlam.tallerweb1.modelo.Torneo;

import java.util.List;

public interface ServicioTorneo {
    List<Torneo> todosLosTorneos();

    Torneo buscarTorneo(Torneo torneo) throws Exception;

    void registrarTorneo(Torneo crearTorneo) throws ExceptionYaExiste;

    List<PartidoTorneo> generarCruceDeEquiposDeUnTorneo(Long idTorneo);

    Torneo buscarTorneoPorID(Long idTorneo);

    List<PartidoTorneo> buscarLosPartidosDeUnTorneo(Torneo torneo);
}
