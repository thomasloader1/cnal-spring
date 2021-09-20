package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.repositorios.RepositorioPartido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("servicioCrearPartido")
@Transactional
public class ServicioCrearPartidoImpl implements ServicioCrearPartido {

    private final RepositorioPartido repositorioPartidoImpl;

    @Autowired
    public ServicioCrearPartidoImpl(RepositorioPartido servicioCrearPartidoDao){

        this.repositorioPartidoImpl = servicioCrearPartidoDao;
    }


}