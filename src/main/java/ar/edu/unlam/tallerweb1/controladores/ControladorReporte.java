package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.servicios.ServicioReporte;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorReporte {

    private ServicioReporte servicioReporte;

    private ServicioUsuario servicioUsuario;

    @Autowired
    public ControladorReporte(ServicioReporte servicioReporte, ServicioUsuario servicioUsuario) {
        this.servicioReporte = servicioReporte;
        this.servicioUsuario = servicioUsuario;
    }


    @RequestMapping(path = "aprobar-reporte-usuario/{id}", method = RequestMethod.GET)
    public ModelAndView reporteAprobado(@PathVariable Long id){

        servicioReporte.aprobarReporte(id);

        return new ModelAndView("reporte-aprobado");
    }
}
