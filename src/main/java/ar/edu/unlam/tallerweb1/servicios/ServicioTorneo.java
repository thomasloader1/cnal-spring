package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosTorneo;
import ar.edu.unlam.tallerweb1.modelo.PartidoTorneo;
import ar.edu.unlam.tallerweb1.modelo.Torneo;

import java.util.List;

public interface ServicioTorneo {
    List<Torneo> todosLosTorneos();

    Torneo buscarTorneo(Torneo torneo) throws Exception;

    void registrarTorneo(Torneo crearTorneo) throws ExceptionYaExiste;

    List<PartidoTorneo> generarCruceDeEquiposDeUnTorneo(Torneo torneo);

    Boolean registrarEnTorneo(Long idTorneo, Long idUsuario) throws Exception;
}
