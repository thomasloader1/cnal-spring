package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.*;

import java.util.Date;
import java.util.List;

public interface RepositorioPartido {

    Partido buscarPartido(String hora, String categoria) throws Exception;
    void guardarPartido(Partido partido);
    void actualizar(Partido partido);
    List<Partido> todosLosPartidos();
    List<Partido> partidosFiltrados(String localidad, String categoria);
    Partido buscarPartidoPorID(Long id);
    void registrarUsuarioAPartido(UsuarioPartido registro);
    UsuarioPartido buscarUsuarioPartido(Long idUsuario, Long idPartido);
    List<Partido> todosLosPartidosPorUsuario(Long idUsuario);
    List<Partido> buscarPartidosPorCancha(Cancha cancha);
    List<Partido> buscarPartidosPorFechaYHora(String fechaPartido, String horarioPartido);
    void cargarReserva(Compra compra);
}
