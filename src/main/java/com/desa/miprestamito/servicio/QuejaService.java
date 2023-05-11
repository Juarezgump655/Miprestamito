package com.desa.miprestamito.servicio;

import com.desa.miprestamito.Projections.CorrelativoProjection;
import com.desa.miprestamito.Projections.TableReportesProjection;
import com.desa.miprestamito.Projections.tablaAsignacionQuejaProjection;
import com.desa.miprestamito.modelo.Queja;
import org.springframework.data.repository.query.Param;

import javax.persistence.Table;
import java.util.List;

public interface QuejaService {

    public Queja save(Queja queja);

    public Iterable<Queja> listarQuejas();

    public Queja listarId(Long id);

    public Iterable<Queja> listarQuejasIdTipoQueja(Long id);

    public Iterable<Queja> listarQuejasPorUsuario(String id);

    public List<TableReportesProjection> listarQuejasPorPuntoAtencion(Long id);

    public Iterable<Queja> listarQuejasPorEstado(Long estado);

    public CorrelativoProjection getCorrelativo(Long correlativo);

    public List<TableReportesProjection> listarQuejasFechas(String fechaInicio, String fechaFin);
    public List<String> findEmails(Long id);

    public List<tablaAsignacionQuejaProjection> tablaAsignacionQueja();

    public List<TableReportesProjection> findByCorrelativo(String correlativo);

    public List<TableReportesProjection> findByPuntoAtencion(Long puntoAtencion);

    public  List<TableReportesProjection> findByRegion( Long region);
}
