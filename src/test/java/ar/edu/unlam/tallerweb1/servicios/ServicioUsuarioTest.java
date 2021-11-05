package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioReporte;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServicioUsuarioTest
{
    public static final Usuario USUARIO = new Usuario("asd@asd.com", "asd", "Admin" ,"","");
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




}
