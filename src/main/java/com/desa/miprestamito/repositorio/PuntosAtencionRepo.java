package com.desa.miprestamito.repositorio;

import com.desa.miprestamito.Projections.regionesParaPuntosProjection;
import com.desa.miprestamito.modelo.PuntosAtencion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PuntosAtencionRepo extends JpaRepository<PuntosAtencion, Long> {
@Query(value = "select r.id_region as idRegion, r.nombre as nombreRegion from public.region r ;",
        nativeQuery=true)
    List<regionesParaPuntosProjection>traerRegiones();


}
