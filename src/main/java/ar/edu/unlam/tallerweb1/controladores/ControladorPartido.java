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

import java.util.LinkedList;
import java.util.List;

@Controller
public class ControladorPartido {

    private ServicioPartido servicioCrearPartido;

    @Autowired
    public ControladorPartido(ServicioPartido servicioCrearPartido) {
        this.servicioCrearPartido = servicioCrearPartido;
    }

    @RequestMapping(path = "/registro-partido", method = RequestMethod.GET)
    public ModelAndView irARegistroPartido(){
        return new ModelAndView("registro-partido");
    }



    @RequestMapping(method = RequestMethod.POST , path = "/registrar-partido")
    public ModelAndView registrarPartido(@ModelAttribute("partido-nuevo") DatosCrearPartido datosPartido) {
        ModelMap model = new ModelMap();
        ModelAndView modeloVista = null;
        if(datosPartido.losDatosIngresadosSonValidos(datosPartido).equals("exito")){
            model.put("msg", "El partido se creo con éxito");
            //Se muestra en la vista de éxito estos dos datos:
            model.put("cant_jugadores",datosPartido.getCant_jugadores());
            model.put("categoria",datosPartido.getCategoria());
            model.put("horario",datosPartido.getHorario());
            model.put("tipo",datosPartido.getTipo());
            model.put("localidad",datosPartido.getLocalidad());


            Partido partido = new Partido(5L, datosPartido.getCant_jugadores(), datosPartido.getCant_lugaresDisp(), datosPartido.getTipo(), datosPartido.getCategoria(), datosPartido.getHorario(), datosPartido.getLocalidad());
            servicioCrearPartido.registrar(partido);
            modeloVista = new ModelAndView("partido-registrado", model);
        }
        else{
            model.put("msg", datosPartido.losDatosIngresadosSonValidos(datosPartido));
            modeloVista = new ModelAndView("registro-partido", model);
        }

        return modeloVista;
    }

    @RequestMapping(path = "listar-partidos" , method = RequestMethod.GET)
    public ModelAndView listarPartidos(){
        ModelMap model = listarPartidosMethod();
        return new  ModelAndView("home",model);
    }

    @RequestMapping(path = "listar-partidos-filtrados" , method = RequestMethod.GET)
    public ModelAndView listarPartidosConFiltro(@ModelAttribute("filtros-partido") DatosCrearPartido datosPartido){
        ModelMap model = new ModelMap();
        model.put("PARTIDOS",servicioCrearPartido.filtrarPartidos(datosPartido.getLocalidad() , datosPartido.getCategoria()));

        List<Partido> listPartidos = new LinkedList<>();

        for (Partido partidos : listPartidos){
            model.put("cant_jugadores",partidos.getCant_jugadores());
            model.put("categoria",partidos.getCategoria());
            model.put("horario",partidos.getHorario());
            model.put("tipo",partidos.getTipo());
            model.put("completo",partidos.getCompleto());
            model.put("id",partidos.getId());
        }

        return new  ModelAndView("home",model);
    }

/*
    public void validarDatos(Partido datosPartido) {
    }

    public Boolean veficarCantidadDeJugadores(int cant_jugadores) {
        if(cant_jugadores < 10){
            return true;
        }

        return false;
    }
*/

    @RequestMapping(path = "/unirme-al-partido", method = RequestMethod.GET)
    public ModelAndView irAUnirmeAlPartido(){
        ModelMap model = listarPartidosMethod();
        return new  ModelAndView("unirme-al-partido",model);
    }
    private ModelMap listarPartidosMethod(){
        ModelMap model = new ModelMap();
        model.put("PARTIDOS",servicioCrearPartido.todosLosPartidos());

        List<Partido> listPartidos = new LinkedList<>();

        for (Partido partidos : listPartidos){
            model.put("cant_jugadores",partidos.getCant_jugadores());
            model.put("cant_lugaresDisp", partidos.getCant_lugaresDisp());
            model.put("categoria",partidos.getCategoria());
            model.put("horario",partidos.getHorario());
            model.put("tipo",partidos.getTipo());
            model.put("completo",partidos.getCompleto());
            model.put("id",partidos.getId());
        }
        return model;
    }

    private ModelMap listarUnPartidoMethod(Long id){
        ModelMap model = new ModelMap();
        Partido partido = servicioCrearPartido.buscarPartidoPorID(id);
        model.put("PARTIDO", partido);

        model.put("cant_jugadores",partido.getCant_jugadores());
        model.put("cant_lugaresDisp", partido.getCant_lugaresDisp());
        model.put("categoria",partido.getCategoria());
        model.put("horario",partido.getHorario());
        model.put("tipo",partido.getTipo());
        model.put("completo",partido.getCompleto());
        model.put("id",partido.getId());

        return model;
    }

    @RequestMapping(path = "union-partido/{id}", method = RequestMethod.GET)
    public ModelAndView unirseAUnPartido(@ModelAttribute("unirse-a-partido") DatosCrearPartido partido, @PathVariable Long id) {
        Partido partidoPorId = servicioCrearPartido.buscarPartidoPorID(id);
        servicioCrearPartido.unirmeAlPartido(partidoPorId);
        ModelMap modelo = new ModelMap();
        modelo.put("msg", "¡Te uniste al partido correctamente!");
        return new ModelAndView("union-a-partido", modelo);
    }

    public Boolean veficarCantidadDeJugadores(Partido partido) {
        Boolean cantidadDeJugadoresCorrecta = partido.getCompleto();
        return cantidadDeJugadoresCorrecta;
    }


/*
    @RequestMapping(method = RequestMethod.POST, path = "/union-partido")
    public ModelAndView unirseAUnPartido(@ModelAttribute("unirse-a-partido") DatosCrearPartido datosPartido) {

        ModelMap modelo = new ModelMap();
        ModelAndView modeloVista = null;

        if(validarLugaresDisponibles(datosPartido)){
            modelo.put("msg", "¡Te uniste al partido correctamente!");
            modeloVista = new ModelAndView("union-a-partido", modelo);
        }
        else{
            modelo.put("msg", "El partido seleccionado ya esta completo");
            modeloVista = new ModelAndView("unirme-al-partido", modelo);
        }

        return modeloVista;
    }



    public boolean validarLugaresDisponibles(DatosCrearPartido datosPartido){
        boolean hayLugar = false;
        if(datosPartido.getTipo().equals("5") && datosPartido.getCant_jugadores()<10){
            hayLugar = true;
        }
        else if(datosPartido.getTipo().equals("11") && datosPartido.getCant_jugadores()<22){
            hayLugar = true;
        }
        return hayLugar;
    }
*/



}
