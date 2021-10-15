package ar.edu.unlam.tallerweb1.controladores;

public class DatosCrearCancha {
    private String nombre;
    private String localidad;
    private String domicilio;

    public DatosCrearCancha() {}

    public DatosCrearCancha(String nombre, String localidad, String domicilio) {
        this.nombre = nombre;
        this.localidad = localidad;
        this.domicilio = domicilio;
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
}
