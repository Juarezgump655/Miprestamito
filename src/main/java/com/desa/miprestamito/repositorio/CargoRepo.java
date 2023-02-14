package com.desa.miprestamito.repositorio;

import com.desa.miprestamito.modelo.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepo  extends JpaRepository<Cargo, Long> {
}
