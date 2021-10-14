package ar.edu.unlam.tallerweb1.controladores;


import ar.edu.unlam.tallerweb1.servicios.ServicioCancha;
import ar.edu.unlam.tallerweb1.servicios.ServicioPartido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ControladorCancha {

    private ServicioCancha servicioCrearCancha;

    @Autowired
    public ControladorCancha(ServicioCancha servicioCrearCancha) {
        this.servicioCrearCancha = servicioCrearCancha;
    }

    //TODO crear metodo para mostrar la lista de canchas y mostrar en la pantalla que corresponda
}
