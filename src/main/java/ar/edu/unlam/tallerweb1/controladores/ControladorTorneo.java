package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Equipo;
import ar.edu.unlam.tallerweb1.modelo.PartidoTorneo;
import ar.edu.unlam.tallerweb1.modelo.Torneo;
import ar.edu.unlam.tallerweb1.servicios.ExceptionYaExiste;
import ar.edu.unlam.tallerweb1.servicios.ServicioLocalidad;
import ar.edu.unlam.tallerweb1.servicios.ServicioTorneo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ControladorTorneo {

    private ServicioTorneo servicioTorneo;
    private ServicioLocalidad servicioLocalidad;

    @Autowired
    public ControladorTorneo(ServicioTorneo servicioTorneo, ServicioLocalidad servicioLocalidad){
        this.servicioTorneo= servicioTorneo;
        this.servicioLocalidad = servicioLocalidad;
    }

    @RequestMapping(path = "/registro-torneo", method = RequestMethod.GET)
    public ModelAndView irARegistroTorneo(){
        return new ModelAndView("registro-torneo");
    }

    @RequestMapping(method= RequestMethod.POST, path = "/registrar-torneo")
    public ModelAndView registrarTorneo(@ModelAttribute("torneo-nuevo") DatosTorneo datosTorneo) throws ExceptionYaExiste {
        ModelMap model= new ModelMap();
        if(datosTorneo.losDatosIngresadosSonValidos(datosTorneo).equals("exito")){
            model.put("msg", "El torneo se creo con éxito");
            model.put("torneo", datosTorneo);
            model.put("LOCALIDAD", servicioLocalidad.todasLasLocalidades());
            servicioTorneo.registrarTorneo(datosTorneo.crearTorneo());
            return new ModelAndView("torneo-registrado", model);
        }else {
            model.put("msg", datosTorneo.losDatosIngresadosSonValidos(datosTorneo));
            return new ModelAndView("registro-torneo", model);
        }
    }


    @RequestMapping(path = "/unirme-a-torneo", method = RequestMethod.GET)
    public ModelAndView irAUnirseATorneo(){
        ModelMap model= new ModelMap();
        model.put("torneos", servicioTorneo.todosLosTorneos());
        return new ModelAndView("unirme-a-torneo", model);
    }

    @RequestMapping(path = "/unirse-a-torneo/{idTorneo}", method = RequestMethod.GET)
    public ModelAndView unirmeAUnTorneo(@ModelAttribute("unirse-a-torneo") @PathVariable Long idTorneo, HttpServletRequest request) throws Exception {
        Long idUsuario = (Long) request.getSession().getAttribute("ID");
        ModelMap modelMap = new ModelMap();
        ModelAndView modelAndView;

        if (servicioTorneo.registrarEnTorneo(idTorneo, idUsuario)) {
            modelAndView = new ModelAndView("union-torneo", modelMap);
        } else {
            modelMap.put("error", "el torneo ya esta completo");
            modelAndView = new ModelAndView("unirme-a-torneo", modelMap);
        }
        return modelAndView;
    }

    @RequestMapping(path = "/torneos-crear-fixture", method = RequestMethod.GET)
    public ModelAndView irACrearFixture(){
        return new ModelAndView("redirect:/listar-torneos-equipos");
    }


    @RequestMapping(path = "listar-torneos-equipos", method = RequestMethod.GET)
    public ModelAndView listarTorneosConEquipos(){
        ModelMap model = new ModelMap();
        model.put("TORNEOSEQUIPOS", servicioTorneo.todosLosTorneos());

        return new ModelAndView("torneos-registrados-fixture", model);

    }


    @RequestMapping(path = "/crear-fixture/{idTorneo}", method = RequestMethod.POST)
    public ModelAndView generarCruceDeEquipos(@ModelAttribute("crear-fixture") @PathVariable Long idTorneo) {
        ModelAndView modeloVista = null;
        ModelMap model = new ModelMap();

        try {
            if(!servicioTorneo.partidosExisten(idTorneo)){
                if(servicioTorneo.generarCruceDeEquiposDeUnTorneo(idTorneo)!=null){
                    Torneo torneo = servicioTorneo.buscarTorneoPorId(idTorneo);
                    List<PartidoTorneo> partidosDelTorneo = servicioTorneo.buscarLosPartidosDeUnTorneo(torneo);
                    model.put("PARTIDOSTORNEO", partidosDelTorneo);
                    model.put("TORNEO", torneo);

                    modeloVista = new ModelAndView("fixture-generado", model);
                }
                else{
                    model.put("error", "El torneo está incompleto. No se puede generar el fixture");
                    modeloVista = new ModelAndView("torneos-registrados-fixture", model);
                }
            }
            else{
                model.put("error", "El fixture ya esta creado");
                modeloVista = new ModelAndView("torneos-registrados-fixture", model);
            }
        }catch (Exception e){
            model.put("error", "Ha ocurrido un error. Volver a intertar");
            modeloVista = new ModelAndView("torneos-registrados-fixture", model);
        }
        return modeloVista;
    }


    @RequestMapping(path = "/ver-fixture/{idTorneo}", method = RequestMethod.POST)
    public ModelAndView mostrarFixture(@ModelAttribute("ver-fixture") @PathVariable Long idTorneo) {
        ModelMap model = new ModelMap();
        Torneo torneo = servicioTorneo.buscarTorneoPorId(idTorneo);
        List<PartidoTorneo> partidosJugados = servicioTorneo.buscarLosPartidosJugados(torneo);


        if(partidosJugados.size()==3 && torneo.getCantidadEquipos().equals("4")){
            List<PartidoTorneo> semifinales = servicioTorneo.buscarPartidosSemifinalesDeUnTorneo(torneo);
            PartidoTorneo partidoFinal = servicioTorneo.buscarPartidoFinalDeUnTorneo(torneo);
            model.put("PARTIDOS", partidosJugados);
            model.put("SEMIFINAL", semifinales);
            model.put("FINAL", partidoFinal);
            model.put("TORNEO", torneo);
            return new ModelAndView("fixture-completo", model);
        }
        else if(partidosJugados.size()==7){
            List<PartidoTorneo> cuartosDeFinales = servicioTorneo.buscarLosPartidosCuartosDeFinal(torneo);
            List<PartidoTorneo> semifinales = servicioTorneo.buscarPartidosSemifinalesDeUnTorneo(torneo);
            PartidoTorneo partidoFinal = servicioTorneo.buscarPartidoFinalDeUnTorneo(torneo);

            model.put("PARTIDOS", partidosJugados);
            model.put("CUARTOSDEFINAL", cuartosDeFinales);
            model.put("SEMIFINAL", semifinales);
            model.put("FINAL", partidoFinal);
            model.put("TORNEO", torneo);
            return new ModelAndView("fixture-completo", model);
        }

        model.put("PARTIDOSJUGADOS", partidosJugados);
        model.put("PARTIDOSTORNEO", servicioTorneo.buscarLosPartidosDeUnTorneo(torneo));
        model.put("TORNEO", torneo);

       return new ModelAndView("fixture-generado", model);
    }


    @RequestMapping(path = "equipo-ganador/{idPartido}", method = RequestMethod.POST)
    public ModelAndView guardarEquipoGanadorDelPartido(@ModelAttribute("equipo-ganador") @RequestParam("equipoGanador") String equipo, @PathVariable Long idPartido) {
        ModelMap model = new ModelMap();
        PartidoTorneo partido = servicioTorneo.buscarPartidoPorID(idPartido);

        Equipo equipoGanador;
        if (partido.getEquipoUno().getNombre().equals(equipo)){
            equipoGanador = partido.getEquipoUno();
        }
        else{
            equipoGanador = partido.getEquipoDos();
        }
        servicioTorneo.guardarEquipoGanador(equipoGanador, partido);


        model.put("EQUIPO", equipoGanador);
        model.put("nombreEquipo", equipoGanador.getNombre().substring(0, Math.min(14, equipoGanador.getNombre().length())));
        model.put("TORNEO", partido.getTorneo());
        model.put("PARTIDOFINAL", partido);

        if(partido.getFase().equals("Final")){
            return new ModelAndView("campeon-del-torneo", model);
        }
        else{
            return new ModelAndView("equipo-ganador", model);
        }

    }


    @RequestMapping(path = "crear-partido-final/{idTorneo}", method = RequestMethod.POST)
    public ModelAndView crearNuevoPartidoTorneo(@ModelAttribute("partido-final") @PathVariable Long idTorneo){
        ModelMap model = new ModelMap();
        ModelAndView modeloVista = null;

        Torneo torneo = servicioTorneo.buscarTorneoPorId(idTorneo);
        List<PartidoTorneo> partidos = servicioTorneo.buscarLosPartidosDeUnTorneo(torneo);

        if(servicioTorneo.fueronJugadosPartidos(partidos, "Semifinal")){
            servicioTorneo.crearNuevoPartidoParaElTorneo(partidos, "Final", torneo);
            PartidoTorneo partidoFinal = servicioTorneo.buscarPartidoFinalDeUnTorneo(torneo);

            model.put("PARTIDOFINAL", partidoFinal);
            model.put("TORNEO", torneo);
            modeloVista = new ModelAndView("la-final", model);
        }
        else{
            model.put("error", "Aún faltan partidos por jugar");
            modeloVista = new ModelAndView("fixture-generado", model);
        }
        return modeloVista;
    }

    @RequestMapping(path = "/ver-partido-final/{idTorneo}", method = RequestMethod.POST)
    public ModelAndView verFinal(@ModelAttribute("final") @PathVariable Long idTorneo) {
        ModelMap model = new ModelMap();
        Torneo torneo = servicioTorneo.buscarTorneoPorId(idTorneo);
        PartidoTorneo partidoFinal = servicioTorneo.buscarPartidoFinalDeUnTorneo(torneo);
        model.put("PARTIDOFINAL", partidoFinal);
        model.put("TORNEO", torneo);
        return new ModelAndView("la-final", model);
    }

    @RequestMapping(path = "crear-partidos-semifinal/{idTorneo}", method = RequestMethod.POST)
    public ModelAndView crearSemifinal(@ModelAttribute("partidos-semifinal") @PathVariable Long idTorneo){
        ModelMap model = new ModelMap();
        ModelAndView modeloVista = null;

        Torneo torneo = servicioTorneo.buscarTorneoPorId(idTorneo);
        List<PartidoTorneo> partidos = servicioTorneo.buscarLosPartidosDeUnTorneo(torneo);

        if(servicioTorneo.fueronJugadosPartidos(partidos, "Cuartos de Final")){
            servicioTorneo.crearNuevoPartidoParaElTorneo(partidos, "Semifinal", torneo);

            List<PartidoTorneo> partidosSemifinal = servicioTorneo.buscarPartidosSemifinalesDeUnTorneo(torneo);
            model.put("PARTIDOSSEMIFINAL", partidosSemifinal);
            model.put("PARTIDOSTORNEO", partidos);
            model.put("TORNEO", torneo);
            modeloVista = new ModelAndView("semifinal", model);
        }
        else{
            model.put("error", "Aún faltan partidos por jugar");
            modeloVista = new ModelAndView("semifinal", model);
        }
        return modeloVista;
    }

    @RequestMapping(path = "/ver-semifinal/{idTorneo}", method = RequestMethod.POST)
    public ModelAndView verSemifinal(@ModelAttribute("semifinal") @PathVariable Long idTorneo) {
        ModelMap model = new ModelMap();
        Torneo torneo = servicioTorneo.buscarTorneoPorId(idTorneo);
        List<PartidoTorneo> partidosSemifinal = servicioTorneo.buscarPartidosSemifinalesDeUnTorneo(torneo);
        List<PartidoTorneo> partidos = servicioTorneo.buscarLosPartidosDeUnTorneo(torneo);

        model.put("PARTIDOSTORNEO", partidos);
        model.put("PARTIDOSSEMIFINAL", partidosSemifinal);
        model.put("TORNEO", torneo);
        return new ModelAndView("semifinal", model);
    }


    @RequestMapping(path = "/fixture-completo/{idTorneo}", method = RequestMethod.POST)
    public ModelAndView verFixtureCompleto(@ModelAttribute("fixture-completo") @PathVariable Long idTorneo) {
        ModelMap model = new ModelMap();

        Torneo torneo = servicioTorneo.buscarTorneoPorId(idTorneo);
        List<PartidoTorneo> partidos = servicioTorneo.buscarLosPartidosDeUnTorneo(torneo);

        List<PartidoTorneo> cuartosDeFinales = new ArrayList<>();
        List<PartidoTorneo> semifinales = new ArrayList<>();
        PartidoTorneo partidoFinal = null;

        if(partidos.size()==3){
            for (PartidoTorneo partido:partidos) {
                if(partido.getFase().equals("Semifinal")){
                    semifinales.add(partido);
                }
                else if(partido.getFase().equals("Final")){
                    partidoFinal = partido;
                }
            }
        }
        else if(partidos.size()==7){
            for (PartidoTorneo partido:partidos) {
                if(partido.getFase().equals("Cuartos de Final")){
                    cuartosDeFinales.add(partido);
                }
                else if(partido.getFase().equals("Semifinal")){
                    semifinales.add(partido);
                }
                else{
                    partidoFinal = partido;
                }
            }
        }
        model.put("PARTIDOS", partidos);
        model.put("CUARTOSDEFINAL", cuartosDeFinales);
        model.put("SEMIFINAL", semifinales);
        model.put("FINAL", partidoFinal);
        model.put("TORNEO", torneo);
        return new ModelAndView("fixture-completo", model);
    }
}
