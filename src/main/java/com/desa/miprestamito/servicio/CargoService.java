package com.desa.miprestamito.servicio;

import com.desa.miprestamito.modelo.Cargo;

public interface CargoService {

    public Cargo save(Cargo cargo);

    public Iterable<Cargo> listarCargos();
}
