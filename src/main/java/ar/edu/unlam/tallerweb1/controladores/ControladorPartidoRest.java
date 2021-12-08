package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.servicios.ServicioPartido;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import flexjson.JSONSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.*;


@RestController
public class ControladorPartidoRest {
        private ServicioPartido servicioPartido;
        @Autowired
        public ControladorPartidoRest(ServicioPartido servicioPartido){
            this.servicioPartido = servicioPartido;
        }

        @RequestMapping(value = "/partidos", method = RequestMethod.GET, produces="application/json")
        @ResponseBody
        public List<EventoPartido> getPartidos() throws JsonProcessingException {
           List<Partido> partidos = servicioPartido.todosLosPartidos();

            List<EventoPartido> eventos = new ArrayList<>();

            for(Partido p : partidos){

                EventoPartido ep = new EventoPartido(p.getId(),p.getLocalidad(), p.getFechaPartido(),p);
                eventos.add(ep);
            }

            return eventos;
           // return eventos;

        }
}
