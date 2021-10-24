package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosEquipo;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioEquipo {

    Boolean registrarEnEquipo(String nombreEquipo, Usuario usuario) throws Exception;

}
