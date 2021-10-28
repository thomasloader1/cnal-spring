package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Equipo;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioEquipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;

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



    @RequestMapping(path = "/unirme-a-equipo", method = RequestMethod.GET)
    public ModelAndView irAUnirmeAUnEquipo() {
        ModelMap model = new ModelMap();
        model.put("EQUIPOS", servicioEquipo.buscarTodosLosEquipos());
        return new ModelAndView("unirme-a-equipo", model);
    }


    @RequestMapping(path = "/unirse-a-equipo/{id}", method = RequestMethod.GET)
    public ModelAndView unirmeAUnEquipo(@ModelAttribute("unirse-a-equipo") Equipo equipo, Usuario usuario, @PathVariable Long id) {

        ModelMap model = new ModelMap();
        ModelAndView modeloVista;

        try{
            servicioEquipo.registrarEnEquipo(id, usuario);
            //model.put("msg", "Te uniste correctamente");
            modeloVista = new ModelAndView("union-equipo-exitosa", model);
        }
        catch (Exception e){
            model.put("error", "El equipo ya esta completo");
            modeloVista = new ModelAndView("unirme-a-equipo", model);
        }

        return modeloVista;
    }

    @RequestMapping(path = "listar-equipos-filtrados", method = RequestMethod.GET)
    public ModelAndView listarEquiposConFiltro(@RequestParam("tipoPartido") Integer tipoPartido) {
        ModelMap model = new ModelMap();
        model.put("EQUIPOS", servicioEquipo.filtrarEquipos(tipoPartido));

        if(tipoPartido.toString().toLowerCase(Locale.ROOT).equals("0") ){
            model.put("msg", "¡Debe seleccionar un tipo de partido para filtrar!");
            model.put("EQUIPOS", servicioEquipo.buscarTodosLosEquipos());
            return new ModelAndView("unirme-a-equipo", model);
        }
        return new ModelAndView("unirme-a-equipo", model);
    }
}
