package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.ReporteUsuario;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.UsuarioPartido;

import java.util.List;

public interface ServicioUsuario {
    List<Usuario> todosLosUsuarios();
    void cambiarRolUsuario(Long id);
    void eliminarUsuario(Long id);
    List<Usuario> todosLosUsuariosPorPartido(Long idPartido);
    void enviarReporteUsuario(ReporteUsuario reporteUsuario);
    List<ReporteUsuario> todosLosReportesPorUsuario(Long id);
    void sancionarJugador(Long id);
    Boolean jugadorEstaSancionado(Long id);
    Usuario buscarUsuarioPorId(Long id);
}
