package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Cancha;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.List;

public interface ServicioCancha {

    List<Cancha> todasLasCanchas();

    Boolean canchaConFiltro(Cancha cancha);

    List<Cancha> filtrarCanchasPorLocalidad(String localidad);

    Cancha registrarCancha(Cancha cancha, Long id) throws Exception;

    List<Cancha> todasLasCanchasPorAdmin(Usuario usuario);

    Cancha buscarCanchaPorId(Long id);
}
