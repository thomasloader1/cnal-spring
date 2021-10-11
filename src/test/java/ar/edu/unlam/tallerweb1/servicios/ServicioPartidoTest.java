package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPartido;
import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.never;

public class ServicioPartidoTest {

    public static final Partido PARTIDO = new Partido(1L,5,"11","Juvenil","18:00");
    private RepositorioPartido repositorioPartido = mock(RepositorioPartido.class);
    private ServicioPartido servicioPartido = new ServicioPartidoImpl(repositorioPartido);


    @Test(expected = Exception.class)
    public void siRegistroConHoraOcupadaDaError() throws Exception {
        givenPartidoYaExiste(PARTIDO);
        whenResgistro(PARTIDO);
        thenElPartidoNoSeGuarda();
    }

    private void givenPartidoYaExiste(Partido partido) {
        try {
            when(repositorioPartido.buscar(partido.getHorario(), partido.getCategoria())).thenReturn(PARTIDO);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void whenResgistro(Partido partido)  throws Exception{
        try {
            servicioPartido.consultarPartido(partido.getHorario(), partido.getCategoria());
            servicioPartido.registrar(partido);

        } catch (Exception e) {
            throw new Exception();
        }
    }

    private void thenElPartidoNoSeGuarda() {
        verify(repositorioPartido, never()).guardar(any());
    }

    @Test
    public void puedoRegistrarUnPartido() throws Exception {
        PARTIDO.setId(2L);
        PARTIDO.setHorario("20:00");
        givenPartidoNoExiste(PARTIDO);
        whenResgistroPartido(PARTIDO);
        thenElPartidoSeGuarda();
    }

    private void givenPartidoNoExiste(Partido partido) {
        try {
            when(repositorioPartido.buscar(partido.getHorario(), partido.getCategoria())).thenReturn(PARTIDO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void whenResgistroPartido(Partido partido) throws Exception {
        try {
            servicioPartido.registrar(partido);

        } catch (Exception e) {
            throw new Exception("whenResgistroPartidoException");
        }
    }

    private void thenElPartidoSeGuarda() {
        verify(repositorioPartido, times(1)).guardar(any());
    }
}
