package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Partido;

import java.util.Date;

public class DatosCrearPartido {

    private int cant_jugadores;
    private int cant_lugaresDisp;
    private String tipo;
    private String categoria;
    private String horario;
    private String localidad;
    private String direccion;
    private Date fechaPartido;


    public DatosCrearPartido() {}

    public DatosCrearPartido(int cant_jugadores, String tipo, String categoria, String horario, String localidad, String direccion, Date fechaPartido) {
        this.cant_jugadores = cant_jugadores;
        this.cant_lugaresDisp = 0;
        this.tipo = tipo;
        this.categoria = categoria;
        this.horario = horario;
        this.localidad = localidad;
        this.direccion = direccion;
        this.fechaPartido = fechaPartido;
    }

    public int getCant_jugadores() {
        return cant_jugadores;
    }

    public void setCant_jugadores(int cant_jugadores) {
        this.cant_jugadores = cant_jugadores;
    }

    public Integer getCant_lugaresDisp() {
        return this.cant_lugaresDisp;
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

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setDireccion(String direccion){this.direccion = direccion;}

    public String getDireccion(){return direccion;}

    public Date getFechaPartido() {return fechaPartido;}

    public void setFechaPartido(Date fechaPartido) {this.fechaPartido = fechaPartido;}

    public String losDatosIngresadosSonValidos(DatosCrearPartido datosPartido) {
        String mensaje = "";
        if ((validarCantidadJugadores(datosPartido)) && (validarCategoria(datosPartido)) && (validarTipoPartido(datosPartido))) {
            mensaje = "exito";
        } else if (!(validarTipoPartido(datosPartido))) {
            mensaje = "El tipo de partido ingresado es incorrecto.";
        } else if (!(validarCantidadJugadores(datosPartido))) {
            mensaje = "La cantidad de jugadores es inválida para el tipo de partido elegido";
        } else if (!(validarCategoria(datosPartido))) {
            mensaje = "La categoría es incorrecta.";
        }

        return mensaje;
    }

    public boolean validarCantidadJugadores(DatosCrearPartido datosPartido) {
        boolean esValido = false;

        if (datosPartido.getTipo().equals("5") && (datosPartido.getCant_jugadores() >= 1 && datosPartido.getCant_jugadores() <= 10)) {
            esValido = true;
        } else if (datosPartido.getTipo().equals("11") && (datosPartido.getCant_jugadores() >= 1 && datosPartido.getCant_jugadores() <= 22)) {
            esValido = true;
        }
        return esValido;
    }

    public boolean validarCategoria(DatosCrearPartido datosPartido) {
        boolean esValido = false;
        if (datosPartido.getCategoria().toUpperCase().equals("INFANTIL") || datosPartido.getCategoria().toUpperCase().equals("JUVENIL") || datosPartido.getCategoria().toUpperCase().equals("ADULTO")) {
            esValido = true;
        }
        return esValido;
    }

    public boolean validarTipoPartido(DatosCrearPartido datosPartido) {
        boolean esValido = false;
        if (datosPartido.getTipo().equals("5") || datosPartido.getTipo().equals("11")) {
            esValido = true;
        }
        return esValido;
    }

    public Partido crearPartido() {
        return new Partido(this.getCant_jugadores(), this.getCant_lugaresDisp(), this.getTipo(), this.getCategoria(), this.getHorario(), this.getLocalidad(), this.getDireccion(), this.getFechaPartido());
    }
}
