package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

public class DatosRegistro {
    private String email;
    private String password;
    private String repeatPassword;
    private String rol;
    private String nombre;
    private String apellido;
    public DatosRegistro(){}

    public DatosRegistro(String email, String clave, String repiteClave, String rol, String nombre, String apellido) {
        this.email = email;
        this.password = clave;
        this.repeatPassword = repiteClave;
        this.rol = rol;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public String getRol() { return rol; }

    public void setRol(String rol) { this.rol = rol; }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Usuario crearUsuario() {
        return new Usuario(this.getEmail(),this.getPassword(),this.getRol(),this.getNombre(), this.getApellido());
    }
}
