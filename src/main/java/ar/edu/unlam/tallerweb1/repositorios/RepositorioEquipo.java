package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Equipo;

public interface RepositorioEquipo {

    Equipo buscarEquipo(String nombreEquipo);


    void actualizarEquipo(Equipo equipoBuscado);

    void guardarEquipo(Equipo equipo);
}
