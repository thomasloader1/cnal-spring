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
    private String horario;
    private String localidad;
    private String nombre;


    public Torneo() {}

    public Torneo(Long id, String tipo, String categoria, String horario, String localidad, String nombre) {
        this.id = id;
        this.tipo = tipo;
        this.categoria = categoria;
        this.horario = horario;
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

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
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
