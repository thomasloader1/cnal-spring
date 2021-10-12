package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPartido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("servicioCrearPartido")
@Transactional
public class ServicioPartidoImpl implements ServicioPartido {

    private RepositorioPartido repositorioPartidoImpl;

    @Autowired
    public ServicioPartidoImpl(RepositorioPartido repositorioPartido) {
        this.repositorioPartidoImpl = repositorioPartido;
    }

    @Override
    public Partido registrar(Partido partido)  {
        Partido nuevo = new Partido(partido.getId(),partido.getCant_jugadores(),partido.getTipo(),partido.getCategoria(),partido.getHorario(),partido.getLocalidad());
        repositorioPartidoImpl.guardar(nuevo);
        return nuevo;
    }

    @Override
    public Partido consultarPartido(String hora, String categoria) throws Exception {
        Partido buscado = repositorioPartidoImpl.buscar(hora, categoria);
        if (buscado != null){
            throw new Exception();
    }
        return buscado;
    }

    @Override
    public void unirmeAlPartido(Partido partido){
        repositorioPartidoImpl.unirmeAlPartido(partido);
    }
    @Override
    public Boolean partidoLleno(Partido partido){
        boolean esValido = false;
        if(partido.getTipo().equals("5") && (partido.getCant_jugadores()>=1 && partido.getCant_jugadores()<=10)){
            esValido = true;
        }else if(partido.getTipo().equals("11") && (partido.getCant_jugadores()>=1 && partido.getCant_jugadores()<=22)){
            esValido = true;
        }
        return esValido;
    }

    @Override
    public List<Partido> todosLosPartidos() {
        return repositorioPartidoImpl.partidos();
    }

    @Override
    public Boolean partidoConFiltros(Partido partido){

        try{
            if(partido.getLocalidad() != null && partido.getCategoria() != null){
                return true;
            }
            return false;
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<Partido> filtrarPartidos(String localidad, String categoria){
            return repositorioPartidoImpl.partidosFiltrados(localidad,categoria);
        }

}