package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Cancha;
import ar.edu.unlam.tallerweb1.modelo.Localidad;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repositorioLocalidad")
public class RepositorioLocalidadImpl implements RepositorioLocalidad{

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioLocalidadImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Localidad> todasLasLocalidades() {
        final Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Localidad.class).list();
    }
}
