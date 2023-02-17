package com.desa.miprestamito.servicio;

import com.desa.miprestamito.excepciones.ResourceNotFoundException;
import com.desa.miprestamito.modelo.Queja;
import com.desa.miprestamito.repositorio.QuejaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuejaServicempl implements QuejaService{

    @Autowired
    private QuejaRepo repositorio;



    @Override
    public Queja save(Queja queja) {
        return repositorio.save(queja);
    }

    @Override
    public Iterable<Queja> listarQuejas() {
        return repositorio.findAll();
    }

    @Override
    public Queja listarId(Long id) {
        return repositorio.findById(id).orElseThrow(()-> new ResourceNotFoundException("No se encontro la queja con el id:" + id));
    }

    @Override
    public Iterable<Queja> listarQuejasPorUsuario(Long id) {
        return repositorio.findByUsuarioId(id);
    }

    @Override
    public Iterable<Queja> listarQuejasPorPuntoAtencion(Long id) {
        return repositorio.findByPuntoAtencionId(id);
    }

    @Override
    public Iterable<Queja> listarQuejasPorEstado(Long estado) {
        return repositorio.findByEstado(estado);
    }


}
