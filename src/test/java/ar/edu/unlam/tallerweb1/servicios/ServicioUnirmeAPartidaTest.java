/*package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPartido;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPartidoImpl;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class ServicioUnirmeAPartidaTest {

    public static final Partido PARTIDO = new Partido(1L,5,"11","Juvenil","18:00");
    private RepositorioPartido repositorioUnirmeAPartida = mock(RepositorioPartido.class);
    private ServicioCrearPartido servicioUnirmeAPartida = new ServicioCrearPartidoImpl(repositorioUnirmeAPartida);


    @Test(expected= Exception.class)
        void puedoUnirmeAPartida() throws Exception{
        givenPartidaInexistente(PARTIDO);
        whenUnirme(PARTIDO);

    }

    private void givenPartidaInexistente(Partido partido) throws Exception{
        Mockito.when(RepositorioPartido.buscar(partido.getHorario(), partido.getCategoria())).thenThrow(Exception.class);
    }

    private void whenUnirme(Partido partido) throws Exception{

        servicioUnirmeAPartida.consultarPartido(partido.getHorario(), partido.getCategoria());

    }

}*/
