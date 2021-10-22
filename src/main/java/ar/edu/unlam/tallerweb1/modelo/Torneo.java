package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
public class Torneo {
    // La anotacion id indica que este atributo es el utilizado como clave primaria de la entity, se indica que el valor es autogenerado.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;
    private String categoria;
    private String cantidadEquipos;
    private String fecha;
    private String localidad;
    private String nombre;

    public Torneo() {}

    public Torneo(String tipo, String categoria, String cantidadEquipos, String fecha, String localidad, String nombre) {
        this.tipo = tipo;
        this.categoria = categoria;
        this.cantidadEquipos = cantidadEquipos;
        this.fecha = fecha;
        this.localidad = localidad;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCantidadEquipos() {
        return cantidadEquipos;
    }

    public void setCantidadEquipos(String cantidadEquipos) {
        this.cantidadEquipos = cantidadEquipos;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
