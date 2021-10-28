package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class RepositorioUsuarioTest extends SpringTest
{
    private static final Long IDUSUARIO = 1L;
    private static final String EMAIL = "nahuel@asd.com";
    private static final String PASSWORD = "asd";
    private static final String ROLADMIN = "Admin";
    private static final String ROLUSER = "Jugador";

    @Autowired
    private RepositorioUsuario repositorioUsuario;
    MockHttpSession session;

    @Test
    @Transactional
    @Rollback
    public void traerUsuarios(){

        givenUsuarioAdministrador(IDUSUARIO, EMAIL, PASSWORD, ROLADMIN);
        givenUsuarioAdministrador(IDUSUARIO, EMAIL, PASSWORD, ROLUSER);

        List<Usuario> usuariosList = whenBuscoTodosLosUsuario();

        thenEncuentroCantidadDeUsuarios(usuariosList , 2);
    }

    private void givenUsuarioAdministrador(Long idusuario, String email, String password, String rol)
    {
        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        usuario.setPassword(password);
        usuario.setId(idusuario);
        usuario.setRol(rol);
        usuario.setEquipo(null);
        usuario.setActivo(false);

        session().save(usuario);
    }

    private List<Usuario> whenBuscoTodosLosUsuario()
    {
        return repositorioUsuario.todosLosUsuarios();
    }

    private void thenEncuentroCantidadDeUsuarios(List<Usuario> usuariosList, int cantidad)
    {
        assertThat(usuariosList).hasSize(cantidad);
    }
}
