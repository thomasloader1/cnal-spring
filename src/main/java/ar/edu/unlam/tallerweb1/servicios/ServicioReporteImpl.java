package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.ReporteUsuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioReporte;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("sevicioReporte")
@Transactional
public class ServicioReporteImpl implements ServicioReporte{

    private RepositorioReporte repositorioReporte;

    @Autowired
    public ServicioReporteImpl(RepositorioReporte repositorioReporte) {
       this.repositorioReporte = repositorioReporte;
    }

    @Override
    public void aprobarReporte(Long id) {

        ReporteUsuario reporteUsuario = repositorioReporte.buscarReportePorId(id);

        reporteUsuario.setAprobado(true);

        repositorioReporte.aprobarReporte(reporteUsuario);
    }
}
