package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Equipo;
import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.modelo.PartidoTorneo;
import ar.edu.unlam.tallerweb1.modelo.Torneo;

import ar.edu.unlam.tallerweb1.repositorios.RepositorioTorneo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("servicioTorneo")
@Transactional
public class ServicioTorneoImpl implements ServicioTorneo{

    private RepositorioTorneo repositorioTorneoImpl;

    @Autowired
    public ServicioTorneoImpl(RepositorioTorneo repositorioTorneo) {
        this.repositorioTorneoImpl = repositorioTorneo;
    }

    @Override
    public List<Torneo> todosLosTorneos() {
        return repositorioTorneoImpl.todosLosTorneos();
    }

    @Override
    public Torneo buscarTorneo(Torneo torneo){
        return repositorioTorneoImpl.buscarTorneo(torneo);
    }

    @Override
    public void registrarTorneo(Torneo torneo) throws ExceptionYaExiste{
        if (repositorioTorneoImpl.buscarTorneo(torneo) == null){
            repositorioTorneoImpl.guardarTorneo(torneo);
        }
    }


    @Override
    public List<PartidoTorneo> generarCruceDeEquiposDeUnTorneo(Torneo torneo) {

        Torneo torneoBuscado = repositorioTorneoImpl.buscarTorneo(torneo);
        List<Equipo> equiposDelTorneo = repositorioTorneoImpl.buscarEquiposDeUnTorneo(torneo);

        List<PartidoTorneo> partidosDelTorneo = null;
        if(torneoBuscado != null && torneoBuscado.getCantidadEquipos().equals(Integer.toString(equiposDelTorneo.size()))){

            partidosDelTorneo = crearPartidosParaElTorneo(equiposDelTorneo.size());

            for (PartidoTorneo partido: partidosDelTorneo) {
                Equipo equipoSorteado;

                do{
                    equipoSorteado = sortearEquipo(equiposDelTorneo);
                }while(!equipoNoEstaAsignadoAUnPartido(equipoSorteado, partidosDelTorneo));

                partido.setEquipoUno(equipoSorteado);
                repositorioTorneoImpl.actualizarPartidoTorneo(partido);

                do{
                    equipoSorteado = sortearEquipo(equiposDelTorneo);
                }while(!equipoNoEstaAsignadoAUnPartido(equipoSorteado, partidosDelTorneo));

                partido.setEquipoDos(equipoSorteado);
                repositorioTorneoImpl.actualizarPartidoTorneo(partido);

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
    public List<PartidoTorneo> crearPartidosParaElTorneo(int cantidadEquipos) {
        int cantidadDePartidosACrear = cantidadEquipos/2;

        List<PartidoTorneo> partidosCreados = new ArrayList<>();

        for (int i=0; i<cantidadDePartidosACrear; i++){
            PartidoTorneo partido = new PartidoTorneo();

            repositorioTorneoImpl.guardarPartidoTorneo(partido);

            partidosCreados.add(partido);
        }
        return partidosCreados;
    }
}
