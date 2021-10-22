package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.servicios.ServicioTorneo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class ControladorTorneo {

    private ServicioTorneo servicioTorneo;

    @Autowired
    public ControladorTorneo(ServicioTorneo servicioTorneo){
        this.servicioTorneo= servicioTorneo;
    }

    @RequestMapping(method= RequestMethod.POST, path = "/registrar-torneo")
    public ModelAndView registrarTorneo(@ModelAttribute("torneo-nuevo") DatosTorneo datosTorneo) {
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



}
