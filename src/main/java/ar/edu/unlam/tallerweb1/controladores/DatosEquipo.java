package ar.edu.unlam.tallerweb1.controladores;

public class DatosEquipo {

    private String nombre;
    private int cantidadJugadores;


    public DatosEquipo(String nombre, int cantidadJugadores) {
        this.nombre = nombre;
        this.cantidadJugadores = cantidadJugadores;
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
