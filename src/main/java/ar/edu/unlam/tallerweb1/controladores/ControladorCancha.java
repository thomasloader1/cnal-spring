package ar.edu.unlam.tallerweb1.controladores;


import ar.edu.unlam.tallerweb1.modelo.Cancha;
import ar.edu.unlam.tallerweb1.servicios.ServicioCancha;
import ar.edu.unlam.tallerweb1.servicios.ServicioLocalidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;

@Controller
public class ControladorCancha {

    private ServicioCancha servicioCancha;
    private ServicioLocalidad servicioLocalidad;

    @Autowired
    public ControladorCancha(ServicioCancha servicioCrearCancha, ServicioLocalidad servicioLocalidad) {
        this.servicioCancha = servicioCrearCancha;
        this.servicioLocalidad = servicioLocalidad;
    }

    @RequestMapping(path = "/buscar-cancha", method = RequestMethod.GET)
    public ModelAndView irABuscarCancha() {
        ModelMap model = listarCanchaYLocalidadMethod();
        return new ModelAndView("buscar-cancha", model);
    }

    private ModelMap listarCanchaYLocalidadMethod() {
        ModelMap model = new ModelMap();
        model.put("CANCHA", servicioCancha.todasLasCanchas());
        model.put("LOCALIDAD", servicioLocalidad.todasLasLocalidades());
        return model;
    }

    @RequestMapping(path = "/registro-cancha", method = RequestMethod.GET)
    public ModelAndView irARegistroCancha() {
        return new ModelAndView("registro-cancha");
    }

    @RequestMapping(method = RequestMethod.POST, path = "/registrar-cancha")
    public ModelAndView registrarCancha(@ModelAttribute("cancha-nueva") DatosCrearCancha datosCancha) {
        ModelMap model = new ModelMap();
        model.put("cancha",datosCancha);
        try{
            servicioCancha.registrarCancha(datosCancha.crearCancha());
        }
        catch (Exception e){
            model.put("msg","La cancha ya existe");
            return new ModelAndView("registro-cancha", model);
        }

        return new ModelAndView("cancha-registrada", model);
    }

    @RequestMapping(path = "listar-canchas-filtradas", method = RequestMethod.GET)
    public ModelAndView listarCanchasFiltradas(@RequestParam("localidad") String localidad) {
        ModelMap model = new ModelMap();
        model.put("CANCHA", servicioCancha.filtrarCanchasPorLocalidad(localidad));
        model.put("LOCALIDAD" , servicioLocalidad.todasLasLocalidades());
        return new ModelAndView("buscar-cancha", model);
    }
}
