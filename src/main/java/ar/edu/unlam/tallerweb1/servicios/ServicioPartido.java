package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosCrearPartido;
import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.List;

public interface ServicioPartido {
    Partido registrar(Partido partido) ;
    Partido consultarPartido(String hora, String categoria) throws Exception;
    void unirmeAlPartido(Partido partido);
    Boolean partidoLleno(Partido partido);

    List<Partido> todosLosPartidos();
<<<<<<< HEAD
    Boolean partidoConFiltros(Partido partido);
    List<Partido> filtrarPartidos(String localidad, String categoria);
=======

>>>>>>> fc1b273d7db66cecad1c23952ec42a14f067a0d1
}
