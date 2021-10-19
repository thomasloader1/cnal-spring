package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Cancha;
import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCancha;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPartido;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.*;

public class ServicioCanchaTest {

    public static final Cancha CANCHA = new Cancha(1L,"Pekos", "Santa Maria 123","San Justo");
    private static final String SANJUSTO = "San Justo";
    private static final String CIUDADELA = "Ciudadela";

    private RepositorioCancha repositorioCancha = mock(RepositorioCancha.class);
    private ServicioCancha servicioCancha = new ServicioCanchaImpl(repositorioCancha);


    @Test
    public void puedoListarTodasLasCanchas(){
        givenListarCanchas();
        thenListarCanchas();
    }

    private void givenListarCanchas(){servicioCancha.todasLasCanchas();}
    private void thenListarCanchas() {verify(repositorioCancha,times(1)).todasLasCanchas();}





}
