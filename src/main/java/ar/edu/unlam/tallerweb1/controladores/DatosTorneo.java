package ar.edu.unlam.tallerweb1.controladores;


import ar.edu.unlam.tallerweb1.modelo.Equipo;
import ar.edu.unlam.tallerweb1.modelo.Torneo;

import java.util.ArrayList;

public class DatosTorneo {

    private String nombre;
    private String tipo;
    private String categoria;
    private String cantidadEquipos;
    private String horario;
    private String fecha;
    private String localidad;
    private ArrayList<Equipo> equiposInscriptos;

    public DatosTorneo(){}

    public DatosTorneo(String tipo, String categoria, String cantidadEquipos, String fecha, String localidad, String nombre) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.categoria = categoria;
        this.cantidadEquipos = cantidadEquipos;
        this.fecha = fecha;
        this.localidad = localidad;
    }

    public String losDatosIngresadosSonValidos(DatosTorneo datosTorneo) {
        String msg= "";

        if((validarTipoTorneo(datosTorneo)) && (validarCategoria(datosTorneo)) && (validarCantidadEquipos(datosTorneo))){
            msg= "exito";
        } else if (!(validarTipoTorneo(datosTorneo))){
            msg = "El tipo de partido ingresado es incorrecto";
        } else if(!(validarCategoria(datosTorneo))){
            msg= "La cantidad de jugadores es invalida para el tipo de torneo elegido";
        } else if(!validarCantidadEquipos(datosTorneo)){
            msg= "la cantidad de equipos ingresada no es correcta";
        }
        return msg;
    }

    private boolean validarCantidadEquipos(DatosTorneo datosTorneo) {
        boolean esValido= false;

        if(("4").equals(datosTorneo.getCantidadEquipos()) || ("8").equals(datosTorneo.getCantidadEquipos())){
            esValido = true;
        }
        return esValido;
    }

    private boolean validarCategoria(DatosTorneo datosTorneo) {
        boolean esValido = false;
        if (datosTorneo.getCategoria().equalsIgnoreCase("INFANTIL") || datosTorneo.getCategoria().equalsIgnoreCase("JUVENIL") || datosTorneo.getCategoria().equalsIgnoreCase("ADULTO")) {
            esValido = true;
        }
        return esValido;
    }

    private boolean validarTipoTorneo(DatosTorneo datosTorneo) {
        boolean esValido = false;
        if (("5").equals(datosTorneo.getTipo()) || ("11").equals(datosTorneo.getTipo())) {
            esValido = true;
        }
        return esValido;
    }

    public Torneo crearTorneo() {
        return new Torneo(this.getTipo(), this.getCategoria(), this.getCantidadEquipos(), this.getHorario(), this.getFecha(), this.getLocalidad(), this.getNombre());
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getCantidadEquipos() {
        return cantidadEquipos;
    }

    public String getHorario(){
        return horario;
    }

    public String getFecha() {
        return fecha;
    }

    public String getLocalidad(){
        return localidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setCantidadEquipos(String cantidadEquipos) {
        this.cantidadEquipos = cantidadEquipos;
    }

    public void setHorario(String horario){
        this.horario = horario;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setLocalidad(String localidad){
        this.localidad = localidad;
    }

    public ArrayList<Equipo> getEquiposInscriptos(){
        return equiposInscriptos;
    }

    public void setEquiposInscriptos(ArrayList<Equipo> equipos){
        this.equiposInscriptos = equipos;
    }


}
