package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.List;

public interface ServicioUsuario {
    List<Usuario> todosLosUsuarios();
    void cambiarRolUsuario(Long id);

}
