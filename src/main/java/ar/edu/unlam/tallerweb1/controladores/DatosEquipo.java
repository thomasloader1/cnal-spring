package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Equipo;

public class DatosEquipo {

    private String nombre;
    private String categoria;
    private Integer cantidadJugadores;
    private Integer tipoPartido;
    private Boolean habilitado;

    public DatosEquipo(){}

    public DatosEquipo(String nombre, int cantidadJugadores, int tipoPartido, String categoria) {
        this.nombre = nombre;
        this.cantidadJugadores = cantidadJugadores;
        this.tipoPartido = tipoPartido;
        this.categoria = categoria;
        this.habilitado = false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getCantidadJugadores() {
        return cantidadJugadores;
    }

    public void setCantidadJugadores(Integer cantidadJugadores) {
        this.cantidadJugadores = cantidadJugadores;
    }

    public Integer getTipoPartido() {
        return tipoPartido;
    }

    public void setTipoPartido(Integer tipoPartido) {
        this.tipoPartido = tipoPartido;
    }

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }

    public Equipo crearEquipo() {
        return new Equipo(this.getNombre(),this.getCantidadJugadores(),this.getTipoPartido(), this.getCategoria());
    }
}
