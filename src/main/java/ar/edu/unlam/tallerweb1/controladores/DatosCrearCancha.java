package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Cancha;

public class DatosCrearCancha {
    private String nombre;
    private String localidad;
    private String domicilio;
    private Double precio;
    private Boolean bar;
    private Integer cant_canchas;

    public DatosCrearCancha() {}

    public DatosCrearCancha(String nombre, String localidad, String domicilio,Double precio, Boolean bar, Integer cant_canchas) {
        this.nombre = nombre;
        this.localidad = localidad;
        this.domicilio = domicilio;
        this.precio = precio;
        this.bar = bar;
        this.cant_canchas = cant_canchas;
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

    public Double getPrecio() {return precio;}

    public void setPrecio(Double precio) {this.precio = precio;}

    public Boolean getBar() {return bar;}

    public void setBar(Boolean bar) {this.bar = bar;}

    public Integer getCant_canchas() {return cant_canchas;}

    public void setCant_canchas(Integer cant_canchas) {this.cant_canchas = cant_canchas;}

    public Cancha crearCancha(){
        return new Cancha(this.getNombre(), this.getLocalidad(), this.getDomicilio(), this.getPrecio(), this.getBar(), this.getCant_canchas());
    }
}
