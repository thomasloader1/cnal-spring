//package ar.edu.unlam.tallerweb1.servicios;
//
//import ar.edu.unlam.tallerweb1.modelo.Partido;
//import ar.edu.unlam.tallerweb1.repositorios.RepositorioPartido;
//import org.junit.Test;
//
//import static org.mockito.Mockito.*;
//
//public class ServicioUnirmeAPartidaTest {
//
//    public static final Partido PARTIDO = new Partido(1L,5,"11","Juvenil","18:00");
//    private RepositorioUnirmeAPartida repositorioUnirmeAPartida = mock(RepositorioUnirmeAPartida.class);
//    private ServicioUnirmeAPartida servicioUnirmeAPartida = new ServicioUnirmeAPartidaImpl(repositorioUnirmeAPartida);
//
//    @Test
//        void puedoUnirmeAPartida() throws Exception{
//        givenPartidaInexistente(PARTIDO);
//        whenUnirme(PARTIDO);
//        thenPartidoLleno();
//
//    }
//
//    private void givenPartidaInexistente(Partido partido){
//        when(RepositorioUnirmeAPartida.buscar(partido.getId())).thenThrow(Exception.class);
//    }
//
//    private void whenUnirme(Partido partido) throws Exception{
//        try{
//            servicioUnirmeAPartida.unirme(partido.getId());
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    private void thenPartidoLleno(){
//        verify(repositorioUnirmeAPartida, times(1)).lleno();
//    }
//}
