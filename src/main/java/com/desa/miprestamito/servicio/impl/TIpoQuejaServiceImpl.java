package com.desa.miprestamito.servicio.impl;

import com.desa.miprestamito.Projections.TipoQuejaProjection;
import com.desa.miprestamito.repositorio.TipoQuejaRepo;
import com.desa.miprestamito.servicio.TipoQuejaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TIpoQuejaServiceImpl implements TipoQuejaService {

    @Autowired
    private TipoQuejaRepo tipoQuejaRepo;
    @Override
    public List<TipoQuejaProjection> listarTipoQueja() {
        return tipoQuejaRepo.listarTipoQueja();
    }
}
