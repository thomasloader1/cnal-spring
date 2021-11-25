package ar.edu.unlam.tallerweb1.modelo;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
public class Partido {

    // La anotacion id indica que este atributo es el utilizado como clave primaria de la entity, se indica que el valor es autogenerado.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int cant_jugadores;
    private Integer cant_lugaresDisp;
    private String tipo;
    private String categoria;
    private Boolean completo = false;
    private String horario;
    private String direccion;
    private String localidad;
    private String fechaPartido;

    @ManyToOne
    private Cancha cancha;

    public Partido() {}

    public Partido(int cant_jugadores, Integer lugares, String tipo, String categoria, String horario, String localidad, String direccion, String fechaPartido) {
        this.id = id;
        this.cant_jugadores = cant_jugadores;
        this.cant_lugaresDisp = lugares;
        this.tipo = tipo;
        this.categoria = categoria;
        this.completo = this.getCompleto();
        this.horario = horario;
        this.localidad = localidad;
        this.direccion = direccion;
        this.fechaPartido = fechaPartido;
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

    public Integer getCant_jugadores() {
        return this.cant_jugadores;
    }

    public void setCant_jugadores(Integer cant_jugadores) {
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

    public void setLocalidad(String localidad){this.localidad = localidad;}

    public String getLocalidad(){return localidad;}

    public Integer getCant_lugaresDisp() {
        return cant_lugaresDisp;
    }

    public void setCant_lugaresDisp(Integer cant_lugaresDisp) {
        this.cant_lugaresDisp = cant_lugaresDisp;
    }

    //TODO TIENE QUE TENER MISMA DIRECCION Y LOCALIDAD QUE LA CANCHA DONDE SE GENERA EL PARTIDO
    public void setDireccion(String direccion){this.direccion = direccion;}

    public String getDireccion(){return direccion;}

    public Cancha getCancha() {return cancha;}

    public void setCancha(Cancha cancha) {this.cancha = cancha;}

    public String getFechaPartido() {return fechaPartido;}

    public void setFechaPartido(String fechaPartido) {this.fechaPartido = fechaPartido;}
}
