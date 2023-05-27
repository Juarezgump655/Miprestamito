package com.desa.miprestamito.servicio;

import com.desa.miprestamito.Projections.*;
import com.desa.miprestamito.modelo.Queja;

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
    public fichaQuejaProjection fichaQueja(Long idQueja);

    public List<TableReportesProjection> findByPuntoAtencion(Long puntoAtencion);

    public  List<TableReportesProjection> findByRegion( Long region);

    public List<TableQuejaSeguimientoProjection> findByPuntoAtencionAtendidas(Long idPuntoAtencion);
    public Queja asignarQueja(Long idQueja, Queja queja1);

    public List<String> findUsuariosPuntos(Long idPuntoAtencion);

    public List<String> findUsuariosPuntosNombres(Long idPuntoAtencion, String correo);

    public List<seguimientoTablaProjection> tablaSeguimientoQueja();

    public seguimientoTablaDetalleProjection tablaSeguimientoDetalleQueja(Long idQueja);

    public Queja seguimientoCentralizador(Long idQueja, Queja queja2);

    public Long findPuntoAsignado(Long idQueja);

}
