package com.desa.miprestamito.servicio;

import com.desa.miprestamito.excepciones.ResourceNotFoundException;
import com.desa.miprestamito.modelo.PuntosAtencion;
import com.desa.miprestamito.repositorio.PuntosAtencionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PuntosAtencionServicempl implements PuntoAtencionService{


    @Autowired
    private PuntosAtencionRepo repositorio;

    @Override
    public PuntosAtencion save(PuntosAtencion puntoAtencion) {
        return repositorio.save(puntoAtencion);
    }

    @Override
    public Iterable<PuntosAtencion> listarPuntosAtencion() {
        return repositorio.findAll();
    }

    @Override
    public PuntosAtencion listarId(Long id) {
        return repositorio.findById(id).orElseThrow(()-> new ResourceNotFoundException("No se encontro el punto de atencion" + id));
    }
}
