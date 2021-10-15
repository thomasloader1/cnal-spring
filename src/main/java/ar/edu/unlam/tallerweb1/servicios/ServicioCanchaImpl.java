package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Cancha;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCancha;
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


    @Override
    public Boolean canchaConFiltro(Cancha cancha) {
        try{
            if(cancha.getLocalidad() != null){
                return true;
            }
            return false;
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<Cancha> filtrarCanchasPorLocalidad(String localidad) {
        return repositorioCanchaImpl.buscarCanchaPorLocalidad(localidad);

    }

    @Override
    public Cancha registrarCancha(Cancha cancha) throws Exception {
        Cancha canchaBuscada = repositorioCanchaImpl.buscarCancha(cancha.getNombre(),cancha.getDomicilio());
        if(canchaBuscada != null)
            throw new Exception();
        repositorioCanchaImpl.guardarCancha(cancha);
        return cancha;
    }
}
