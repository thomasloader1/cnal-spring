package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("sevicioUsuario")
@Transactional
public class ServicioUsuarioImpl implements ServicioUsuario
{
    private RepositorioUsuario repositorioUsuario;

    @Autowired
    public ServicioUsuarioImpl(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
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

}
