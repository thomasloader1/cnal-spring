package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
@IdClass(TimePk.class)
public class UsuarioPartido {

    @Id
    private Long primaryOne;

    @Id
    private Long primaryTwo;

    public UsuarioPartido(){}

    public UsuarioPartido(Long primaryOne, Long primaryTwo){
        this.primaryOne = primaryOne;
        this.primaryTwo = primaryTwo;
    }

    public Long getPrimaryOne() {
        return primaryOne;
    }

    public void setPrimaryOne(Long primaryOne) {
        this.primaryOne = primaryOne;
    }

    public Long getPrimaryTwo() {
        return primaryTwo;
    }

    public void setPrimaryTwo(Long primaryTwo) {
        this.primaryTwo = primaryTwo;
    }
}


