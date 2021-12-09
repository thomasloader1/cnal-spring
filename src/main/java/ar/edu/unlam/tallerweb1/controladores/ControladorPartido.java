package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Cancha;
import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.UsuarioPartido;
import ar.edu.unlam.tallerweb1.servicios.*;
import com.mercadopago.resources.Preference;
import com.mercadopago.resources.datastructures.preference.Item;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.net.ssl.HandshakeCompletedEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;

import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPConfException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Payment;
import com.mercadopago.resources.datastructures.payment.Payer;

@Controller
@SessionAttributes("partido")
public class ControladorPartido {

    private ServicioPartido servicioCrearPartido;
    private ServicioLocalidad servicioLocalidad;
    private ServicioUsuario servicioUsuario;
    private ServicioCancha servicioCancha;
    private ServicioAbonar servicioAbonar;

    @Autowired
    public ControladorPartido(ServicioPartido servicioCrearPartido, ServicioLocalidad servicioLocalidad, ServicioUsuario servicioUsuario, ServicioCancha servicioCancha,ServicioAbonar servicioAbonar) {
        this.servicioCrearPartido = servicioCrearPartido;
        this.servicioLocalidad = servicioLocalidad;
        this.servicioUsuario = servicioUsuario;
        this.servicioCancha = servicioCancha;
        this.servicioAbonar = servicioAbonar;
    }

    @RequestMapping(path = "/registro-partido/{id}", method = RequestMethod.POST)
    public ModelAndView irARegistroPartido(@PathVariable Long id) {
        ModelMap model = new ModelMap();
        Cancha cancha = servicioCancha.buscarCanchaPorId(id);
        model.put("CANCHA",cancha);
        return new ModelAndView("registro-partido", model);
    }

    @RequestMapping(method = RequestMethod.POST, path = "registrar-partido/{id}")
    public ModelAndView registrarPartido(@ModelAttribute("partido-nuevo") DatosCrearPartido datosPartido,@PathVariable Long id) {
        ModelMap model = new ModelMap();
        Cancha cancha = servicioCancha.buscarCanchaPorId(id);
        model.put("CANCHA",cancha);
        ModelAndView modeloVista = null;
        if (datosPartido.losDatosIngresadosSonValidos(datosPartido).equals("exito")) {

            List<Partido> partidoEncontrado = servicioCrearPartido.buscarPartidoPorFechaYHora(datosPartido.getFechaPartido(),datosPartido.getHorario());

            if(partidoEncontrado == null || partidoEncontrado.size() < cancha.getCant_canchas()) {
                model.put("msg", "El partido se creo con éxito");
                model.put("partido", datosPartido);
                servicioCrearPartido.registrarPartido(datosPartido.crearPartido(), cancha);
                modeloVista = new ModelAndView("partido-registrado", model);
            }
            else{
                model.put("msg", "No hay canchas disponibles para esa fecha y horario");
                modeloVista = new ModelAndView("registro-partido", model);
            }
        } else {
            model.put("msg", datosPartido.losDatosIngresadosSonValidos(datosPartido));
            modeloVista = new ModelAndView("registro-partido", model);
        }
        return modeloVista;
    }

    @RequestMapping(path = "listar-partidos", method = RequestMethod.GET)
    public ModelAndView listarPartidos(HttpServletRequest request) {

        ModelMap model = new ModelMap();
        model.put("PARTIDOS", servicioCrearPartido.todosLosPartidos());

            Long idUsuario = (Long) request.getSession().getAttribute("ID");
            model.put("user", servicioUsuario.buscarUsuarioPorId(idUsuario));
            return new ModelAndView("home", model);


    }

    @RequestMapping(path = "listar-mis-partidos", method = RequestMethod.GET)
    public ModelAndView listarMisPartidos(HttpServletRequest request, ModelMap data) {
        ModelMap model = new ModelMap();
        Long idUsuario = (Long) request.getSession().getAttribute("ID");

        if(idUsuario != null){
            Usuario user = servicioUsuario.buscarUsuarioPorId(idUsuario);
            List<Partido> partidosList = servicioCrearPartido.buscarPartidosPorUsuario(idUsuario);

            model.put("PARTIDOS", servicioCrearPartido.todosLosPartidos());
            model.put("CANCHA", servicioCancha.todasLasCanchas());
            model.put("user", user);

            if(partidosList != null){
                model.put("MIS_PARTIDOS", partidosList);
            }
            return new ModelAndView("jugador/index-jugador", model);
        }
            return new ModelAndView("redirect:/login");

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

    @RequestMapping(path = "/union-partido/{id}", method = RequestMethod.GET)
    public ModelAndView unirseAUnPartido(HttpServletRequest request, @ModelAttribute("unirse-a-partido") DatosCrearPartido partido, @PathVariable Long id) {
        try {
            Long idUsuario = (Long) request.getSession().getAttribute("ID");
            ModelMap modelo = new ModelMap();
            UsuarioPartido usuario = servicioCrearPartido.buscarUsuarioPartido(idUsuario , id);

            if(usuario == null) {
                Boolean sancionado = servicioUsuario.jugadorEstaSancionado(idUsuario);

                if(!sancionado)
                {
                    Partido partidoPorId = servicioCrearPartido.buscarPartidoPorID(id);
                    servicioCrearPartido.unirmeAlPartido(partidoPorId);
                    servicioCrearPartido.vincularJugadorAPartido(idUsuario, id);
                    modelo.put("msg", "¡Te uniste al partido correctamente!");
                    return new ModelAndView("/union-a-partido", modelo);
                }else
                {
                    modelo.put("PARTIDOS", servicioCrearPartido.todosLosPartidos());
                    modelo.put("LOCALIDAD", servicioLocalidad.todasLasLocalidades());
                    modelo.put("msg", "¡No puedes unirte al partido porque actualmente estas SANCIONADO!");
                    return new ModelAndView("/unirme-al-partido", modelo);
                }

            }
            else {
                modelo.put("PARTIDOS", servicioCrearPartido.todosLosPartidos());
                modelo.put("LOCALIDAD", servicioLocalidad.todasLasLocalidades());
                modelo.put("msg", "¡Ya te haz unido a este partido!");
                return new ModelAndView("/unirme-al-partido", modelo);
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

    @RequestMapping(path = "partidos-por-cancha/{id}", method = RequestMethod.GET)
    public ModelAndView listarPartidosPorCancha(@PathVariable Long id){

        ModelMap model = new ModelMap();

        Cancha cancha = servicioCancha.buscarCanchaPorId(id);

        model.put("PARTIDO", servicioCrearPartido.buscarPartidosPorCancha(cancha));

        return new ModelAndView("/lista-partidos-por-cancha", model);
    }

    @RequestMapping(path = "/facturacion", method = RequestMethod.GET)
    public ModelAndView facturacion(HttpServletRequest request) {
        return new ModelAndView("facturacion");
    }

    @RequestMapping(path = "/mercado-pago/{idPartido}", method = RequestMethod.GET)
    public ModelAndView reservarCancha(HttpServletRequest request , @PathVariable Long idPartido) throws MPException {
        ModelMap model = new ModelMap();
        Long idUsuario = (Long) request.getSession().getAttribute("id");
        Partido partido = servicioCrearPartido.buscarPartidoPorID(idPartido);
        model.put("partido", partido);
        Usuario usuario = servicioUsuario.buscarUsuarioPorId(idUsuario);
        model.put("usuario", usuario);
        float precio = 100f;
        model.put("preference", servicioAbonar.reservarCancha(partido,usuario));
        return new ModelAndView("facturacion", model);
    }

}
