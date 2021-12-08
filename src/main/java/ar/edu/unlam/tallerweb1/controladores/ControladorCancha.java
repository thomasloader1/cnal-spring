package ar.edu.unlam.tallerweb1.controladores;


import ar.edu.unlam.tallerweb1.modelo.Cancha;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioCancha;
import ar.edu.unlam.tallerweb1.servicios.ServicioLocalidad;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

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
        return new ModelAndView("cancha/buscar-cancha", model);
    }

    private ModelMap listarCanchaYLocalidadMethod() {
        ModelMap model = new ModelMap();
        model.put("CANCHA", servicioCancha.todasLasCanchas());
        model.put("LOCALIDAD", servicioLocalidad.todasLasLocalidades());
        return model;
    }

    @RequestMapping(path = "/registro-cancha", method = RequestMethod.GET)
    public ModelAndView irARegistroCancha() {
        return new ModelAndView("cancha/registro-cancha");
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
            return new ModelAndView("cancha/registro-cancha", model);
        }

        return new ModelAndView("cancha/cancha-registrada", model);
    }

    @RequestMapping(path = "listar-canchas-filtradas", method = RequestMethod.GET)
    public ModelAndView listarCanchasFiltradas(@RequestParam("localidad") String localidad) {
        ModelMap model = new ModelMap();
        model.put("CANCHA", servicioCancha.filtrarCanchasPorLocalidad(localidad));
        model.put("LOCALIDAD" , servicioLocalidad.todasLasLocalidades());
        return new ModelAndView("cancha/buscar-cancha", model);
    }

    @RequestMapping(path = "lista-canchas-admin", method = RequestMethod.GET)
    public ModelAndView listarCanchasPorAdmin(HttpServletRequest request){
        Long idUsuario = (Long) request.getSession().getAttribute("ID");
        Usuario usuario = servicioUsuario.buscarUsuarioPorId(idUsuario);
        ModelMap model = new ModelMap();
        model.put("CANCHA", servicioCancha.todasLasCanchasPorAdmin(usuario));
        return new ModelAndView("admin/lista-canchas-admin", model);
    }

    @RequestMapping(path = "ir-a-modificar-datos-cancha/{id}", method = RequestMethod.GET)
    public ModelAndView irAModificarDatosCancha(@PathVariable Long id) {

        Cancha cancha = servicioCancha.buscarCanchaPorId(id);
        ModelMap model = new ModelMap();
        model.put("CANCHA", cancha);
        return new ModelAndView("cancha/modificar-cancha", model);
    }

    @RequestMapping(path = "modificar-datos-cancha/{id}", method = RequestMethod.GET)
    public ModelAndView modificarDatosCancha(HttpServletRequest request,@ModelAttribute("modificar-cancha") DatosCrearCancha datosCancha,@PathVariable Long id) {

        Long idUsuario = (Long) request.getSession().getAttribute("ID");

        Cancha cancha = servicioCancha.buscarCanchaPorId(id);

        Usuario usuario = servicioUsuario.buscarUsuarioPorId(idUsuario);

        cancha.setUsuario(usuario);
        cancha.setNombre(datosCancha.getNombre());
        cancha.setLocalidad(datosCancha.getLocalidad());
        cancha.setDomicilio(datosCancha.getDomicilio());
        cancha.setPrecio(datosCancha.getPrecio());
        cancha.setBar(datosCancha.getBar());
        cancha.setCant_canchas(datosCancha.getCant_canchas());

        servicioCancha.modificarDatosCancha(cancha);

        return new ModelAndView("cancha/modificacion-cancha-exitosa");
    }


    @RequestMapping(path = "reservar-cancha/{id}", method = RequestMethod.POST)
    public ModelAndView reservarCancha(@PathVariable Long id){

        Cancha cancha = servicioCancha.buscarCanchaPorId(id);

        ModelMap model = new ModelMap();
        String respuesta;

        if(cancha.getBar() == true){
            respuesta = "Si";
        }else{
            respuesta = "No";
        }

        model.put("CANCHA", cancha);
        model.put("RESPUESTA", respuesta);

        return  new ModelAndView("cancha/detalles-cancha", model);
    }
}
