package ar.edu.unlam.tallerweb1.modelo;

import java.io.Serializable;

public class TimePk implements Serializable {
    protected Long primaryOne;
    protected Long primaryTwo;

    public TimePk() {}

    public TimePk(Long primaryOne, Long primaryTwo) {
        this.primaryOne = primaryOne;
        this.primaryTwo = primaryTwo;
    }

    // equals, hashCode
}