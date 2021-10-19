package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Partido;

import java.util.List;

public interface RepositorioPartido {

    Partido buscarPartido(String hora, String categoria) throws Exception;
    void guardarPartido(Partido partido);
    void actualizar(Partido partido);
    List<Partido> todosLosPartidos();
    List<Partido> partidosFiltrados(String localidad, String categoria);
    Partido buscarPartidoPorID(Long id);
    //void registrarUsuarioAPartido(UsuarioPartido usuarioPartido);
}
