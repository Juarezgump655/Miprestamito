package com.desa.miprestamito.servicio.impl;

import com.desa.miprestamito.modelo.Cargo;
import com.desa.miprestamito.repositorio.CargoRepo;
import com.desa.miprestamito.servicio.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CargoServicempl implements CargoService {

    @Autowired

    private CargoRepo repositorio;

    @Override
    @Transactional
    public Cargo save(Cargo cargo) {
        return repositorio.save(cargo);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Cargo> listarCargos() {
        return repositorio.findAll();
    }

}
