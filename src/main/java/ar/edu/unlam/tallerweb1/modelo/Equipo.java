package ar.edu.unlam.tallerweb1.modelo;

import java.util.List;

public class Equipo {

    private String nombre;
    private int cantidadJugadores;
    private int tipoPartido;
    private boolean habilitado = false;
    private List<Usuario> jugadores;

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
