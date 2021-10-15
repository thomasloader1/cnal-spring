package ar.edu.unlam.tallerweb1.repositorios;


import ar.edu.unlam.tallerweb1.modelo.Torneo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repositorioTorneo")
public class RepositorioTorneoImpl implements RepositorioTorneo{

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioTorneoImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Torneo> todosLosTorneos() {
        final Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Torneo.class).list();
    }

    @Override
    public Torneo buscarTorneo(Torneo torneo) {
      return (Torneo) sessionFactory.getCurrentSession().createCriteria(Torneo.class)
                .add(Restrictions.eq("id", torneo.getId()))
                .uniqueResult();
    }
}