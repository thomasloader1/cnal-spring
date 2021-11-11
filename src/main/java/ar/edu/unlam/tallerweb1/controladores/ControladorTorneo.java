package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.PartidoTorneo;
import ar.edu.unlam.tallerweb1.modelo.Torneo;
import ar.edu.unlam.tallerweb1.servicios.ExceptionYaExiste;
import ar.edu.unlam.tallerweb1.servicios.ServicioTorneo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ControladorTorneo {

    private ServicioTorneo servicioTorneo;

    @Autowired
    public ControladorTorneo(ServicioTorneo servicioTorneo){
        this.servicioTorneo= servicioTorneo;
    }

    @RequestMapping(path = "/registro-torneo", method = RequestMethod.GET)
    public ModelAndView irARegistroTorneo(){
        return new ModelAndView("registro-torneo");
    }

    @RequestMapping(method= RequestMethod.POST, path = "/registrar-torneo")
    public ModelAndView registrarTorneo(@ModelAttribute("torneo-nuevo") DatosTorneo datosTorneo) throws ExceptionYaExiste {
        ModelMap model= new ModelMap();
        ModelAndView modelAndView= null;

        if(datosTorneo.losDatosIngresadosSonValidos(datosTorneo).equals("exito")){
            model.put("msg", "El torneo se creo con éxito");
            model.put("torneo", datosTorneo);
            servicioTorneo.registrarTorneo(datosTorneo.crearTorneo());
            modelAndView= new ModelAndView("torneo-registrado", model);
        }else {
            model.put("msg", datosTorneo.losDatosIngresadosSonValidos(datosTorneo));
            modelAndView= new ModelAndView("registro-torneo", model);
        }

        return modelAndView;
    }

    @RequestMapping(path = "/unirse-a-torneo", method = RequestMethod.GET)
    public ModelAndView irAUnirseATorneo(){
        ModelMap model= new ModelMap();
        model.put("torneos", servicioTorneo.todosLosTorneos());
        return new ModelAndView("unirme-a-torneo", model);
    }

    @RequestMapping(path = "/unirme-a-torneo/{id}", method = RequestMethod.GET)
    public ModelAndView unirmeAUnTorneo(@ModelAttribute("unirse-a-torneo") @PathVariable Long id, HttpServletRequest request) throws Exception {
        Long idUsuario = (Long) request.getSession().getAttribute("ID");
        ModelMap modelMap= new ModelMap();
        ModelAndView modelAndView;

        if (servicioTorneo.registrarEnTorneo(id, idUsuario)){
            modelAndView = new ModelAndView("union-torneo", modelMap);
        } else{
            modelMap.put("error", "el torneo ya esta completo");
            modelAndView = new ModelAndView("unirme-a-torneo", modelMap);
        }
        return modelAndView;
    }

    public ModelAndView generarCruceDeEquipos(Torneo torneo) {
    @RequestMapping(path = "/crear-fixture/{idTorneo}", method = RequestMethod.POST)
    public ModelAndView generarCruceDeEquipos(@ModelAttribute("crear-fixture") @PathVariable Long idTorneo) {
        ModelAndView modeloVista = null;
        ModelMap model = new ModelMap();


        try {
            servicioTorneo.generarCruceDeEquiposDeUnTorneo(idTorneo);

            Torneo torneo = servicioTorneo.buscarTorneoPorID(idTorneo);
            List<PartidoTorneo> partidosDelTorneo = servicioTorneo.buscarLosPartidosDeUnTorneo(torneo);
            model.put("PARTIDOSTORNEO", partidosDelTorneo);

            modeloVista = new ModelAndView("fixture-generado", model);


        }catch (Exception e){
            model.put("error", "El torneo está incompleto. No se puede generar el fixture");
            modeloVista = new ModelAndView("torneos-registrados", model);
        }


        return modeloVista;
    }
}
