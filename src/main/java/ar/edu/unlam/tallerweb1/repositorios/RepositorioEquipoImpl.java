package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Equipo;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
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
        System.out.println ("holas");
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

    @Override
    public List<Usuario> buscarJugadoresDeUnEquipo(Equipo equipo) {
        final Session session = sessionFactory.getCurrentSession();

        return session.createCriteria(Usuario.class)
                .add(Restrictions.eq("equipo", equipo))
                .list();

    }

    @Override
    public void registrarJugadorEnElEquipo(Long usuario, Long idUsuario) {
        //sessionFactory.getCurrentSession().save();

    }

    @Override
    public Usuario buscarJugador(Long idUsuario) {
        final Session session = sessionFactory.getCurrentSession();

        return (Usuario) session.createCriteria(Usuario.class)
                .add(Restrictions.eq("id", idUsuario))
                .uniqueResult();
    }
}
