package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosEquipo;
import ar.edu.unlam.tallerweb1.modelo.Equipo;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioEquipo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ServicioEquipoImpl implements ServicioEquipo{

    private RepositorioEquipo repositorioEquipo;

    @Autowired
    public ServicioEquipoImpl(RepositorioEquipo repositorioEquipo) {
        this.repositorioEquipo = repositorioEquipo;
    }

    @Override
    public Boolean registrarEnEquipo(String nombreEquipo, Usuario usuario) throws Exception {
        Boolean registroExitoso = false;

        Equipo equipoBuscado = repositorioEquipo.buscarEquipo(nombreEquipo);

        if(equipoBuscado!= null && hayLugaresDisponibles(equipoBuscado)){
            equipoBuscado.setJugadores(usuario);
            repositorioEquipo.actualizarEquipo(equipoBuscado); //esto haría un update del equipo con el nuevo jugador agregado

            registroExitoso = true;


        }
        else{
            throw new Exception();
        }

        return registroExitoso;
    }


    public boolean hayLugaresDisponibles(Equipo equipo){
        boolean hayLugar = false;

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
