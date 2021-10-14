package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Cancha;

import java.util.List;

public interface RepositorioCancha {

    List<Cancha> todasLasCanchas();

    List<Cancha> buscarCanchaPorLocalidad(String localidad);
}
