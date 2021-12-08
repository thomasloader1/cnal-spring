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
    @Autowired
    private ServicioUsuario servicioUsuario;
    @Autowired
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
    public Boolean registrarEnTorneo(Long id, Long idUsuario) throws Exception{
        Boolean registroOk= false;

        Torneo torneoEncontrado = (Torneo) buscarTorneoPorId(id);

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
                        vincularJugadorAPartido(id, equipo.getId());
                        registroOk=true;
                    }
                }
            }

        }
        return registroOk;
    }

    private void unirEquipoAlTorneo(Long idTorneo, Equipo equipo) {
        Torneo torneoEncontrado = (Torneo) buscarTorneoPorId(idTorneo);
        torneoEncontrado.setCantidadEquipos(torneoEncontrado.getCantidadEquipos()+1);
        try {
            torneoEncontrado.getEquiposInscriptos().add(equipo);
        }catch (NullPointerException e){
            ArrayList<Equipo> equipoNuevo= new ArrayList<>();
            equipoNuevo.add(equipo);
            torneoEncontrado.setEquiposInscriptos(equipoNuevo);
        }
        equipo.setTorneo(torneoEncontrado);
        repositorioTorneo.actualizarTorneo(torneoEncontrado);
    }

    private void vincularJugadorAPartido(Long idUsuario, Long idEquipo){
        try {
            EquipoTorneo registro = new EquipoTorneo();

            registro.setPrimaryOne(idUsuario);

            registro.setPrimaryTwo(idEquipo);

            repositorioTorneo.registrarEquipoEnTorneo(registro);
        }
        catch (Exception e){
            throw e;
        }
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
        Integer cantEquiposDefinidos = Integer.parseInt(cantEquipos);

        if(cantEquiposInscriptos<cantEquiposDefinidos){
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

        Torneo torneoBuscado = buscarTorneoPorId(idTorneo);
        List<Equipo> equiposDelTorneo = obtenerListaDeEquiposDelTorneo(idTorneo);

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

            torneoBuscado.setFixtureCreado(true);
            repositorioTorneo.actualizarTorneo(torneoBuscado);
        }

        return partidosDelTorneo;
    }

    public List<Equipo> obtenerListaDeEquiposDelTorneo(Long idTorneo) {
        List<EquipoTorneo> equipoTorneoBuscados = repositorioTorneo.buscarEquiposDeUnTorneo(idTorneo);
        List<Equipo> equiposEncontrados = new ArrayList<>();

        Equipo equipoBuscado = null;
        for (EquipoTorneo equipoActual : equipoTorneoBuscados) {
            equipoBuscado = repositorioEquipo.buscarEquipo(equipoActual.getPrimaryTwo());
            equiposEncontrados.add(equipoBuscado);
        }
        return equiposEncontrados;
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

            if(cantidadDePartidosACrear == 4){
                partido.setFase("Cuartos de Final");
            }
            else{
                partido.setFase("Semifinal");
            }

            partido.setTorneo(torneo);
            repositorioTorneo.guardarPartidoTorneo(partido);

            partidosCreados.add(partido);
        }
        return partidosCreados;
    }

    @Override
    public boolean partidosExisten(Long idTorneo) {
        Torneo torneoBuscado = repositorioTorneo.buscarTorneoPorId(idTorneo);
        if(buscarLosPartidosDeUnTorneo(torneoBuscado).size()!=0){
            return true;
        }
        return false;
    }

    @Override
    public List<PartidoTorneo> buscarTodosLosPartidosDeLosTorneos() {
        return repositorioTorneo.buscarLosPartidosDeTodosLosTorneos();
    }

    @Override
    public void crearNuevoPartidoParaElTorneo(List<PartidoTorneo> partidos, String fase, Torneo torneo) {

        if(fase.equals("Final")){
            List<Equipo> equipos = new ArrayList<>();
            for (PartidoTorneo partido:partidos) {
                if(partido.getFase().equals("Semifinal")){
                    equipos.add(partido.getEquipoGanador());
                }
            }

            PartidoTorneo partido = new PartidoTorneo();
            partido.setEquipoUno(equipos.get(0));
            partido.setEquipoDos(equipos.get(1));
            partido.setFase(fase);
            partido.setTorneo(torneo);
            repositorioTorneo.guardarPartidoTorneo(partido);

        }
        else if(fase.equals("Semifinal")){
            List<Equipo> equipos = new ArrayList<>();
            for (PartidoTorneo partido:partidos) {
                if(partido.getFase().equals("Cuartos de Final")){
                    equipos.add(partido.getEquipoGanador());
                }
            }
            PartidoTorneo partidoUno = new PartidoTorneo();
            partidoUno.setEquipoUno(equipos.get(0));
            partidoUno.setEquipoDos(equipos.get(1));
            partidoUno.setFase(fase);
            partidoUno.setTorneo(torneo);
            repositorioTorneo.guardarPartidoTorneo(partidoUno);

            PartidoTorneo partidoDos = new PartidoTorneo();
            partidoDos.setEquipoUno(equipos.get(2));
            partidoDos.setEquipoDos(equipos.get(3));
            partidoDos.setFase(fase);
            partidoDos.setTorneo(torneo);
            repositorioTorneo.guardarPartidoTorneo(partidoDos);
        }
    }

    @Override
    public void guardarEquipoGanador(Equipo equipoGanador, PartidoTorneo partido) {
        partido.setEquipoGanador(equipoGanador);
        repositorioTorneo.actualizarPartidoTorneo(partido);
    }

    @Override
    public PartidoTorneo buscarPartidoPorID(Long idPartido) {
        return repositorioTorneo.buscarPartidoPorID(idPartido);
    }

    @Override
    public PartidoTorneo buscarPartidoFinalDeUnTorneo(Torneo torneo) {
        List<PartidoTorneo> partidos = repositorioTorneo.buscarLosPartidosDeUnTorneo(torneo);

        PartidoTorneo partidoBuscado = null;
        for (PartidoTorneo partido:partidos) {
            if(partido.getFase().equals("Final")){
                partidoBuscado = partido;
            }
        }
        return partidoBuscado;
    }

    @Override
    public boolean fueronJugadosPartidos(List<PartidoTorneo> partidos, String fase) {
        boolean todosFueronJugados = true;
        for (PartidoTorneo partido:partidos) {
            if(partido.getFase().equals(fase) && partido.getEquipoGanador()==null){
                todosFueronJugados = false;
            }
        }
        return todosFueronJugados;
    }

    @Override
    public List<PartidoTorneo> buscarPartidosSemifinalesDeUnTorneo(Torneo torneo) {
        List<PartidoTorneo> partidos = repositorioTorneo.buscarLosPartidosDeUnTorneo(torneo);

        List<PartidoTorneo> partidosSemifinales = new ArrayList<>();
        for (PartidoTorneo partido:partidos) {
            if(partido.getFase().equals("Semifinal")){
                partidosSemifinales.add(partido);
            }
        }

        return partidosSemifinales;
    }

    @Override
    public List<PartidoTorneo> buscarLosPartidosJugados(Torneo torneo) {
        List<PartidoTorneo> partidos = repositorioTorneo.buscarLosPartidosDeUnTorneo(torneo);

        List<PartidoTorneo> partidosJugados = new ArrayList<>();
        for (PartidoTorneo partido:partidos) {
            if(partido.getEquipoGanador()!=null){
                partidosJugados.add(partido);
            }
        }
        return partidosJugados;
    }

    @Override
    public List<PartidoTorneo> buscarLosPartidosCuartosDeFinal(Torneo torneo) {
        List<PartidoTorneo> partidos = repositorioTorneo.buscarLosPartidosDeUnTorneo(torneo);

        List<PartidoTorneo> cuartosDeFinal = new ArrayList<>();
        for (PartidoTorneo partido:partidos) {
            if(partido.getFase().equals("Cuartos de Final")){
                cuartosDeFinal.add(partido);
            }
        }
        return cuartosDeFinal;
    }


}
