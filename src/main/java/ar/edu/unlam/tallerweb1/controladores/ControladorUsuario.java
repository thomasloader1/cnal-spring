package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.ReporteUsuario;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
public class ControladorUsuario {
    private ServicioUsuario servicioUsuario;
    private RepositorioUsuario repositorioUsuario;

    @Autowired
    public ControladorUsuario(ServicioUsuario servicioUsuario, RepositorioUsuario repositorioUsuario) {
        this.servicioUsuario = servicioUsuario;
        this.repositorioUsuario = repositorioUsuario;
    }

    @RequestMapping(path = "cambio-rol/{id}", method = RequestMethod.GET)
    public ModelAndView cambiarRolUsuario(@PathVariable Long id) {
        try {
            servicioUsuario.cambiarRolUsuario(id);
            List<Usuario> usuarioList = servicioUsuario.todosLosUsuarios();
            ModelMap model = new ModelMap();
            if (usuarioList != null) {
                model.put("USUARIOS", usuarioList);
            }
            return new ModelAndView("admin/index-admin", model);
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(path = "eliminar-usuario/{id}", method = RequestMethod.GET)
    public ModelAndView eliminarUsuario(HttpServletRequest request, @PathVariable Long id) {
        try {
            Long idUsuario = (Long) request.getSession().getAttribute("ID");

            if (idUsuario != id) {
                servicioUsuario.eliminarUsuario(id);
            }
            List<Usuario> usuarioList = servicioUsuario.todosLosUsuarios();
            ModelMap model = new ModelMap();
            if (usuarioList != null) {
                model.put("USUARIOS", usuarioList);
            }
            return new ModelAndView("admin/index-admin", model);
        } catch (Exception e) {
            throw e;
        }
    }


    @RequestMapping(path = "ver-jugadores-partido/{id}", method = RequestMethod.GET)
    public ModelAndView listarJugadoresPorPartido(HttpServletRequest request,@PathVariable Long id) {

        ModelMap model = new ModelMap();
        Long idUsuario = (Long) request.getSession().getAttribute("ID");

        List<Usuario> usuarioList = servicioUsuario.todosLosUsuariosPorPartido(id);

        Usuario usarioActual = servicioUsuario.buscarUsuarioPorId(idUsuario);

        model.put("USUARIO_ACTUAL", usarioActual);
        model.put("USUARIO", usuarioList);

        return new ModelAndView("lista-jugadores", model);
    }

    @RequestMapping(path = "reportar-usuario/{id}", method = RequestMethod.GET)
    public ModelAndView reportarUsuario(HttpServletRequest request,@PathVariable Long id) {

        ModelMap model = new ModelMap();

        Long idUsuario = (Long) request.getSession().getAttribute("ID");

        DatosReporte datosReporte = new DatosReporte();

        Usuario usarioActual = servicioUsuario.buscarUsuarioPorId(idUsuario);

        model.put("USUARIO_ACTUAL", usarioActual);

        model.put("IDUSUARIO", id);

        return new ModelAndView("formulario-reporte", model);
    }

    @RequestMapping(value = "enviar-reporte-usuario/{id}", method = RequestMethod.POST)
    public ModelAndView envioReporteUsuario(HttpServletRequest request,@ModelAttribute("datos-reporte") DatosReporte datosReporte,@PathVariable Long id) {

        Long idUsuario = (Long) request.getSession().getAttribute("ID");

        ModelMap model = new ModelMap();
        ReporteUsuario reporteUsuario = new ReporteUsuario();
        Date date = new Date();
        reporteUsuario.setMotivo(datosReporte.getMotivo());
        reporteUsuario.setDescripcion(datosReporte.getDescripcion());
        reporteUsuario.setIdUsuario(id);
        reporteUsuario.setAprobado(false);
        reporteUsuario.setFechaReporte(date);

        Usuario usarioActual = servicioUsuario.buscarUsuarioPorId(idUsuario);

        model.put("USUARIO_ACTUAL", usarioActual);

        model.put("REPORTE", reporteUsuario);

        servicioUsuario.enviarReporteUsuario(reporteUsuario);

        return new ModelAndView("envio-formulario-reporte", model);
    }

    @RequestMapping(path = "ver-reportes-usuario/{id}", method = RequestMethod.GET)
    public ModelAndView listarReportesPorUsuario(@PathVariable Long id) {

        List<ReporteUsuario> reporteUsuariosList = servicioUsuario.todosLosReportesPorUsuario(id);

        ModelMap model = new ModelMap();

        model.put("IDUSUARIO", id);

        model.put("REPORTES", reporteUsuariosList);

        return new ModelAndView("lista-reportes", model);
    }

    @RequestMapping(path = "sancionarUsuario/{id}", method = RequestMethod.GET)
    public ModelAndView sancionarUsuario(@PathVariable Long id) {

        servicioUsuario.sancionarJugador(id);

        List<ReporteUsuario> reporteUsuariosList = servicioUsuario.todosLosReportesPorUsuario(id);

        ModelMap model = new ModelMap();

        model.put("REPORTES", reporteUsuariosList);
        model.put("error", "El Jugador ha sido sancionado");

        return new ModelAndView("lista-reportes", model);
    }

}

