package ar.edu.unlam.tallerweb1.repositorios;


import ar.edu.unlam.tallerweb1.modelo.Partido;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("repositorioPartido")
public class RepositorioPartidoImpl implements RepositorioPartido{

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioPartidoImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void crearPartido(Partido partido) {
        final Session session = sessionFactory.getCurrentSession();
        session.save(partido);
    }

    @Override
    public void buscarPartido(Long id, String tipo) {

    }
}
