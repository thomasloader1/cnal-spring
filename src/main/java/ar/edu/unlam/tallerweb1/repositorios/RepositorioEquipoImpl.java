package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Equipo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repositorioEquipo")
public class RepositorioEquipoImpl implements RepositorioEquipo{
    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioEquipoImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Equipo buscarEquipo(Long iDEquipo) {
        final Session session = sessionFactory.getCurrentSession();

        return (Equipo) session.createCriteria(Equipo.class)
                .add(Restrictions.eq("id", iDEquipo))
                .uniqueResult();
    }

    @Override
    public void actualizarEquipo(Equipo equipoBuscado) {
        this.sessionFactory.getCurrentSession().update(equipoBuscado);
    }


    @Override
    public void guardarEquipo(Equipo equipo) {
        sessionFactory.getCurrentSession().save(equipo);
    }


    @Override
    public List<Equipo> traerListaDeEquipos() {
        final Session session = sessionFactory.getCurrentSession();

        return session.createCriteria(Equipo.class).list();
    }
}
