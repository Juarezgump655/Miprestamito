package com.desa.miprestamito.servicio;

import com.desa.miprestamito.Projections.TipoQuejaProjection;

import java.util.List;

public interface TipoQuejaService {

    List<TipoQuejaProjection> listarTipoQueja();
}
