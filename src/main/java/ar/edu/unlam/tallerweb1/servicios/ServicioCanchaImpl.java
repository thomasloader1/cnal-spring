package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Cancha;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCancha;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("servicioCrearCancha")
@Transactional
public class ServicioCanchaImpl implements ServicioCancha{

    private RepositorioCancha repositorioCanchaImpl;

    private RepositorioUsuario repositorioUsuarioImpl;

    @Autowired
    public ServicioCanchaImpl(RepositorioCancha repositorioCancha, RepositorioUsuario repositorioUsuario) {
        this.repositorioCanchaImpl = repositorioCancha;
        this.repositorioUsuarioImpl = repositorioUsuario;
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
    public Cancha registrarCancha(Cancha cancha, Long id) throws Exception {
        Cancha canchaBuscada = repositorioCanchaImpl.buscarCancha(cancha.getNombre(),cancha.getDomicilio());
        if(canchaBuscada != null)
            throw new Exception();
        Usuario usuario = repositorioUsuarioImpl.buscarUsuarioPorId(id);
        cancha.setUsuario(usuario);
        repositorioCanchaImpl.guardarCancha(cancha);
        return cancha;
    }

    @Override
    public List<Cancha> todasLasCanchasPorAdmin(Usuario usuario) {
        return repositorioCanchaImpl.todasLasCanchasPorAdmin(usuario);
    }

    @Override
    public Cancha buscarCanchaPorId(Long id) {
        return repositorioCanchaImpl.buscarCanchaPorId(id);
    }

    @Override
    public void modificarDatosCancha(Cancha cancha) {
        repositorioCanchaImpl.modificarDatosCancha(cancha);
    }
}
