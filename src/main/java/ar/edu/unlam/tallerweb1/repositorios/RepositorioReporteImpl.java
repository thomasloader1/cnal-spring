package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Cancha;
import ar.edu.unlam.tallerweb1.modelo.ReporteUsuario;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repositorioReporte")
public class RepositorioReporteImpl implements RepositorioReporte{

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioReporteImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void enviarReporteUsuario(ReporteUsuario reporteUsuario) {
        sessionFactory.getCurrentSession().save(reporteUsuario);
    }

    @Override
    public List<ReporteUsuario> todosLosReportesPorUsuario(Long id) {
        final Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(ReporteUsuario.class).add(Restrictions.eq("idUsuario", id)).list();
    }

    @Override
    public ReporteUsuario buscarReportePorId(Long id) {
        final Session session = sessionFactory.getCurrentSession();
        return (ReporteUsuario) sessionFactory.getCurrentSession().createCriteria(ReporteUsuario.class)
                .add(Restrictions.eq("idReporte", id))
                .uniqueResult();
    }

    @Override
    public void aprobarReporte(ReporteUsuario reporteUsuario) {
        sessionFactory.getCurrentSession().update(reporteUsuario);
    }
}
