package com.desa.miprestamito.Projections;

public interface TrazabilidadProjection {

    Long getEstadosSolicitud();

    Long getIdSolicitud();

    String getFechaIngreso();

    Long getEstado();

    String getNombreEstado();

    String getFechacreacion();

    String getFechaFinal();
}
