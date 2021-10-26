package ar.edu.unlam.tallerweb1.modelo;

import java.io.Serializable;

public class TimePk implements Serializable {
    protected Long idUsuario;
    protected Long idPartido;

    public TimePk() {}

    public TimePk(Long idUsuario, Long idPartido) {
        this.idUsuario = idUsuario;
        this.idPartido = idPartido;
    }
    // equals, hashCode
}