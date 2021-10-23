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
    public Boolean registrarEnEquipo(String nombreEquipo) throws Exception {
        Boolean registroExitoso = false;

        Equipo equipoBuscado = repositorioEquipo.buscarEquipo(nombreEquipo);

        if(equipoBuscado!= null && equipoBuscado.getCantidadJugadores()<11){

            Usuario nuevoUsuario = new Usuario();
            nuevoUsuario.setEmail("scortes@email.com");
            nuevoUsuario.setPassword("123");
            nuevoUsuario.setRol("Jugador");

            equipoBuscado.setJugadores(nuevoUsuario);
            repositorioEquipo.actualizarEquipo(equipoBuscado); //esto haría un update del equipo con el nuevo jugador agregado

            registroExitoso = true;
        }
        else{
            throw new Exception();
        }

        return registroExitoso;
    }
}
