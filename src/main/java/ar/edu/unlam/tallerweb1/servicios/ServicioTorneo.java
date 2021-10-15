package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Torneo;

import java.util.List;

public interface ServicioTorneo {
    List<Torneo> todosLosTorneos();

    Torneo buscarTorneo(Torneo torneo) throws Exception;
}
