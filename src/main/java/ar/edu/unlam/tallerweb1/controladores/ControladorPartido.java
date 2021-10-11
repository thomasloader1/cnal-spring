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

            model.put("categoria", datosPartido.getCategoria());
            model.put("horario", datosPartido.getHorario());

            Partido partido = new Partido(5L, datosPartido.getCant_jugadores(), datosPartido.getTipo(), datosPartido.getCategoria(), datosPartido.getHorario());
            servicioCrearPartido.registrar(partido);
            modeloVista = new ModelAndView("partido-registrado", model);
        }
        else{
            model.put("msg", datosPartido.losDatosIngresadosSonValidos(datosPartido));
            modeloVista = new ModelAndView("registro-partido", model);
        }

        return modeloVista;
    }




/*
>>>>>>> scarlet
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
        return new ModelAndView("unirme-al-partido");
    }


    @RequestMapping(path = "/union-partido", method = RequestMethod.POST)
    public ModelAndView unirseAUnPartido(@ModelAttribute("unirse-a-partido") DatosCrearPartido partido) {

        ModelMap modelo = new ModelMap();

        modelo.put("msg", "¡Te uniste al partido correctamente!");

        return new ModelAndView("union-a-partido", modelo);
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
