package com.desa.miprestamito.servicio.impl;

import com.desa.miprestamito.Projections.regionesParaPuntosProjection;
import com.desa.miprestamito.excepciones.ResourceNotFoundException;
import com.desa.miprestamito.modelo.PuntosAtencion;
import com.desa.miprestamito.repositorio.PuntosAtencionRepo;
import com.desa.miprestamito.servicio.PuntoAtencionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PuntosAtencionServicempl implements PuntoAtencionService {


    @Autowired

    private PuntosAtencionRepo repositorio;

    @Override
    @Transactional
    public PuntosAtencion save(PuntosAtencion puntoAtencion) {
        return repositorio.save(puntoAtencion);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<PuntosAtencion> listarPuntosAtencion() {
        return repositorio.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public PuntosAtencion listarId(Long id) {
        return repositorio.findById(id).orElseThrow(()-> new ResourceNotFoundException("No se encontro el punto de atencion" + id));
    }

    @Override
    @Transactional
    public List<regionesParaPuntosProjection>traerRegiones(){
        return (List<regionesParaPuntosProjection>)repositorio.traerRegiones();
    }


}
