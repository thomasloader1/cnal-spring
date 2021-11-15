package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Cancha;

public class DatosCrearCancha {
    private String nombre;
    private String localidad;
    private String domicilio;
    private Long idUsuario;

    public DatosCrearCancha() {}

    public DatosCrearCancha(String nombre, String localidad, String domicilio, Long idUsuario) {
        this.nombre = nombre;
        this.localidad = localidad;
        this.domicilio = domicilio;
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public Cancha crearCancha(){
        return new Cancha(this.getNombre(), this.getLocalidad(), this.getDomicilio());
    }

    public Long getIdUsuario() {return idUsuario;}

    public void setIdUsuario(Long idUsuario) {this.idUsuario = idUsuario;}
}
