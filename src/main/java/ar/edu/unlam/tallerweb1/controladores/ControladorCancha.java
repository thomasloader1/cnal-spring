package ar.edu.unlam.tallerweb1.controladores;


import ar.edu.unlam.tallerweb1.modelo.Cancha;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioCancha;
import ar.edu.unlam.tallerweb1.servicios.ServicioLocalidad;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

@Controller
public class ControladorCancha {

    private ServicioCancha servicioCancha;
    private ServicioLocalidad servicioLocalidad;
    private ServicioUsuario servicioUsuario;

    @Autowired
    public ControladorCancha(ServicioCancha servicioCrearCancha, ServicioLocalidad servicioLocalidad, ServicioUsuario servicioUsuario) {
        this.servicioCancha = servicioCrearCancha;
        this.servicioLocalidad = servicioLocalidad;
        this.servicioUsuario = servicioUsuario;
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
    public ModelAndView registrarCancha(HttpServletRequest request,@ModelAttribute("cancha-nueva") DatosCrearCancha datosCancha) {
        ModelMap model = new ModelMap();
        model.put("cancha",datosCancha);
        try{
            Long idUsuario = (Long) request.getSession().getAttribute("ID");

            servicioCancha.registrarCancha(datosCancha.crearCancha(),idUsuario);
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

    @RequestMapping(path = "lista-canchas-admin", method = RequestMethod.GET)
    public ModelAndView listarCanchasPorAdmin(HttpServletRequest request){
        Long idUsuario = (Long) request.getSession().getAttribute("ID");
        Usuario usuario = servicioUsuario.buscarUsuarioPorId(idUsuario);
        ModelMap model = new ModelMap();
        model.put("CANCHA", servicioCancha.todasLasCanchasPorAdmin(usuario));
        return new ModelAndView("lista-canchas-admin", model);
    }
}
