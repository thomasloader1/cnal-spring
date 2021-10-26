package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Equipo;

import java.util.List;

public interface RepositorioEquipo {

    Equipo buscarEquipo(Long iDEquipo);


    void actualizarEquipo(Equipo equipoBuscado);

    void guardarEquipo(Equipo equipo);

    List<Equipo> traerListaDeEquipos();
}
