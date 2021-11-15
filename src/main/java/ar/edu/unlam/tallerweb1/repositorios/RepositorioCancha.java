package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Cancha;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.List;

public interface RepositorioCancha {

    List<Cancha> todasLasCanchas();

    List<Cancha> buscarCanchaPorLocalidad(String localidad);

    void guardarCancha(Cancha nuevo);

    Cancha buscarCancha(String nombre, String domicilio);

    List<Cancha> todasLasCanchasPorAdmin(Usuario usuario);

    Cancha buscarCanchaPorId(Long id);
}
