package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPartido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("servicioCrearPartido")
@Transactional
public class ServicioCrearPartidoImpl implements ServicioCrearPartido {

    private RepositorioPartido repositorioPartidoImpl;

    @Autowired
    public ServicioCrearPartidoImpl(RepositorioPartido repositorioPartido) {
        this.repositorioPartidoImpl = repositorioPartido;
    }

    @Override
    public Partido registrar(Partido partido)  {
        Partido nuevo = new Partido(partido.getId(),partido.getCant_jugadores(),partido.getTipo(),partido.getCategoria(),partido.getHorario());
        repositorioPartidoImpl.guardar(nuevo);
        return nuevo;
    }

    @Override
    public Partido consultarPartido(String hora, String categoria) throws Exception {

        Partido buscado = repositorioPartidoImpl.buscar(hora, categoria);
        if(buscado != null)
            throw new Exception();
        return buscado;
    }

}