package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.servicios.ServicioPartido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ControladorPartido {

    private ServicioPartido servicioCrearPartido;

    @Autowired
    public ControladorPartido(ServicioPartido servicioCrearPartido) {
        this.servicioCrearPartido = servicioCrearPartido;
    }

    @RequestMapping(path = "/registro-partido", method = RequestMethod.GET)
    public ModelAndView irARegistroPartido() {
        return new ModelAndView("registro-partido");
    }

    @RequestMapping(method = RequestMethod.POST, path = "/registrar-partido")
    public ModelAndView registrarPartido(@ModelAttribute("partido-nuevo") DatosCrearPartido datosPartido) {
        ModelMap model = new ModelMap();
        ModelAndView modeloVista = null;
        if (datosPartido.losDatosIngresadosSonValidos(datosPartido).equals("exito")) {
            model.put("msg", "El partido se creo con éxito");
            model.put("partido", datosPartido);
            servicioCrearPartido.registrarPartido(datosPartido.crearPartido());
            modeloVista = new ModelAndView("partido-registrado", model);
        } else {
            model.put("msg", datosPartido.losDatosIngresadosSonValidos(datosPartido));
            modeloVista = new ModelAndView("registro-partido", model);
        }
        return modeloVista;
    }

    @RequestMapping(path = "listar-partidos", method = RequestMethod.GET)
    public ModelAndView listarPartidos() {
        ModelMap model = new ModelMap();
        model.put("PARTIDOS", servicioCrearPartido.todosLosPartidos());
        return new ModelAndView("home", model);
    }

    @RequestMapping(path = "listar-partidos-filtrados", method = RequestMethod.GET)
    public ModelAndView listarPartidosConFiltro(@ModelAttribute("filtros-partido") DatosCrearPartido datosPartido) {
        ModelMap model = new ModelMap();
        model.put("PARTIDOS", servicioCrearPartido.filtrarPartidos(datosPartido.getLocalidad(), datosPartido.getCategoria()));
        return new ModelAndView("home", model);
    }

    @RequestMapping(path = "/unirme-al-partido", method = RequestMethod.GET)
    public ModelAndView irAUnirmeAlPartido() {
        ModelMap model = new ModelMap();
        model.put("PARTIDOS", servicioCrearPartido.todosLosPartidos());
        return new ModelAndView("unirme-al-partido", model);
    }

    @RequestMapping(path = "union-partido/{id}", method = RequestMethod.GET)
    public ModelAndView unirseAUnPartido(@ModelAttribute("unirse-a-partido") DatosCrearPartido partido, @PathVariable Long id) {
        Partido partidoPorId = servicioCrearPartido.buscarPartidoPorID(id);
        servicioCrearPartido.unirmeAlPartido(partidoPorId);
        //this.vincularJugadorAPartido(HttpServletRequest request, partidoPorId);
        ModelMap modelo = new ModelMap();
        modelo.put("msg", "¡Te uniste al partido correctamente!");
        return new ModelAndView("union-a-partido", modelo);
    }

    public Boolean veficarCantidadDeJugadores(Partido partido) {
        Boolean cantidadDeJugadoresCorrecta = partido.getCompleto();
        return cantidadDeJugadoresCorrecta;
    }

    public Boolean vincularJugadorAPartido(HttpServletRequest request, Partido partido){
        Long idUsuario = (Long) request.getSession().getAttribute("id");
        servicioCrearPartido.vincularJugadorAPartido(idUsuario, partido.getId());
        return true;
    }

}
