package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

public class ControladorRegistrarme {

    public ModelAndView registrarUsuario(DatosRegistro datos) {

        ModelMap model = new ModelMap();

        if (esValido(datos.getEmail())) {

            model.put("email", datos.getEmail());
            model.put("msg", "Registro Exitoso");
            return new ModelAndView("login", model);
        }

        model.put("msg", "Registro Fallido por mail incorrecto");
        return new ModelAndView("registrarme", model);
    }

    private boolean esValido(String email) {
        return email.endsWith(".com") && email.contains("@");
    }
}
