package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioCrearPartido {
    Partido registrar(Partido partido) throws Exception;
    Partido consultarPartido(String hora, String categoria) throws Exception;

}
