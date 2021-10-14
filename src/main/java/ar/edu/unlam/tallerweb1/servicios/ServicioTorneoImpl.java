package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Torneo;

import ar.edu.unlam.tallerweb1.repositorios.RepositorioTorneo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("servicioTorneo")
@Transactional
public class ServicioTorneoImpl implements ServicioTorneo{

    private RepositorioTorneo repositorioTorneoImpl;

    @Autowired
    public ServicioTorneoImpl(RepositorioTorneo repositorioTorneo) {
        this.repositorioTorneoImpl = repositorioTorneo;
    }

    @Override
    public List<Torneo> todosLosTorneos() {
        return repositorioTorneoImpl.todosLosTorneos();
    }

    @Override
    public Torneo buscarTorneo(Torneo torneo) {
        return repositorioTorneoImpl.buscarTorneo(torneo);
    }
}
