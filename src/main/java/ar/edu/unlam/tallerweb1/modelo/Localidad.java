package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Localidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;

    public Localidad(){}

    public Localidad(Long id, String descripcion){
        this.id = id;
        this.descripcion = descripcion;
    }

    public void setId(Long id){this.id = id;}

    public Long getId(){return id;}

    public void setDescripcion(String descripcion){this.descripcion = descripcion;}

    public String getDescripcion(){return descripcion;}
}
