package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Equipo;
import ar.edu.unlam.tallerweb1.modelo.Torneo;

import java.util.List;

public interface RepositorioTorneo {

    public List<Torneo> todosLosTorneos();

    Torneo buscarTorneo(Torneo torneo);

    void guardarTorneo(Torneo torneo);

    List<Equipo> buscarEquiposDeUnTorneo(Torneo torneo);
}
