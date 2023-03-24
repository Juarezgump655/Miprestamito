package com.desa.miprestamito.servicio;

import com.desa.miprestamito.Projections.regionesParaPuntosProjection;
import com.desa.miprestamito.modelo.PuntosAtencion;

import java.util.List;

public interface PuntoAtencionService {

    public PuntosAtencion save(PuntosAtencion puntoAtencion);


    public Iterable<PuntosAtencion> listarPuntosAtencion();


    public PuntosAtencion listarId(Long id);

    public List<regionesParaPuntosProjection>traerRegiones();
}
