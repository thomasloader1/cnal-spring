package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Torneo;

import java.util.List;

public interface RepositorioTorneo {

    public List<Torneo> todosLosTorneos();

    Torneo buscarTorneo(Torneo torneo);
}
