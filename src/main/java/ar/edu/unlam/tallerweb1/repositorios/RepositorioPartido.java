package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Partido;

public interface RepositorioPartido {

    Partido buscar(String hora, String categoria) throws Exception;
    void guardar(Partido partido);
}
