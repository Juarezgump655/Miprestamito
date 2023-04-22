package com.desa.miprestamito.servicio;

import com.desa.miprestamito.Projections.TipoQuejaProjection;
import com.desa.miprestamito.Projections.contTipoQuejaProjection;
import com.desa.miprestamito.modelo.TipoQueja;

import java.util.List;

public interface TipoQuejaService {

    public TipoQueja save(TipoQueja tipoQueja);

    List<TipoQuejaProjection> listarTipoQueja();

    public TipoQueja modificarTipo(Long idTipoQueja, TipoQueja newTipoqueja);

    public contTipoQuejaProjection contSiglasQueja(String siglasQueja);

}
