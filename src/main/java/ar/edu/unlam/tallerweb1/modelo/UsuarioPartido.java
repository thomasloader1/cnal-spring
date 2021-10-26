package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
@IdClass(TimePk.class)
public class UsuarioPartido {

    @Id
    private Long idUsuario;

    @Id
    private Long idPartido;

    public UsuarioPartido(){}

    public UsuarioPartido(Long idUsuario, Long idPartido){
        this.idUsuario = idUsuario;
        this.idPartido = idPartido;
    }

    public void setIdUsuario(Long idUsuario){this.idUsuario = idUsuario;}

    public Long getIdUsuario(){return idUsuario;}

    public void setIdPartido(Long idPartido){this.idPartido = idPartido;}

    public Long getIdPartido(){return idPartido;}

}


