package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Cancha;
import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCancha;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPartido;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.*;

public class ServicioCanchaTest {

    private RepositorioCancha repositorioCancha = mock(RepositorioCancha.class);
    private RepositorioUsuario repositorioUsuario = mock(RepositorioUsuario.class);
    private ServicioCancha servicioCancha = new ServicioCanchaImpl(repositorioCancha,repositorioUsuario);


    @Test
    public void puedoListarTodasLasCanchas(){
        givenListarCanchas();
        thenListarCanchas();
    }

    private void givenListarCanchas(){servicioCancha.todasLasCanchas();}
    private void thenListarCanchas() {verify(repositorioCancha,times(1)).todasLasCanchas();}





}
