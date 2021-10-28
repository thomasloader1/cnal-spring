package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosEquipo;
import ar.edu.unlam.tallerweb1.modelo.Equipo;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioEquipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("sevicioEquipo")
@Transactional
public class ServicioEquipoImpl implements ServicioEquipo{

    private RepositorioEquipo repositorioEquipo;

    @Autowired
    public ServicioEquipoImpl(RepositorioEquipo repositorioEquipo) {

        this.repositorioEquipo = repositorioEquipo;
    }

    @Override
    public Equipo registrarEquipo(Equipo equipo) {
        repositorioEquipo.guardarEquipo(equipo);
        return equipo;
    }



    @Override
    public Boolean registrarEnEquipo(Long iDEquipo, Long idUsuario) throws Exception {
        Boolean registroExitoso = false;

        Equipo equipoBuscado = repositorioEquipo.buscarEquipo(iDEquipo);

        if(equipoBuscado==null)
            throw new Exception();

        if(hayLugaresDisponibles(equipoBuscado)){

            Usuario jugadorBuscado = repositorioEquipo.buscarJugador(idUsuario);
            if(jugadorBuscado.getEquipo()==null){
                unirJugadorAlEquipoElegido(equipoBuscado, jugadorBuscado);
            }
            else{
                Equipo equipoAnterior = jugadorBuscado.getEquipo();

                unirJugadorAlEquipoElegido(equipoBuscado, jugadorBuscado);

                equipoAnterior.setCantidadJugadores(repositorioEquipo.buscarJugadoresDeUnEquipo(equipoAnterior).size());
            }
            registroExitoso = true;
        }

        return registroExitoso;
    }


    @Override
    public List<Equipo> buscarTodosLosEquipos() {
        return repositorioEquipo.traerListaDeEquipos();
    }

    @Override
    public List<Equipo> filtrarEquipos(Integer tipo) {
        return repositorioEquipo.equiposFiltrados(tipo);
    }


    public boolean hayLugaresDisponibles(Equipo equipo){
        boolean hayLugar = false;
        int tipoPartido = equipo.getTipoPartido();
        List<Usuario> jugadoresDelEquipo = repositorioEquipo.buscarJugadoresDeUnEquipo(equipo);


        if(jugadoresDelEquipo.size()<tipoPartido){
            hayLugar = true;
        }
        return hayLugar;
    }


    public void unirJugadorAlEquipoElegido(Equipo equipo, Usuario jugador){
        jugador.setEquipo(equipo);

        repositorioEquipo.actualizarEquipo(equipo);
        equipo.setCantidadJugadores(repositorioEquipo.buscarJugadoresDeUnEquipo(equipo).size());
    }

}
