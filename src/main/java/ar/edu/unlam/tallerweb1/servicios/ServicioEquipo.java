package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosEquipo;
import ar.edu.unlam.tallerweb1.modelo.Equipo;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.List;

public interface ServicioEquipo {

    Boolean registrarEnEquipo(Long iDEquipo, Usuario usuario) throws Exception;

    Equipo registrarEquipo(Equipo equipo);

    List<Equipo> buscarTodosLosEquipos();
}
