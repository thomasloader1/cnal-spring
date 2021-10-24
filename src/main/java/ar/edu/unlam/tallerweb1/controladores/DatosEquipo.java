package ar.edu.unlam.tallerweb1.controladores;

public class DatosEquipo {

    private String nombre;
    private int cantidadJugadores;
    private int tipoPartido;
    private boolean habilitado = false;


    public DatosEquipo(String nombre, int cantidadJugadores, int tipoPartido) {
        this.nombre = nombre;
        this.cantidadJugadores = cantidadJugadores;
        this.tipoPartido = tipoPartido;
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
