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
    public ModelAndView registrarPartido(@ModelAttribute("partido-nuevo") Partido partido) {
        ModelMap model = new ModelMap();
        ModelAndView modeloVista = null;

        if((validarCategoria(partido.getCategoria().toUpperCase())) && (validarTipoPartido(partido.getTipo())) && (validarCantidadJugadores(partido))){
            model.put("msg", "El partido se creo con éxito");
            //Se muestra en la vista de éxito estos dos datos:
            model.put("categoria", partido.getCategoria());
            model.put("horario", partido.getHorario());
            servicioCrearPartido.registrar(partido);

            modeloVista = new ModelAndView("partido-registrado", model);
        }else if(!(validarCategoria(partido.getCategoria().toUpperCase()))){
            model.put("msg", "La categoría es incorrecta.");
            modeloVista = new ModelAndView("registro-partido", model);

        }else if(!(validarTipoPartido(partido.getTipo()))){
            model.put("msg", "El tipo de partido ingresado es incorrecto.");
            modeloVista = new ModelAndView("registro-partido", model);
        }else if(!(validarCantidadJugadores(partido))){
            model.put("msg", "La cantidad de jugadores es inválida para el tipo de partido elegido");
            modeloVista = new ModelAndView("registro-partido", model);
        }

        return modeloVista;
    }

    public boolean validarCantidadJugadores (Partido partido){
        boolean esValido = false;

        if(partido.getTipo().equals("5") && (partido.getCant_jugadores()>=1 && partido.getCant_jugadores()<=10)){
            esValido = true;
        }else if(partido.getTipo().equals("11") && (partido.getCant_jugadores()>=1 && partido.getCant_jugadores()<=22)){
            esValido = true;
        }
        return esValido;
    }

    public boolean validarCategoria (String categoria){
        boolean esValido = false;
        if(categoria.equals("INFANTIL") || categoria.equals("JUVENIL") || categoria.equals("ADULTO")){
            esValido = true;
        }
        return esValido;
    }

    public boolean validarTipoPartido(String tipoPartido){
        boolean esValido = false;
        if(tipoPartido.equals("5") || tipoPartido.equals("11")){
            esValido = true;
        }
        return esValido;
    }

    public void validarDatos(Partido datosPartido) {
    }

    public Boolean veficarCantidadDeJugadores(int cant_jugadores) {
        if(cant_jugadores < 10){
            return true;
        }

        return false;
    }

    @RequestMapping(path = "/unirme-al-partido", method = RequestMethod.GET)
    public ModelAndView irAUnirmeAlPartido(){
        return new ModelAndView("unirme-al-partido");
    }
}
