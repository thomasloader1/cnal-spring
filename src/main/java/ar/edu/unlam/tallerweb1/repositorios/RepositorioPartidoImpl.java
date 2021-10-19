package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Partido;
import org.hibernate.Criteria;
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
    public void unirmeAlPartido(Partido partido) {
        Partido partidoActualizado = buscarPartidoPorID(partido.getId());
        String tipo= partidoActualizado.getTipo();
        Integer jugadores = Integer.parseInt(tipo);
        Integer jugadores_totales = jugadores * 2;

        if (partidoActualizado.getCant_jugadores() < jugadores_totales){
            partidoActualizado.setCant_jugadores(partido.getCant_jugadores() + 1);
            partidoActualizado.setCant_lugaresDisp(partido.getCant_lugaresDisp() - 1);
        }
        this.sessionFactory.getCurrentSession().update(partidoActualizado);
    }

    @Override
    public List<Partido> todosLosPartidos() {
        final Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Partido.class).list();
    }

    @Override
    public List<Partido> partidosFiltrados(String localidad, String categoria){

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Partido.class);
        if(localidad != null){
            criteria.add(Restrictions.eq("localidad", localidad));
        }
        if(categoria!=null){
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

    /*@Override
    public void registrarUsuarioAPartido(UsuarioPartido usuarioPartido) {
        //sessionFactory.getCurrentSession().save(usuarioPartido);
    }*/
}

