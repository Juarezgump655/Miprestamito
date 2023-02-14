package com.desa.miprestamito.servicio;

import com.desa.miprestamito.modelo.Cargo;
import com.desa.miprestamito.repositorio.CargoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CargoServicempl implements CargoService{

    @Autowired
    private CargoRepo repositorio;

    @Override
    public Cargo save(Cargo cargo) {
        return repositorio.save(cargo);
    }

    @Override
    public Iterable<Cargo> listarCargos() {
        return repositorio.findAll();
    }

}
