package ar.edu.unlam.tallerweb1.modelo;

import java.util.List;

public class Equipo {

    private String nombre;
    private int cantidadJugadores;
    private List<Usuario> jugadores;

    public List<Usuario> getJugadores() {
        return jugadores;
    }

    public void setJugadores(Usuario jugador) {
        this.jugadores.add(jugador);
    }

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
}
