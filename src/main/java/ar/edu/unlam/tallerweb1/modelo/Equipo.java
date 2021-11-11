package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;

@Entity
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int cantidadJugadores;
    private int tipoPartido;
    private String categoria;
    private boolean habilitado = false;
    //private List<Usuario> jugadores;

    @ManyToOne
    private Torneo torneo;

    public Equipo() {
    }

    public Equipo(String nombre, int cantidadJugadores, int tipoPartido) {
        this.nombre = nombre;
        this.cantidadJugadores = cantidadJugadores;
        this.tipoPartido = tipoPartido;
    }

    public Equipo(String nombre, int cantidadJugadores, int tipoPartido, String categoria) {
        this.nombre = nombre;
        this.cantidadJugadores = cantidadJugadores;
        this.tipoPartido = tipoPartido;
        this.categoria = categoria;
    }

    public Equipo(String nombre, int tipoPartido, String categoria) {
        this.nombre = nombre;
        this.tipoPartido = tipoPartido;
        this.categoria = categoria;
    }

    public Torneo getTorneo(){
        return torneo;
    }

    public void setTorneo(Torneo torneo){
        this.torneo = torneo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTipoPartido() {
        return tipoPartido;
    }

    public void setTipoPartido(int tipoPartido) {
        this.tipoPartido = tipoPartido;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    /*public List<Usuario> getJugadores() {
        return jugadores;
    }

    public void setJugadores(Usuario jugador) {
        this.jugadores.add(jugador);
    }*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadJugadores() {
        return cantidadJugadores;
    }

    public void setCantidadJugadores(int cantidadJugadores) {
        this.cantidadJugadores = cantidadJugadores;
    }

    public void setCategoria(String categoria){this.categoria = categoria;}

    public String getCategoria(){return categoria;}
}
