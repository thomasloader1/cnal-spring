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
    private Double precio;
    private Boolean bar;
    private Integer cant_canchas;

    @ManyToOne
    private Usuario usuario;

    public Cancha(){}

    public Cancha(String nombre, String localidad, String domicilio, Double precio, Boolean bar, Integer cant_canchas){
        this.nombre = nombre;
        this.localidad = localidad;
        this.domicilio = domicilio;
        this.precio = precio;
        this.bar = bar;
        this.cant_canchas = cant_canchas;
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

    public Double getPrecio() {return precio;}

    public void setPrecio(Double precio) {this.precio = precio;}

    public Boolean getBar() {return bar;}

    public void setBar(Boolean bar) {this.bar = bar;}

    public Integer getCant_canchas() {return cant_canchas;}

    public void setCant_canchas(Integer cant_canchas) {this.cant_canchas = cant_canchas;}
}
