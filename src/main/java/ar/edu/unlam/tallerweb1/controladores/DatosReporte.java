package ar.edu.unlam.tallerweb1.controladores;

public class DatosReporte {

    private String motivo;
    private String descripcion;

    public DatosReporte() {
    }

    public DatosReporte(String motivo, String descripcion) {
        this.motivo = motivo;
        this.descripcion = descripcion;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
