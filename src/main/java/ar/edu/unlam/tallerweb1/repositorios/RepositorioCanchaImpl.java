package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Cancha;
import ar.edu.unlam.tallerweb1.modelo.Partido;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repositorioCancha")
public class RepositorioCanchaImpl implements RepositorioCancha{

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioCanchaImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Cancha> todasLasCanchas() {
        final Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Cancha.class).list();
    }
}
