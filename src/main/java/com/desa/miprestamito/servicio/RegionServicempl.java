package com.desa.miprestamito.servicio;

import com.desa.miprestamito.excepciones.ResourceNotFoundException;
import com.desa.miprestamito.modelo.Region;
import com.desa.miprestamito.repositorio.RegionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionServicempl implements RegionService {

    @Autowired
    private RegionRepo repositorio;

    @Override
    public Region save(Region region) {
        return repositorio.save(region);
    }

    @Override
    public List<Region> listarRegiones() {
        return repositorio.findAll();
    }

    @Override
    public Region listarId(Long id) {
        return repositorio.findById(id).orElseThrow(()-> new ResourceNotFoundException("No se encontro la region con el id: " + id));
    }
}
