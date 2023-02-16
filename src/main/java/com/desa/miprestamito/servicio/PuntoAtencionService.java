package com.desa.miprestamito.servicio;

import com.desa.miprestamito.modelo.PuntosAtencion;

public interface PuntoAtencionService {

    public PuntosAtencion save(PuntosAtencion puntoAtencion);


    public Iterable<PuntosAtencion> listarPuntosAtencion();


    public PuntosAtencion listarId(Long id);
}
