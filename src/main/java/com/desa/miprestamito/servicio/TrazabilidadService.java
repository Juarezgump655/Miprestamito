package com.desa.miprestamito.servicio;

import com.desa.miprestamito.Projections.TrazabilidadProjection;
import com.desa.miprestamito.modelo.Trazabilidad;

import java.util.List;

public interface TrazabilidadService {

    List<Trazabilidad> findByIdSolicitud(Long idQueja);

    public Trazabilidad guardar(Trazabilidad trazabilidad);

    List<TrazabilidadProjection> traerTrazabilidadPorCorrelativo(String corretivo);
}
