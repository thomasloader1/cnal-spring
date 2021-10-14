package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Cancha;

import java.util.List;

public interface ServicioCancha {

    List<Cancha> todasLasCanchas();

    Boolean canchaConFiltro(Cancha cancha);

    List<Cancha> filtrarCanchasPorLocalidad(String localidad);
}
