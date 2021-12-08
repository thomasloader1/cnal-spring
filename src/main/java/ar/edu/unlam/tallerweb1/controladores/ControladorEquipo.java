package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.servicios.ServicioEquipo;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.Locale;
import javax.servlet.http.HttpServletRequest;


@Controller
public class ControladorEquipo {

    //HttpServletRequest request;

    private ServicioEquipo servicioEquipo;
    private ServicioUsuario servicioUsuario;

    @Autowired
    public ControladorEquipo(ServicioEquipo servicioEquipo, ServicioUsuario servicioUsuario) {
        this.servicioEquipo = servicioEquipo;
        this.servicioUsuario = servicioUsuario;
    }

    @RequestMapping(path = "/registro-equipo", method = RequestMethod.GET)
    public ModelAndView irARegistroEquipo() {
        return new ModelAndView("equipo/registro-equipo");
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
            return new ModelAndView("equipo/registro-equipo", model);
        }

        return new ModelAndView("equipo/equipo-registrado", model);
    }



    @RequestMapping(path = "/unirme-a-equipo", method = RequestMethod.GET)
    public ModelAndView irAUnirmeAUnEquipo() {
        ModelMap model = new ModelMap();
        model.put("EQUIPOS", servicioEquipo.buscarTodosLosEquipos());
        return new ModelAndView("equipo/unirme-a-equipo", model);
    }


    @RequestMapping(path = "/unirse-a-equipo/{id}", method = RequestMethod.GET)
    public ModelAndView unirmeAUnEquipo(@ModelAttribute("unirse-a-equipo") @PathVariable Long id, HttpServletRequest request) {

        Long idUsuario = (Long) request.getSession().getAttribute("ID");

        //Long idUsuario = iDUsuario;

        ModelMap model = new ModelMap();
        ModelAndView modeloVista;

        try{
            Boolean sancionado = servicioUsuario.jugadorEstaSancionado(idUsuario);

            if(!sancionado)
            {
                servicioEquipo.registrarEnEquipo(id, idUsuario);
                modeloVista = new ModelAndView("equipo/union-equipo-exitosa", model);
            }else
            {
                model.put("error", "No te puedes unir al equipo porque te encuentras SANCIONADO!");
                model.put("EQUIPOS", servicioEquipo.buscarTodosLosEquipos());
                modeloVista = new ModelAndView("equipo/unirme-a-equipo", model);
            }
        }
        catch (Exception e){
            model.put("error", "El equipo ya esta completo");
            model.put("EQUIPOS", servicioEquipo.buscarTodosLosEquipos());
            modeloVista = new ModelAndView("equipo/unirme-a-equipo", model);
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
            return new ModelAndView("equipo/unirme-a-equipo", model);
        }
        return new ModelAndView("equipo/unirme-a-equipo", model);
    }
}
