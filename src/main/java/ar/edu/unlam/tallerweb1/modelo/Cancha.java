package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
public class Cancha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String localidad;
    private String domicilio;

    @ManyToOne
    private Usuario usuario;

    public Cancha(){}

    public Cancha(String nombre, String localidad, String domicilio){
        this.nombre = nombre;
        this.localidad = localidad;
        this.domicilio = domicilio;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setLocalidad(String localidad){
        this.localidad = localidad;
    }

    public String getLocalidad(){
        return localidad;
    }

    public void setDomicilio(String domicilio){this.domicilio = domicilio;}

    public String getDomicilio(){return domicilio;}

    public Usuario getUsuario() {return usuario;}

    public void setUsuario(Usuario usuario) {this.usuario = usuario;}
}
