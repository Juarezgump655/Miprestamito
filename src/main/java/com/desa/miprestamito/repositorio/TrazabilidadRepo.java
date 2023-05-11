package com.desa.miprestamito.repositorio;

import com.desa.miprestamito.Projections.TrazabilidadProjection;
import com.desa.miprestamito.modelo.Trazabilidad;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TrazabilidadRepo extends CrudRepository<Trazabilidad, Long> {

    List<Trazabilidad> findByIdSolicitud(Long idQueja);

    @Query(value = "\tselect t.id_estadosolicitud as estadosSolicitud ,t.id_solicitud  as idSolicitud \n" +
            "\tfrom public.trazabilidad t\n" +
            "\tINNER JOIN queja q ON q.id_queja = t.id_solicitud \n" +
            "\twhere q.correlativo = :corretivo", nativeQuery = true)
    List<TrazabilidadProjection> traerTrazabilidadPorCorrelativo(String corretivo);
}
