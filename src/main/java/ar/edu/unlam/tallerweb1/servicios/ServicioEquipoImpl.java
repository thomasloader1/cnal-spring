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
    public Boolean registrarEnEquipo(Long iDEquipo, Usuario usuario) throws Exception {
        Boolean registroExitoso = false;

        Equipo equipoBuscado = repositorioEquipo.buscarEquipo(iDEquipo);
        int cantJugadoresActuales = equipoBuscado.getCantidadJugadores();

        if(equipoBuscado==null)
            throw new Exception();

        if(equipoBuscado!= null && hayLugaresDisponibles(equipoBuscado)){

            equipoBuscado.setCantidadJugadores(cantJugadoresActuales + 1);

            //equipoBuscado.setJugadores(usuario);
            repositorioEquipo.actualizarEquipo(equipoBuscado);

            registroExitoso = true;

        }

        return registroExitoso;
    }

    @Override
    public Equipo registrarEquipo(Equipo equipo) {
        repositorioEquipo.guardarEquipo(equipo);
        return equipo;
    }

    @Override
    public List<Equipo> buscarTodosLosEquipos() {
        return repositorioEquipo.traerListaDeEquipos();
    }


    public boolean hayLugaresDisponibles(Equipo equipo){
        boolean hayLugar = false; // repositorioEquipo.getEquipoHabilitado(EQUIPO)

        if(equipo.getTipoPartido()==5 && equipo.getCantidadJugadores()<5){
            hayLugar = true;
        }
        else if(equipo.getTipoPartido()==11 && equipo.getCantidadJugadores()<11){
            hayLugar = true;
        }
        else{
            equipo.setHabilitado(true); //ya esta completo y habilitado para jugar en un partido ese equipo
        }
        return hayLugar;
    }

}
