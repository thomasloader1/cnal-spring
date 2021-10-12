package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Partido;

import java.util.List;

public interface RepositorioPartido {

    Partido buscar(String hora, String categoria) throws Exception;
    void guardar(Partido partido);
    void unirmeAlPartido(Partido partido);
    List<Partido> partidos();
<<<<<<< HEAD
    List<Partido> partidosFiltrados(String localidad, String categoria);
=======

>>>>>>> fc1b273d7db66cecad1c23952ec42a14f067a0d1
}
