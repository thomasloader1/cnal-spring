package ar.edu.unlam.tallerweb1.modelo;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Partido {

    // La anotacion id indica que este atributo es el utilizado como clave primaria de la entity, se indica que el valor es autogenerado.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int cant_jugadores;
    private String tipo;
    private String categoria;
    private Boolean completo = false;
    private String horario;


    public Partido() {

    }

    public Partido(Long id, int cant_jugadores, String tipo, String categoria, String horario) {
        this.id = id;
        this.cant_jugadores = cant_jugadores;
        this.tipo = tipo;
        this.categoria = categoria;
        this.completo = this.getCompleto();
        this.horario = horario;

    }



    public Long getId() {
        return id;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCant_jugadores() {
        return cant_jugadores;
    }

    public void setCant_jugadores(int cant_jugadores) {
        this.cant_jugadores = cant_jugadores;
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

    public Boolean getCompleto() {
        return completo;
    }

    public void setCompleto(Boolean completo) {
        this.completo = completo;
    }
}
