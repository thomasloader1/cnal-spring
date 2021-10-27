package ar.edu.unlam.tallerweb1.repositorios;


import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Equipo;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class RepositorioEquipoTest extends SpringTest {

    @Autowired
    private RepositorioEquipo repositorioEquipo;

    private static final Equipo EQUIPO = new Equipo();

    @Test
    @Rollback
    @Transactional
    public void obtenerLosJugadoresDeUnEquipo(){
        List<Usuario> jugadores = new LinkedList<>();
        jugadores.add(new Usuario());
        jugadores.add(new Usuario());
        jugadores.add(new Usuario());

        givenUnEquipoConJugadores(EQUIPO, jugadores);

        List<Usuario> jugadoresEncontrados = whenBuscoLosJugadoresDeEseEquipo(EQUIPO);

        thenObtengoLosJugadores(jugadores.size(), jugadoresEncontrados);

    }

    private void givenUnEquipoConJugadores(Equipo equipo, List<Usuario> jugadores) {
        session().save(equipo);

        for (Usuario jugador: jugadores) {
            jugador.setEquipo(equipo);
            session().save(jugador);
        }
    }

    private List<Usuario> whenBuscoLosJugadoresDeEseEquipo(Equipo equipo) {
        return repositorioEquipo.buscarJugadoresDeUnEquipo(equipo);
    }

    private void thenObtengoLosJugadores(int cantidadDeJugadores, List<Usuario> jugadoresEncontrados) {
        assertThat(jugadoresEncontrados).hasSize(cantidadDeJugadores);
    }

}
