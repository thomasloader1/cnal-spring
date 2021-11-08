package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
public class PartidoTorneo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Equipo equipoUno;

    @ManyToOne
    private Equipo equipoDos;

    @ManyToOne
    private Torneo torneo;


    public PartidoTorneo() {
    }

    public PartidoTorneo(Equipo equipoUno, Equipo equipoDos) {
        this.equipoUno = equipoUno;
        this.equipoDos = equipoDos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Equipo getEquipoUno() {
        return equipoUno;
    }

    public void setEquipoUno(Equipo equipoUno) {
        this.equipoUno = equipoUno;
    }

    public Equipo getEquipoDos() {
        return equipoDos;
    }

    public void setEquipoDos(Equipo equipoDos) {
        this.equipoDos = equipoDos;
    }

    public Torneo getTorneo() {
        return torneo;
    }

    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }
}
