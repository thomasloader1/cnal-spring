package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Equipo;
import ar.edu.unlam.tallerweb1.modelo.PartidoTorneo;
import ar.edu.unlam.tallerweb1.modelo.Torneo;

import java.util.List;

public interface RepositorioTorneo {

    public List<Torneo> todosLosTorneos();

    Torneo buscarTorneo(Torneo torneo);

    Object buscarTorneoPorId(Long idTorneo);

    void actualizarTorneo(Torneo torneo);

    void guardarTorneo(Torneo torneo);

    List<Equipo> buscarEquiposDeUnTorneo(Long idTorneo);

    void actualizarPartidoTorneo(PartidoTorneo partido);

    void guardarPartidoTorneo(PartidoTorneo partido);

    List<PartidoTorneo> buscarLosPartidosDeUnTorneo(Torneo torneo);

    Torneo buscarTorneoPorID(Long idTorneo);
}
