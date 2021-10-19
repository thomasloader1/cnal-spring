package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

public class DatosRegistro {
    private String email;
    private String password;
    private String repeatPassword;

    public DatosRegistro(){}

    public DatosRegistro(String email, String clave, String repiteClave) {
        this.email = email;
        this.password = clave;
        this.repeatPassword = repiteClave;
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

    public Usuario crearUsuario() {
        return new Usuario(this.getEmail(),this.getPassword());
    }
}
