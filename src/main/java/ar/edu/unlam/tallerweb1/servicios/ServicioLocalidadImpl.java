package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Localidad;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCancha;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioLocalidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("servicioCrearLocalidad")
@Transactional
public class ServicioLocalidadImpl implements ServicioLocalidad{

    private RepositorioLocalidad repositorioLocalidadImpl;

    @Autowired
    public ServicioLocalidadImpl(RepositorioLocalidad repositorioLocalidad){
        this.repositorioLocalidadImpl = repositorioLocalidad;
    }

    @Override
    public List<Localidad> todasLasLocalidades() {
        return repositorioLocalidadImpl.todasLasLocalidades();
    }

}
