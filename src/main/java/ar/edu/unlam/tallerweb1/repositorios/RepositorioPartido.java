package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
//import ar.edu.unlam.tallerweb1.modelo.UsuarioPartido;

import java.util.*;

public interface RepositorioPartido {

    Partido buscarPartido(String hora, String categoria) throws Exception;
    void guardarPartido(Partido partido);
    void actualizar(Partido partido);
    List<Partido> todosLosPartidos();
    List<Partido> partidosFiltrados(String localidad, String categoria);
    Partido buscarPartidoPorID(Long id);
   // void registrarUsuarioAPartido(UsuarioPartido registro);
   // UsuarioPartido buscarUsuarioPartido(Long idUsuario, Long idPartido);
    Set<Partido> todosLosPartidosPorUsuario(Long idUsuario);
}
