package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioReporte;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServicioUsuarioTest
{
    public static final Usuario USUARIO = new Usuario("asd@asd.com", "asd", "Admin" ,"","");
    public static final Usuario USUARIOSANCION = new Usuario("asd@asd.com", "asd", "Admin" ,"","", null);
    private RepositorioUsuario repositorioUsuario = mock(RepositorioUsuario.class);
    private RepositorioReporte repositorioReporte = mock(RepositorioReporte.class);
    private ServicioUsuario servicioUsuario = new ServicioUsuarioImpl(repositorioUsuario, repositorioReporte);

    @Test
    public void puedeCambiarRolDeUnUsuario()
    {
        USUARIO.setId(1L);
        givenUsuarioConRol(USUARIO);
        whenCambiaRol(USUARIO);
        thenSeCambioRolUsuario(USUARIO, "Jugador");
    }
    private void givenUsuarioConRol(Usuario usuario)
    {
        when(repositorioUsuario.buscarUsuarioPorId(usuario.getId())).thenReturn(USUARIO);
    }

    private void whenCambiaRol(Usuario usuario)
    {
        servicioUsuario.cambiarRolUsuario(usuario.getId());
    }

    private void thenSeCambioRolUsuario(Usuario usuario, String rol)
    {
        assertEquals(usuario.getRol(),rol);
    }

    @Test
    public void jugadorSancionado()
    {
        USUARIOSANCION.setId(1L);
        givenJugadorSinSancion(USUARIOSANCION);
        Usuario usuarioSancionado = whenJugadorSancionado(USUARIOSANCION);
        thenJugadorEstaSancionado(usuarioSancionado);
    }

    private void givenJugadorSinSancion(Usuario usuario)
    {
        when(repositorioUsuario.buscarUsuarioPorId(usuario.getId())).thenReturn(usuario);
        if(usuario.getFechaSancion() == null)
        {
            whenJugadorSancionado(usuario);
        }
    }

    private Usuario whenJugadorSancionado(Usuario usuario)
    {
        Date fechaSancion = new Date();
        usuario.setFechaSancion(fechaSancion);

        return usuario;
    }

    private void thenJugadorEstaSancionado(Usuario usuario)
    {
        assertTrue(servicioUsuario.jugadorEstaSancionado(usuario.getId()));
    }

}
