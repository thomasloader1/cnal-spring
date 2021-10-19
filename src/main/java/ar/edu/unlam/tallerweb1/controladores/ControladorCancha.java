package ar.edu.unlam.tallerweb1.controladores;


import ar.edu.unlam.tallerweb1.servicios.ServicioCancha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorCancha {

    private ServicioCancha servicioCancha;

    @Autowired
    public ControladorCancha(ServicioCancha servicioCrearCancha) {
        this.servicioCancha = servicioCrearCancha;
    }

    //TODO crear metodo para mostrar la lista de canchas y mostrar en la pantalla que corresponda

    @RequestMapping(path = "/buscar-cancha", method = RequestMethod.GET)
    public ModelAndView irABuscarCancha() {
        ModelMap model = listarCanchaMethod();
        return new ModelAndView("buscar-cancha", model);
    }

    private ModelMap listarCanchaMethod() {
        ModelMap model = new ModelMap();
        model.put("CANCHA", servicioCancha.todasLasCanchas());
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
}
