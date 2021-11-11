package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.modelo.Equipo;

import ar.edu.unlam.tallerweb1.repositorios.RepositorioEquipo;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioTorneo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("servicioTorneo")
@Transactional
public class ServicioTorneoImpl implements ServicioTorneo{

    private RepositorioTorneo repositorioTorneo;
    private ServicioUsuario servicioUsuario;
    private RepositorioEquipo repositorioEquipo;

    @Autowired
    public ServicioTorneoImpl(RepositorioTorneo repositorioTorneo) {
        this.repositorioTorneo = repositorioTorneo;
    }

    @Override
    public List<Torneo> todosLosTorneos() {
        return repositorioTorneo.todosLosTorneos();
    }

    @Override
    public Torneo buscarTorneo(Torneo torneo){
        return repositorioTorneo.buscarTorneo(torneo);
    }

    @Override
    public void registrarTorneo(Torneo torneo) throws ExceptionYaExiste{
        if (repositorioTorneo.buscarTorneo(torneo) == null){
            repositorioTorneo.guardarTorneo(torneo);
        } else{
            throw new ExceptionYaExiste("el torneo ya existe");
        }
    }

    @Override
    public Boolean registrarEnTorneo(Long idTorneo, Long idUsuario) throws Exception{
        Boolean registroOk= false;

        Torneo torneoEncontrado = (Torneo) repositorioTorneo.buscarTorneoPorId(idTorneo);

        if(torneoEncontrado == null){
            throw new Exception();
        }

        if (hayLugaresDisponibles(torneoEncontrado)){
            List<Equipo> todosLosEquipos = repositorioEquipo.traerListaDeEquipos();
            List<Usuario> jugadores;

            for (int i= 0; i<todosLosEquipos.size(); i++){
                Equipo equipo = todosLosEquipos.get(i);
                jugadores = repositorioEquipo.buscarJugadoresDeUnEquipo(equipo);

                for (int j= 0; j<jugadores.size(); j++){
                    Usuario jugador = jugadores.get(j);
                    if (jugador.getId() == idUsuario){
                        unirEquipoAlTorneo(idTorneo, equipo);
                        registroOk=true;
                    }
                }
            }

        }
        return registroOk;
    }

    private void unirEquipoAlTorneo(Long idTorneo, Equipo equipo) {
        Torneo torneoEncontrado = (Torneo) repositorioTorneo.buscarTorneoPorId(idTorneo);
        torneoEncontrado.setCantidadEquipos(torneoEncontrado.getCantidadEquipos()+1);
        torneoEncontrado.getEquiposInscriptos().add(equipo);
        equipo.setTorneo(torneoEncontrado);
        repositorioTorneo.actualizarTorneo(torneoEncontrado);
    }

    public boolean hayLugaresDisponibles(Torneo torneo){

        boolean hayLugar = false;
        Integer cantEquiposInscriptos;
        try {
            cantEquiposInscriptos = torneo.getEquiposInscriptos().size();
        }catch (NullPointerException e){
            cantEquiposInscriptos = 0;
        }
        String cantEquipos = torneo.getCantidadEquipos();
        Integer equiposParaTorneo = Integer.parseInt(cantEquipos);

        if(equiposParaTorneo<cantEquiposInscriptos){
            hayLugar = true;
        }
        return hayLugar;
    }
    
    public Torneo buscarTorneoPorId(Long idTorneo) {
        return repositorioTorneo.buscarTorneoPorId(idTorneo);
    }

    @Override
    public List<PartidoTorneo> buscarLosPartidosDeUnTorneo(Torneo torneo) {
        return repositorioTorneo.buscarLosPartidosDeUnTorneo(torneo);
    }


    @Override
    public List<PartidoTorneo> generarCruceDeEquiposDeUnTorneo(Long idTorneo) {

        Torneo torneoBuscado = repositorioTorneo.buscarTorneoPorId(idTorneo);
        List<Equipo> equiposDelTorneo = repositorioTorneo.buscarEquiposDeUnTorneo(idTorneo);

        List<PartidoTorneo> partidosDelTorneo = null;
        if(torneoBuscado != null && torneoBuscado.getCantidadEquipos().equals(Integer.toString(equiposDelTorneo.size()))){

            partidosDelTorneo = crearPartidosParaElTorneo(equiposDelTorneo.size(), torneoBuscado);

            for (PartidoTorneo partido: partidosDelTorneo) {
                Equipo equipoSorteado;

                do{
                    equipoSorteado = sortearEquipo(equiposDelTorneo);
                }while(!equipoNoEstaAsignadoAUnPartido(equipoSorteado, partidosDelTorneo));

                partido.setEquipoUno(equipoSorteado);
                repositorioTorneo.actualizarPartidoTorneo(partido);

                do{
                    equipoSorteado = sortearEquipo(equiposDelTorneo);
                }while(!equipoNoEstaAsignadoAUnPartido(equipoSorteado, partidosDelTorneo));

                partido.setEquipoDos(equipoSorteado);
                repositorioTorneo.actualizarPartidoTorneo(partido);

            }
        }

        return partidosDelTorneo;
    }

    public Equipo sortearEquipo(List<Equipo> equipos){

        int numeroDeEquipoAleatorio = (int) (Math.random()* (equipos.size()));
        return equipos.get(numeroDeEquipoAleatorio);
    }


    //Verifica si el equipo que salió sorteado no fue agregado ya a un partido
    private boolean equipoNoEstaAsignadoAUnPartido(Equipo equipoSorteado, List<PartidoTorneo> partidosDelTorneo) {
        boolean noEstaEnUnPartido = true;

        for (PartidoTorneo partido: partidosDelTorneo) {
            if(partido.getEquipoUno()!=null && (partido.getEquipoUno().getId().equals(equipoSorteado.getId()))){
                noEstaEnUnPartido = false;
                break;
            }
            if(partido.getEquipoDos()!=null && (partido.getEquipoDos().getId().equals(equipoSorteado.getId()))){
                noEstaEnUnPartido = false;
                break;
            }
        }

        return noEstaEnUnPartido;
    }


    //Se instancia la cantidad de partidos necesarios según la cantidad de equipos que tiene el torneo
    public List<PartidoTorneo> crearPartidosParaElTorneo(int cantidadEquipos, Torneo torneo) {
        int cantidadDePartidosACrear = cantidadEquipos/2;

        List<PartidoTorneo> partidosCreados = new ArrayList<>();

        for (int i=0; i<cantidadDePartidosACrear; i++){
            PartidoTorneo partido = new PartidoTorneo();

            partido.setTorneo(torneo);
            repositorioTorneo.guardarPartidoTorneo(partido);

            partidosCreados.add(partido);
        }
        return partidosCreados;
    }
}
