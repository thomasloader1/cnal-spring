package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.modelo.ReporteUsuario;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
//import ar.edu.unlam.tallerweb1.modelo.UsuarioPartido;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioReporte;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Set;

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

        usuario.setFechaSancion(date.toString());

        repositorioUsuario.modificar(usuario);
    }

    @Override
    public Boolean usuarioSancionado(Long id) {

        Usuario usuario = repositorioUsuario.buscarUsuarioPorId(id);

        /*LocalDate fechaActual = LocalDate.now();

        LocalDate fechaSancion = LocalDate.parse(usuario.getFechaSancion());

        //TODO FALTA COMPARAR LA FECHA SETEADA DE SANCION CON LA FECHA ACTUAL PARA SABER SI EL USUARIO ESTA SANCIONADO AUN O NO
        //TODO VERIFICAR SI ESTA BIEN
        Long cantidadDeDias = ChronoUnit.DAYS.between(fechaSancion, fechaActual);

        if(cantidadDeDias <= 7){
            return true;
        }
        else{*/
            return false;
        //}
    }

    @Override
    public Boolean vincularUsuarioAPartido(Long idUsuario, Long idPartido) {
        return repositorioUsuario.unirseAPartido(idUsuario, idPartido);
    }

    @Override
    public Set<Partido> partidosDelUsuario(Long idUsuario) {
        return null;
    }

}
