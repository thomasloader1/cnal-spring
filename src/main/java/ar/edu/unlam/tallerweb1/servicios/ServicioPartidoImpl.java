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
    public Partido registrarPartido(Partido partido)  {
        String tipo= partido.getTipo();
        Integer jugadores = Integer.parseInt(tipo);
        Integer jugadores_totales = jugadores * 2;
        Integer lugares= 0;
        if (partido.getCant_jugadores() < jugadores_totales){
            lugares= jugadores_totales - partido.getCant_jugadores();
        }
        repositorioPartidoImpl.guardarPartido(partido);
        return partido;
    }

    @Override
    public Partido consultarPartido(String hora, String categoria) throws Exception {
        Partido buscado = repositorioPartidoImpl.buscarPartido(hora, categoria);
        if (buscado != null){
            throw new Exception();
    }
        return buscado;
    }

    @Override
    public void unirmeAlPartido(Partido partido) {
        Partido partidoActualizado = repositorioPartidoImpl.buscarPartidoPorID(partido.getId());
        String tipo= partidoActualizado.getTipo();
        Integer jugadores = Integer.parseInt(tipo);
        Integer jugadores_totales = jugadores * 2;

        if (partidoActualizado.getCant_jugadores() < jugadores_totales){
            partidoActualizado.setCant_jugadores(partido.getCant_jugadores() + 1);
            partidoActualizado.setCant_lugaresDisp(partido.getCant_lugaresDisp() - 1);
        }
        repositorioPartidoImpl.actualizar(partidoActualizado);
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
        return repositorioPartidoImpl.todosLosPartidos();
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

    @Override
    public Partido buscarPartidoPorID(Long id) {
        Partido partidoPorID = repositorioPartidoImpl.buscarPartidoPorID(id);
        return partidoPorID;
    }

    @Override
    public void vincularJugadorAPartido(Long idUsuario, Long idPartido){
        //repositorioPartidoImpl.registrarUsuarioAPartido(UsuarioPartido);
    }

}