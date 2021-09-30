package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.servicios.ServicioCrearPartido;
import org.springframework.beans.factory.annotation.Autowired;


public class ControladorPartido {
    private ServicioCrearPartido servicioCrearPartido;

    @Autowired
    public ControladorPartido(ServicioCrearPartido servicioCrearPartido) {
        this.servicioCrearPartido = servicioCrearPartido;
    }



    //@RequestMapping(method = RequestMethod.POST, path = "/registrar-partido")
    public Boolean registrarPartido(Partido partido) {
        return true;
    }

    public void validarDatos(Partido datosPartido) {
    }



    public Boolean veficarCantidadDeJugadores(int cant_jugadores) {
        if(cant_jugadores < 10){
            return true;
        }

        return false;
    }
}
