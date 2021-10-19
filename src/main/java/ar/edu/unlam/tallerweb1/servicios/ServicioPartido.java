package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosCrearPartido;
import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.List;

public interface ServicioPartido {
    Partido registrarPartido(Partido partido) ;
    Partido consultarPartido(String hora, String categoria) throws Exception;
    void unirmeAlPartido(Partido partido);
    Boolean partidoLleno(Partido partido);
    List<Partido> todosLosPartidos();
    Boolean partidoConFiltros(Partido partido);
    List<Partido> filtrarPartidos(String localidad, String categoria);
    Partido buscarPartidoPorID(Long id);
    void vincularJugadorAPartido(Long idUsuario, Long idPartido);

}
