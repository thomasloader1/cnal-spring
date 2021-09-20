package ar.edu.unlam.tallerweb1.repositorios;


import ar.edu.unlam.tallerweb1.modelo.Partido;
import org.hibernate.SessionFactory;

public class RepositorioPartidoImpl implements RepositorioPartido{

    private SessionFactory sessionFactory;

    public RepositorioPartidoImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void crearPartido(Partido partido) {

    }

    @Override
    public void buscarPartido(Long id, String tipo) {

    }
}
