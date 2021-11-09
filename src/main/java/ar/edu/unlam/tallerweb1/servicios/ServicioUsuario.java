package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.modelo.ReporteUsuario;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
//import ar.edu.unlam.tallerweb1.modelo.UsuarioPartido;

import java.util.List;
import java.util.Set;

public interface ServicioUsuario {
    List<Usuario> todosLosUsuarios();
    void cambiarRolUsuario(Long id);
    void eliminarUsuario(Long id);
    List<Usuario> todosLosUsuariosPorPartido(Long idPartido);
    void enviarReporteUsuario(ReporteUsuario reporteUsuario);
    List<ReporteUsuario> todosLosReportesPorUsuario(Long id);
    void sancionarJugador(Long id);
    Boolean usuarioSancionado(Long id);
    Boolean vincularUsuarioAPartido(Long idUsuario, Long idPartido);
    Set<Partido> partidosDelUsuario(Long idUsuario);
}
