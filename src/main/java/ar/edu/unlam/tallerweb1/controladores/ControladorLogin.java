package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class ControladorLogin {

	// La anotacion @Autowired indica a Spring que se debe utilizar el contructor como mecanismo de inyección de dependencias,
	// es decir, qeue lo parametros del mismo deben ser un bean de spring y el framewrok automaticamente pasa como parametro
	// el bean correspondiente, en este caso, un objeto de una clase que implemente la interface ServicioLogin,
	// dicha clase debe estar anotada como @Service o @Repository y debe estar en un paquete de los indicados en
	// applicationContext.xml
	private ServicioLogin servicioLogin;
	private ServicioUsuario servicioUsuario;

	@Autowired
	public ControladorLogin(ServicioLogin servicioLogin, ServicioUsuario servicioUsuario){
		this.servicioLogin = servicioLogin;
		this.servicioUsuario = servicioUsuario;
	}

	@RequestMapping("/login")
	public ModelAndView irALogin() {
		ModelMap modelo = new ModelMap();
		modelo.put("datosLogin", new DatosLogin());
		return new ModelAndView("login", modelo);
	}

	@RequestMapping(path = "/validar-login", method = RequestMethod.POST)
	public ModelAndView validarLogin(@ModelAttribute("datosLogin") DatosLogin datosLogin, HttpServletRequest request) {
		ModelMap model = new ModelMap();
		Usuario usuarioBuscado = servicioLogin.consultarUsuario(datosLogin.getEmail(), datosLogin.getPassword());
		if (usuarioBuscado != null) {
			request.getSession().setAttribute("ROL", usuarioBuscado.getRol());
			request.getSession().setAttribute("ID", usuarioBuscado.getId());
			return redirectPorRol(usuarioBuscado.getRol(), usuarioBuscado);
		} else {
			model.put("error", "Usuario o clave incorrecta");
		}
		return new ModelAndView("login", model);
	}

	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public ModelAndView irAHome() {
		return new ModelAndView("redirect:/listar-partidos");
	}

	@RequestMapping(path = "/index-admin", method = RequestMethod.GET)
	public ModelAndView irAHomeAdmin(HttpServletRequest request) {
		List<Usuario> usuarioList = servicioUsuario.todosLosUsuarios();
		ModelMap model = new ModelMap();
		Long idUsuario = (Long) request.getSession().getAttribute("ID");
		model.put("user", servicioUsuario.buscarUsuarioPorId(idUsuario));

		if(usuarioList != null)
		{
			model.put("USUARIOS", usuarioList);
		}
		return new ModelAndView("admin/index-admin",model);
	}

	@RequestMapping(path = "/index-jugador", method = RequestMethod.GET)
	public ModelAndView irAHomeJugador(HttpServletRequest request) {

		return new ModelAndView("redirect:/listar-mis-partidos");
	}

	@RequestMapping(path = "/index-jugador-partidos", method = RequestMethod.GET)
	public ModelAndView irAHomeJugadorConPartidos() {
		return new ModelAndView("jugador/index-jugador");
	}

	// Escucha la url /, y redirige a la URL /login, es lo mismo que si se invoca la url /login directamente.
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView inicio() {
		return new ModelAndView("redirect:/login");
	}

	public ModelAndView redirectPorRol(String rol, Usuario usuario){
		ModelMap model = new ModelMap();
		model.put("usuario", usuario);

		switch (rol) {
			case "Admin":
				return new ModelAndView("redirect:/index-admin", model);

			case "Jugador":
				return new ModelAndView("redirect:/index-jugador", model);
		}
		return new ModelAndView("redirect:/home");
	}
	@RequestMapping(path = "/cerrarSesion")
	public ModelAndView cerrarSesion(HttpServletRequest request) {
		request.getSession().removeAttribute("ROL");
		request.getSession().removeAttribute("ID");
		return new ModelAndView("redirect:/login");
	}
}
