package ar.edu.unlam.tallerweb1.controladores;


import ar.edu.unlam.tallerweb1.modelo.Cancha;
import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.servicios.ServicioCancha;
import ar.edu.unlam.tallerweb1.servicios.ServicioPartido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;

@Controller
public class ControladorCancha {

    private ServicioCancha servicioCrearCancha;

    @Autowired
    public ControladorCancha(ServicioCancha servicioCrearCancha) {
        this.servicioCrearCancha = servicioCrearCancha;
    }

    //TODO crear metodo para mostrar la lista de canchas y mostrar en la pantalla que corresponda

    @RequestMapping(path = "/buscar-cancha", method = RequestMethod.GET)
    public ModelAndView irABuscarCancha(){
        ModelMap model = listarCanchaMethod();
        return new  ModelAndView("buscar-cancha",model);
    }

    private ModelMap listarCanchaMethod(){
        ModelMap model = new ModelMap();
        model.put("CANCHA",servicioCrearCancha.todasLasCanchas());

        List<Cancha> listCanchas = new LinkedList<>();

        for (Cancha canchas : listCanchas){
            model.put("localidad",canchas.getLocalidad());
            model.put("nombre", canchas.getNombre());
        }
        return model;
    }

}
