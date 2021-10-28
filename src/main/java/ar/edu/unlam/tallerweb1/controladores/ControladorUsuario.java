package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.UsuarioPartido;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ControladorUsuario
{
    private ServicioUsuario servicioUsuario;

    @Autowired
    public ControladorUsuario(ServicioUsuario servicioUsuario)
    {
        this.servicioUsuario = servicioUsuario;
    }

    @RequestMapping(path = "cambio-rol/{id}", method = RequestMethod.GET)
    public ModelAndView cambiarRolUsuario(@PathVariable Long id) {
        try
        {
            servicioUsuario.cambiarRolUsuario(id);
            List<Usuario> usuarioList = servicioUsuario.todosLosUsuarios();
            ModelMap model = new ModelMap();
            if(usuarioList != null)
            {
                model.put("USUARIOS", usuarioList);
            }
            return new ModelAndView("admin/index-admin", model);
        }
        catch (Exception e){
            throw e;
        }

    }
}
