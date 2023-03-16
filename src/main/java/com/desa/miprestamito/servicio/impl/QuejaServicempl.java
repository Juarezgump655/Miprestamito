package com.desa.miprestamito.servicio.impl;

import com.desa.miprestamito.excepciones.ResourceNotFoundException;
import com.desa.miprestamito.modelo.Queja;
import com.desa.miprestamito.repositorio.QuejaRepo;
import com.desa.miprestamito.servicio.QuejaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class QuejaServicempl implements QuejaService {

    @Autowired
    private QuejaRepo repositorio;



    @Override
    @Transactional
    public Queja save(Queja queja) {
        return repositorio.save(queja);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Queja> listarQuejas() {
        return repositorio.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Queja listarId(Long id) {
        return repositorio.findById(id).orElseThrow(()-> new ResourceNotFoundException("No se encontro la queja con el id:" + id));
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Queja> listarQuejasIdTipoQueja(Long id) {
        return repositorio.findByIdTipoQueja(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Queja> listarQuejasPorUsuario(String id) {
        return repositorio.findByUsuariocreo(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Queja> listarQuejasPorPuntoAtencion(Long id) {
     return repositorio.findByIdPuntoAtencion(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Queja> listarQuejasPorEstado(Long estado) {
        return repositorio.findByIdEstado(estado);
    }


}
