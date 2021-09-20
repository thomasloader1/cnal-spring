package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.servicios.ServicioCrearPartido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
