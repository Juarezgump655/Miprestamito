package com.desa.miprestamito.servicio;

import com.desa.miprestamito.Projections.CorrelativoProjection;
import com.desa.miprestamito.Projections.TableReportesProjection;
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


    public List<String> findEmails(Long id);


}
