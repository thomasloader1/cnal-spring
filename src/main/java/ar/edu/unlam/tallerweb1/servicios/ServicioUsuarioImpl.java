package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.ReporteUsuario;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.UsuarioPartido;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioReporte;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
@Service("sevicioUsuario")
@Transactional
public class ServicioUsuarioImpl implements ServicioUsuario
{
    private RepositorioUsuario repositorioUsuario;

    private RepositorioReporte repositorioReporte;

    @Autowired
    public ServicioUsuarioImpl(RepositorioUsuario repositorioUsuario, RepositorioReporte repositorioReporte) {
        this.repositorioUsuario = repositorioUsuario;
        this.repositorioReporte = repositorioReporte;
    }

    @Override
    public List<Usuario> todosLosUsuarios()
    {
        return repositorioUsuario.todosLosUsuarios();
    }

    @Override
    public void cambiarRolUsuario(Long id)
    {
        Usuario usuario = repositorioUsuario.buscarUsuarioPorId(id);
            if(usuario.getRol().equals("Admin"))
            {
                usuario.setRol("Jugador");
            }else
            {
                usuario.setRol("Admin");
            }
        repositorioUsuario.modificar(usuario);
    }

    @Override
    public void eliminarUsuario(Long id) {
        Usuario usuario = repositorioUsuario.buscarUsuarioPorId(id);

        repositorioUsuario.eliminarUsuario(usuario);
    }

    @Override
    public List<Usuario> todosLosUsuariosPorPartido(Long idPartido){

        List<Usuario> usuarioPartidoList = repositorioUsuario.listarJugadoresPorPartido(idPartido);

        return usuarioPartidoList;
    }

    @Override
    public void enviarReporteUsuario(ReporteUsuario reporteUsuario) {
        repositorioReporte.enviarReporteUsuario(reporteUsuario);
    }

    @Override
    public List<ReporteUsuario> todosLosReportesPorUsuario(Long id) {
        List<ReporteUsuario> reporteUsuarioList = repositorioReporte.todosLosReportesPorUsuario(id);

        return  reporteUsuarioList;
    }

    @Override
    public void sancionarJugador(Long id) {

        Usuario usuario = repositorioUsuario.buscarUsuarioPorId(id);

        Date date = new Date ();

        usuario.setFechaSancion(date);

        repositorioUsuario.modificar(usuario);
    }

    @Override
    public Boolean jugadorEstaSancionado(Long id) {
        Usuario usuario = repositorioUsuario.buscarUsuarioPorId(id);

        Date fechaSancion = usuario.getFechaSancion();
        if(fechaSancion != null)
        {
            Date fechaActual = new Date();
            int miliSegundosPorDia = 86400000;
            int dias = (int) ((fechaActual.getTime()-fechaSancion.getTime()) / miliSegundosPorDia);

            if(dias <= 7 )
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public Usuario buscarUsuarioPorId(Long id) {
        return repositorioUsuario.buscarUsuarioPorId(id);
    }

    @Override
    public Usuario verPerfil(Long id){ return repositorioUsuario.verPerfil(id); }
}
