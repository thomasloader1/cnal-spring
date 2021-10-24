package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioEquipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorEquipo {

    private ServicioEquipo servicioEquipo;

    @Autowired
    public ControladorEquipo(ServicioEquipo servicioEquipo) {
        this.servicioEquipo = servicioEquipo;
    }

    @RequestMapping(path = "/registro-equipo", method = RequestMethod.GET)
    public ModelAndView irARegistroEquipo() {
        return new ModelAndView("registro-equipo");
    }

    @RequestMapping(method = RequestMethod.POST, path = "/registrar-equipo")
    public ModelAndView registrarEquipo(@ModelAttribute("equipo-nuevo") DatosEquipo datosEquipo) {
        ModelMap model = new ModelMap();

        model.put("equipo", datosEquipo);

        try{
            servicioEquipo.registrarEquipo(datosEquipo.crearEquipo());
        }
        catch (Exception e){
            model.put("msg","La cancha ya existe");
            return new ModelAndView("registro-equipo", model);
        }

        return new ModelAndView("equipo-registrado", model);
    }


    public ModelAndView unirmeAUnEquipo(DatosEquipo equipo, Usuario usuario) {

        ModelMap model = new ModelMap();
        ModelAndView modeloVista;

        try{
            servicioEquipo.registrarEnEquipo(equipo.getNombre(), usuario);
            model.put("msg", "Te uniste correctamente");
            modeloVista = new ModelAndView("union-equipo-exitosa", model);
        }
        catch (Exception e){
            model.put("error", "El equipo ya esta completo");
            modeloVista = new ModelAndView("union-a-equipo", model);
        }

        return modeloVista;
    }
}
