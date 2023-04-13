package com.desa.miprestamito.servicio.impl;

import com.desa.miprestamito.modelo.Trazabilidad;
import com.desa.miprestamito.repositorio.TrazabilidadRepo;
import com.desa.miprestamito.servicio.TrazabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TrazabilidadServiceImpl implements TrazabilidadService {

    @Autowired
    private TrazabilidadRepo trazabilidadRepo;

    @Override
    @Transactional(readOnly = true)
    public List<Trazabilidad> findByIdSolicitud(Long idQueja) {
        return trazabilidadRepo.findByIdSolicitud(idQueja);
    }

    @Override
    @Transactional
    public Trazabilidad guardar(Trazabilidad trazabilidad) {
        return trazabilidadRepo.save(trazabilidad);
    }
}
