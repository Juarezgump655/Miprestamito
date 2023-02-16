package com.desa.miprestamito.repositorio;

import com.desa.miprestamito.modelo.PuntosAtencion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PuntosAtencionRepo extends JpaRepository<PuntosAtencion, Long> {



}
