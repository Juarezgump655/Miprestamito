package com.desa.miprestamito.servicio.impl;

import com.desa.miprestamito.excepciones.ResourceNotFoundException;
import com.desa.miprestamito.modelo.Region;
import com.desa.miprestamito.repositorio.RegionRepo;
import com.desa.miprestamito.servicio.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RegionServicempl implements RegionService {

    @Autowired
    private RegionRepo repositorio;

    @Override
    @Transactional
    public Region save(Region region) {
        return repositorio.save(region);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Region> listarRegiones() {
        return repositorio.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Region listarId(Long id) {
        return repositorio.findById(id).orElseThrow(()-> new ResourceNotFoundException("No se encontro la region con el id: " + id));
    }
}
