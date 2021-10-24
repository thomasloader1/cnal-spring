package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Equipo;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("repositorioEquipo")
public class RepositorioEquipoImpl implements RepositorioEquipo{
    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioEquipoImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Equipo buscarEquipo(String nombreEquipo) {
        return null;
    }

    @Override
    public void actualizarEquipo(Equipo equipoBuscado) {

    }

    @Override
    public void guardarEquipo(Equipo equipo) {
        sessionFactory.getCurrentSession().save(equipo);
    }
}
