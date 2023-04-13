package com.desa.miprestamito.repositorio;

import com.desa.miprestamito.modelo.Trazabilidad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TrazabilidadRepo extends CrudRepository<Trazabilidad, Long> {

    List<Trazabilidad> findByIdSolicitud(Long idQueja);
}
