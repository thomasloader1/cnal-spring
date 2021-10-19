package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Cancha;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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


    @Override
    public List<Cancha> buscarCanchaPorLocalidad(String localidad) {
/*
<<<<<<< HEAD
*/

        final Session session = sessionFactory.getCurrentSession();

        return session.createCriteria(Cancha.class)
                .add(Restrictions.eq("localidad", localidad))
                .list();
/*
=======
        if(localidad!=null || localidad!=""){
            return (List<Cancha>) sessionFactory.getCurrentSession().createCriteria(Cancha.class)
                    .add(Restrictions.eq("localidad", localidad)).list();
        }
        return null;
>>>>>>> db59fbb7ea85785ee0836ab0ec283dca589c9e05
*/
    }


    @Override
    public void guardarCancha(Cancha cancha) {
        sessionFactory.getCurrentSession().save(cancha);
    }

    @Override
    public Cancha buscarCancha(String nombre, String domicilio) {
        return (Cancha) sessionFactory.getCurrentSession().createCriteria(Cancha.class)
                .add(Restrictions.eq("nombre", nombre))
                .add(Restrictions.eq("domicilio", domicilio))
                .uniqueResult();
    }
}
