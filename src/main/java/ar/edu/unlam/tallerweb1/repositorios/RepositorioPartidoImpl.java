package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.modelo.UsuarioPartido;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Locale;

@Repository("repositorioPartido")
public class RepositorioPartidoImpl implements RepositorioPartido{

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioPartidoImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Partido buscarPartido(String hora, String categoria) {
        return (Partido) sessionFactory.getCurrentSession().createCriteria(Partido.class)
                .add(Restrictions.eq("hora", hora))
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
        if(!localidad.toLowerCase(Locale.ROOT).equals("localidad")){
            criteria.add(Restrictions.eq("localidad", localidad));
        }
        if(!categoria.toLowerCase(Locale.ROOT).equals("categoria")){
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

    @Override
    public void registrarUsuarioAPartido(UsuarioPartido registro) {
        sessionFactory.getCurrentSession().save(registro);
    }

    @Override
    public UsuarioPartido buscarUsuarioPartido(Long idUsuario, Long idPartido) {
        return (UsuarioPartido) sessionFactory.getCurrentSession().createCriteria(UsuarioPartido.class)
                .add(Restrictions.eq("idUsuario", idUsuario))
                .add(Restrictions.eq("idPartido", idPartido))
                .uniqueResult();
    }


}

