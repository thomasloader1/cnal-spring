package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Cancha;
import ar.edu.unlam.tallerweb1.modelo.Localidad;
import ar.edu.unlam.tallerweb1.servicios.ServicioCancha;
import ar.edu.unlam.tallerweb1.servicios.ServicioLocalidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;

@Controller
public class ControladorLocalidad {

    private ServicioLocalidad servicioLocalidad;

    @Autowired
    public ControladorLocalidad(ServicioLocalidad servicioLocalidad) {this.servicioLocalidad = servicioLocalidad;}

    /*@RequestMapping
    public ModelMap irABuscarLocalidad(){
        ModelMap model = new ModelMap();
        model.put("LOCALIDAD",servicioLocalidad.todasLasLocalidades());
        return model;
    }*/
}
