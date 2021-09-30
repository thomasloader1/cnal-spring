package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.servicios.ServicioCrearPartido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class ControladorPartido {

    private ServicioCrearPartido servicioCrearPartido;

    @Autowired
    public ControladorPartido(ServicioCrearPartido servicioCrearPartido) {
        this.servicioCrearPartido = servicioCrearPartido;
    }

    @RequestMapping(path = "/registro-partido", method = RequestMethod.GET)
    public ModelAndView irARegistroPartido(){
        return new ModelAndView("registro-partido");
    }



    @RequestMapping(method = RequestMethod.POST, path = "/registrar-partido")
    public ModelAndView registrarPartido(@ModelAttribute("partido-nuevo") Partido partido) {
        ModelMap model = new ModelMap();
        ModelAndView modeloVista = null;

        if(validarCategoria(partido.getCategoria()) && validarTipoPartido(partido.getTipo())){
            model.put("msg", "El partido se creo con éxito");
            //Se muestra en la vista de éxito estos dos datos:
            model.put("categoria", partido.getCategoria());
            model.put("horario", partido.getHorario());

            modeloVista = new ModelAndView("partido-registrado", model);
        }else{
            if(!(validarCategoria(partido.getCategoria()))){
                model.put("msg", "La categoría es incorrecta.");

                modeloVista = new ModelAndView("registro-partido", model);
            }
            else{
                if(!(validarTipoPartido(partido.getTipo()))){
                    model.put("msg", "El tipo de partido ingresado es incorrecto.");
                    modeloVista = new ModelAndView("registro-partido", model);
                }
            }

        }
        return modeloVista;
    }

    public boolean validarCategoria (String categoria){
        boolean esValido = false;
        if(categoria.equals("Infantil") || categoria.equals("Juvenil") || categoria.equals("Adulto")){
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
}
