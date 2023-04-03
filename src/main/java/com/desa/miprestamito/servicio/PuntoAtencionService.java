package com.desa.miprestamito.servicio;

import com.desa.miprestamito.Projections.PuntoAtencionProjection;
import com.desa.miprestamito.Projections.contUsuariosProjections;
import com.desa.miprestamito.Projections.regionesParaPuntosProjection;
import com.desa.miprestamito.Projections.tablaPuntosAtencionProjection;
import com.desa.miprestamito.modelo.PuntosAtencion;
import com.desa.miprestamito.modelo.Usuario;

import java.util.List;

public interface PuntoAtencionService {

    public PuntosAtencion save(PuntosAtencion puntoAtencion);


    public Iterable<PuntosAtencion> listarPuntosAtencion();


    public PuntosAtencion listarId(Long id);

    public List<regionesParaPuntosProjection>traerRegiones();

    public List<PuntoAtencionProjection>traerPuntosDeAencion();

    public List<tablaPuntosAtencionProjection>traerTablaPuntos(Long idRegion);

    public PuntosAtencion modificarPuntos(Long idPuntoAtencion, PuntosAtencion puntoModificado);

    public contUsuariosProjections contadorUsuarios (Long idPuntoAtencion);
}
