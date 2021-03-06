package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Cancha;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.UsuarioPartido;

import java.util.List;

// Interface que define los metodos del Repositorio de Usuarios.
public interface RepositorioUsuario {
	
	Usuario buscarUsuario(String email, String password);
	void guardar(Usuario usuario);
    Usuario buscar(String email);
	void modificar(Usuario usuario);
	List<Usuario> todosLosUsuarios();
	Usuario buscarUsuarioPorId(Long id);
	void eliminarUsuario(Usuario usuario);
	List<Usuario> listarJugadoresPorPartido(Long idPartido);
	Usuario verPerfil(Long id);
	void cambiarContraseña(Usuario usuario);
}
