package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Partido;

public interface RepositorioPartido {

    void crearPartido(Partido partido);
    void buscarPartido(Long id, String tipo);
}
