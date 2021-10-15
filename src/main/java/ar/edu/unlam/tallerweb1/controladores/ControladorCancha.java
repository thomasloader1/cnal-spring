package ar.edu.unlam.tallerweb1.controladores;


import ar.edu.unlam.tallerweb1.modelo.Cancha;
import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.servicios.ServicioCancha;
import ar.edu.unlam.tallerweb1.servicios.ServicioPartido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;

@Controller
public class ControladorCancha {

    private ServicioCancha servicioCancha;

    @Autowired
    public ControladorCancha(ServicioCancha servicioCrearCancha) {
        this.servicioCancha = servicioCrearCancha;
    }

    //TODO crear metodo para mostrar la lista de canchas y mostrar en la pantalla que corresponda

    @RequestMapping(path = "/buscar-cancha", method = RequestMethod.GET)
    public ModelAndView irABuscarCancha(){
        ModelMap model = listarCanchaMethod();
        return new  ModelAndView("buscar-cancha",model);
    }

    private ModelMap listarCanchaMethod(){
        ModelMap model = new ModelMap();
        model.put("CANCHA",servicioCancha.todasLasCanchas());

        List<Cancha> listCanchas = new LinkedList<>();

        for (Cancha canchas : listCanchas){
            model.put("localidad",canchas.getLocalidad());
            model.put("nombre", canchas.getNombre());
        }
        return model;
    }
    @RequestMapping(path = "/registro-cancha", method = RequestMethod.GET)
    public ModelAndView irARegistroCancha(){
        return new ModelAndView("registro-cancha");
    }

    @RequestMapping(method = RequestMethod.POST , path = "/registrar-cancha")
    public ModelAndView registrarCancha(@ModelAttribute("cancha-nueva") DatosCrearCancha datosCancha) {
        ModelMap model = new ModelMap();
        ModelAndView modeloVista = null;
            model.put("msg", "La cancha se creo con éxito");
            //Se muestra en la vista de éxito estos dos datos:
            model.put("nombre",datosCancha.getNombre());
            model.put("localidad",datosCancha.getLocalidad());
            model.put("domicilio",datosCancha.getDomicilio());

            Cancha cancha = new Cancha(5L, datosCancha.getNombre(), datosCancha.getLocalidad(),datosCancha.getDomicilio());
            servicioCancha.registrar(cancha);
            modeloVista = new ModelAndView("cancha-registrada", model);
            return modeloVista;
    }
}
