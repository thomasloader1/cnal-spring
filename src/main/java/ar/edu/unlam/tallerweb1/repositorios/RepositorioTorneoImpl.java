package ar.edu.unlam.tallerweb1.repositorios;


import ar.edu.unlam.tallerweb1.modelo.*;
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

    @Override
    public void actualizarTorneo(Torneo torneo) {
        this.sessionFactory.getCurrentSession().update(torneo);
    }

    @Override
    public void guardarTorneo(Torneo torneo) {
        sessionFactory.getCurrentSession().save(torneo);
    }

    @Override
    public List<EquipoTorneo> buscarEquiposDeUnTorneo(Long idTorneo) {
        final Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(EquipoTorneo.class)
                .add(Restrictions.eq("primaryOne", idTorneo))
                .list();
    }

    @Override
    public void actualizarPartidoTorneo(PartidoTorneo partido) {
        this.sessionFactory.getCurrentSession().update(partido);
    }

    @Override
    public void guardarPartidoTorneo(PartidoTorneo partido) {
        sessionFactory.getCurrentSession().save(partido);
    }

    @Override
    public List<PartidoTorneo> buscarLosPartidosDeUnTorneo(Torneo torneo) {
        final Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(PartidoTorneo.class)
                .add(Restrictions.eq("torneo", torneo))
                .list();
    }

    @Override
    public Torneo buscarTorneoPorId(Long idTorneo) {
        final Session session = sessionFactory.getCurrentSession();
        return (Torneo) session.createCriteria(Torneo.class)
                .add(Restrictions.eq("id", idTorneo))
                .uniqueResult();
    }
    @Override
    public void registrarEquipoEnTorneo(EquipoTorneo registro) {
        sessionFactory.getCurrentSession().save(registro);
    }

    @Override
    public List<PartidoTorneo> buscarLosPartidosDeTodosLosTorneos() {
        final Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(PartidoTorneo.class)
                .list();
    }

    @Override
    public Torneo buscarTorneoAlQuePerteneceUnPartido(PartidoTorneo partidoTorneo) {
        final Session session = sessionFactory.getCurrentSession();
        return (Torneo) session.createCriteria(Torneo.class)
                .add(Restrictions.eq("torneo", partidoTorneo.getTorneo()))
                .uniqueResult();
    }

    @Override
    public PartidoTorneo buscarPartidoPorID(Long idPartido) {
        final Session session = sessionFactory.getCurrentSession();
        return (PartidoTorneo) session.createCriteria(PartidoTorneo.class)
                .add(Restrictions.eq("id", idPartido))
                .uniqueResult();
    }
}
