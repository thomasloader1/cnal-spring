package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.ReporteUsuario;

import java.util.List;

public interface RepositorioReporte {

    void enviarReporteUsuario(ReporteUsuario reporteUsuario);
    List<ReporteUsuario> todosLosReportesPorUsuario(Long id);
    ReporteUsuario buscarReportePorId(Long id);
    void aprobarReporte(ReporteUsuario reporteUsuario);
}
