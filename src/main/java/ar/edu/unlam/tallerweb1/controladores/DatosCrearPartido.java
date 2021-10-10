package ar.edu.unlam.tallerweb1.controladores;

public class DatosCrearPartido {

    private int cant_jugadores;
    private String tipo;
    private String categoria;
    private String horario;


    public DatosCrearPartido() {
    }

    public DatosCrearPartido(int cant_jugadores, String tipo, String categoria, String horario) {
        this.cant_jugadores = cant_jugadores;
        this.tipo = tipo;
        this.categoria = categoria;
        this.horario = horario;
    }

    public int getCant_jugadores() {
        return cant_jugadores;
    }

    public void setCant_jugadores(int cant_jugadores) {
        this.cant_jugadores = cant_jugadores;
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


    public String losDatosIngresadosSonValidos(DatosCrearPartido datosPartido){
        String mensaje = "";
        if((validarCantidadJugadores(datosPartido)) && (validarCategoria(datosPartido)) && (validarTipoPartido(datosPartido))){
            mensaje = "exito";
        }
        else if(!(validarTipoPartido(datosPartido))){
            mensaje = "El tipo de partido ingresado es incorrecto.";
        }
        else if(!(validarCantidadJugadores(datosPartido))) {
            mensaje = "La cantidad de jugadores es inválida para el tipo de partido elegido";
        }
        else if(!(validarCategoria(datosPartido))){
            mensaje = "La categoría es incorrecta.";
        }

        return mensaje;
    }


    public boolean validarCantidadJugadores (DatosCrearPartido datosPartido){
        boolean esValido = false;

        if(datosPartido.getTipo().equals("5") && (datosPartido.getCant_jugadores()>=1 && datosPartido.getCant_jugadores()<=10)){
            esValido = true;
        }else if(datosPartido.getTipo().equals("11") && (datosPartido.getCant_jugadores()>=1 && datosPartido.getCant_jugadores()<=22)){
            esValido = true;
        }
        return esValido;
    }

    public boolean validarCategoria (DatosCrearPartido datosPartido){
        boolean esValido = false;
        if(datosPartido.getCategoria().toUpperCase().equals("INFANTIL") || datosPartido.getCategoria().toUpperCase().equals("JUVENIL") || datosPartido.getCategoria().toUpperCase().equals("ADULTO")){
            esValido = true;
        }
        return esValido;
    }

    public boolean validarTipoPartido(DatosCrearPartido datosPartido){
        boolean esValido = false;
        if(datosPartido.getTipo().equals("5") || datosPartido.getTipo().equals("11")){
            esValido = true;
        }
        return esValido;
    }




}