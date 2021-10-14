package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPartido;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPartidoImpl;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.web.servlet.ModelAndView;

import static org.mockito.Mockito.*;

public class ServicioUnirmeAPartidaTest {

    public static final Partido PARTIDO = new Partido(1L,5, 0,"11","Juvenil","18:00","San Justo");
    private RepositorioPartido repositorioPartido = mock(RepositorioPartido.class);
    private ServicioPartido servicioPartido = new ServicioPartidoImpl(repositorioPartido);


    @Test(expected= Exception.class)
    public void noPuedoUnirmeAPartida() throws Exception{
        givenPartidaInexistente(PARTIDO);
        whenUnirme(PARTIDO);

    }

    private void givenPartidaInexistente(Partido partido) throws Exception{
        Mockito.when(repositorioPartido.buscar(partido.getHorario(), partido.getCategoria())).thenThrow(Exception.class);

    }

    private void whenUnirme(Partido partido) throws Exception{
        servicioPartido.consultarPartido(partido.getHorario(), partido.getCategoria());
    }

    @Test
    public void unirmeAPartida() throws Exception {
        givenPartidaExiste(PARTIDO);
        ModelAndView mav= whenUnirmeAPartida(PARTIDO);
        thenUnionExitosa(mav, "se unió con exito");
    }
    private void givenPartidaExiste(Partido partido) {
        //Mockito.when(repositorioPartido.unirmeAlPartido(partido));
    }
    private void thenUnionExitosa(ModelAndView mav, String mensaje) {
    }

    private ModelAndView whenUnirmeAPartida(Partido partido) {
        servicioPartido.unirmeAlPartido(partido);
        return null;
    }


}
