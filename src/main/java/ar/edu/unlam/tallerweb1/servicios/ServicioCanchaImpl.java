package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Cancha;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCancha;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPartido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("servicioCrearCancha")
@Transactional
public class ServicioCanchaImpl implements ServicioCancha{

    private RepositorioCancha repositorioCanchaImpl;

    @Autowired
    public ServicioCanchaImpl(RepositorioCancha repositorioCancha) {
        this.repositorioCanchaImpl = repositorioCancha;
    }

    @Override
    public List<Cancha> todasLasCanchas() {
        return repositorioCanchaImpl.todasLasCanchas();
    }
}
