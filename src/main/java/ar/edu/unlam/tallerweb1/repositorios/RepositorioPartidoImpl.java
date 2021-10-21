package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Partido;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repositorioPartido")
public class RepositorioPartidoImpl implements RepositorioPartido{

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioPartidoImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Partido buscarPartido(String horario, String categoria) {
        return (Partido) sessionFactory.getCurrentSession().createCriteria(Partido.class)
                .add(Restrictions.eq("horario", horario))
                .add(Restrictions.eq("categoria", categoria))
                .uniqueResult();
    }

    @Override
    public void guardarPartido(Partido partido) {
        sessionFactory.getCurrentSession().save(partido);
    }

    @Override
    public void actualizar(Partido partido) {
        this.sessionFactory.getCurrentSession().update(partido);
    }

    @Override
    public List<Partido> todosLosPartidos() {
        final Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Partido.class).list();
    }

    @Override
    public List<Partido> partidosFiltrados(String localidad, String categoria){

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Partido.class);
        if(localidad != null){
            criteria.add(Restrictions.eq("localidad", localidad));
        }
        if(categoria!=null){
            criteria.add(Restrictions.eq("categoria", categoria));
        }
        return criteria.list();

    }

    @Override
    public Partido buscarPartidoPorID(Long id) {
        return (Partido) sessionFactory.getCurrentSession().createCriteria(Partido.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    /*@Override
    public void registrarUsuarioAPartido(UsuarioPartido usuarioPartido) {
        //sessionFactory.getCurrentSession().save(usuarioPartido);
    }*/
}

