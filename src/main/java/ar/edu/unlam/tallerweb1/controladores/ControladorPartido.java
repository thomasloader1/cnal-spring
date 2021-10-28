package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.modelo.UsuarioPartido;
import ar.edu.unlam.tallerweb1.servicios.ServicioLocalidad;
import ar.edu.unlam.tallerweb1.servicios.ServicioPartido;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.net.ssl.HandshakeCompletedEvent;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Locale;

@Controller
public class ControladorPartido {

    private ServicioPartido servicioCrearPartido;

    private ServicioLocalidad servicioLocalidad;

    @Autowired
    public ControladorPartido(ServicioPartido servicioCrearPartido, ServicioLocalidad servicioLocalidad) {
        this.servicioCrearPartido = servicioCrearPartido;
        this.servicioLocalidad = servicioLocalidad;
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
    @RequestMapping(path = "listar-mis-partidos", method = RequestMethod.GET)
    public ModelAndView listarMisPartidos(HttpServletRequest request) {
        ModelMap model = new ModelMap();
        Long idUsuario = (Long) request.getSession().getAttribute("ID");
        model.put("PARTIDOS", servicioCrearPartido.todosLosPartidos());
        if(idUsuario != null) {
            List<Partido> partidosList = servicioCrearPartido.buscarPartidosPorUsuario(idUsuario);
            if(partidosList != null){
                model.put("MIS_PARTIDOS", partidosList);
            }
        }
        return new ModelAndView("jugador/index-jugador", model);
    }
    @RequestMapping(path = "listar-partidos-filtrados", method = RequestMethod.GET)
    public ModelAndView listarPartidosConFiltro(@RequestParam("localidad") String localidad, @RequestParam("categoria") String categoria) {
        ModelMap model = new ModelMap();
        model.put("PARTIDOS", servicioCrearPartido.filtrarPartidos(localidad, categoria));
        model.put("LOCALIDAD", servicioLocalidad.todasLasLocalidades());

        if(categoria.toLowerCase(Locale.ROOT).equals("categoria") && localidad.toLowerCase(Locale.ROOT).equals("localidad")){
            model.put("msg", "¡Debe seleccionar una categoria o una localidad para filtrar!");
        }

        return new ModelAndView("unirme-al-partido", model);
    }

    @RequestMapping(path = "/unirme-al-partido", method = RequestMethod.GET)
    public ModelAndView irAUnirmeAlPartido() {
        ModelMap model = new ModelMap();
        model.put("PARTIDOS", servicioCrearPartido.todosLosPartidos());
        model.put("LOCALIDAD", servicioLocalidad.todasLasLocalidades());
        return new ModelAndView("unirme-al-partido", model);
    }

    @RequestMapping(path = "union-partido/{id}", method = RequestMethod.GET)
    public ModelAndView unirseAUnPartido(HttpServletRequest request, @ModelAttribute("unirse-a-partido") DatosCrearPartido partido, @PathVariable Long id) {
        try {

            Long idUsuario = (Long) request.getSession().getAttribute("ID");
            ModelMap modelo = new ModelMap();
            UsuarioPartido usuario = servicioCrearPartido.buscarUsuarioPartido(idUsuario , id);

            if(usuario == null) {
                Partido partidoPorId = servicioCrearPartido.buscarPartidoPorID(id);
                servicioCrearPartido.unirmeAlPartido(partidoPorId);

                servicioCrearPartido.vincularJugadorAPartido(idUsuario, id);

                modelo.put("msg", "¡Te uniste al partido correctamente!");
                return new ModelAndView("union-a-partido", modelo);
            }
            else {
                modelo.put("PARTIDOS", servicioCrearPartido.todosLosPartidos());
                modelo.put("LOCALIDAD", servicioLocalidad.todasLasLocalidades());
                modelo.put("msg", "¡Ya te haz unido a este partido!");
                return new ModelAndView("unirme-al-partido", modelo);
            }
        }
        catch (Exception e){
            throw e;
        }

    }

    public Boolean veficarCantidadDeJugadores(Partido partido) {
        Boolean cantidadDeJugadoresCorrecta = partido.getCompleto();
        return cantidadDeJugadoresCorrecta;
    }

}
