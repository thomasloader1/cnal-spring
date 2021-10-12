package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Partido;
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
    public Partido buscar(String hora, String categoria) {
        return (Partido) sessionFactory.getCurrentSession().createCriteria(Partido.class)
                .add(Restrictions.eq("hora", hora))
                .add(Restrictions.eq("categoria", categoria))
                .uniqueResult();
    }
    //asd
    @Override
    public void guardar(Partido partido) {
        sessionFactory.getCurrentSession().save(partido);
    }

    @Override
    public void unirmeAlPartido(Partido partido) {
        Partido partidoActualizado = this.sessionFactory.getCurrentSession().load(Partido.class, partido.getId());
        partidoActualizado.setCant_jugadores(partido.getCant_jugadores() + 1);
        this.sessionFactory.getCurrentSession().update(partidoActualizado);
    }

    @Override
    public List<Partido> partidos() {
        final Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Partido.class).list();
    }

    @Override
    public List<Partido> partidosFiltrados(String localidad, String categoria){

        if(localidad != null || localidad != "" && categoria == null || categoria == "") {
            return (List<Partido>) sessionFactory.getCurrentSession().createCriteria(Partido.class)
                    .add(Restrictions.eq("localidad", localidad))
                    .uniqueResult();
        }
        else if(localidad == null || localidad == "" && categoria != null || categoria != ""){
            return (List<Partido>) sessionFactory.getCurrentSession().createCriteria(Partido.class)
                    .add(Restrictions.eq("categoria", categoria))
                    .uniqueResult();
        }
        else if(localidad != null || localidad != "" && categoria != null || categoria != "") {
            return (List<Partido>) sessionFactory.getCurrentSession().createCriteria(Partido.class)
                    .add(Restrictions.eq("localidad", localidad))
                    .add(Restrictions.eq("categoria", categoria))
                    .uniqueResult();
        }
        return null;
    }
}

