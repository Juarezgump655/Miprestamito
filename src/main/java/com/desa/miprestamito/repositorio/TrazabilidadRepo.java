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

    @Query(value = "SELECT\n" +
            "    t.id_estadosolicitud AS estadosSolicitud,\n" +
            "    t.id_solicitud AS idSocilitud,\n" +
            "    e.nombre_estado_solicitud AS nombreEstado,\n" +
            "    t.estado_registro AS estado,\n" +
            "    TO_CHAR( q.fechacreacion, 'DD/MM/YYYY') as fechacreacion,\n" +
            "    TO_CHAR(q.fecha_final, 'DD/MM/YYYY') AS fechaFinal\n" +
            "FROM\n" +
            "    public.trazabilidad t\n" +
            "    INNER JOIN queja q ON q.id_queja = t.id_solicitud\n" +
            "    INNER JOIN estados_socitud e ON e.id_estadosolicitud = t.id_estadosolicitud\n" +
            "WHERE\n" +
            "    q.correlativo = :corretivo", nativeQuery = true)
    List<TrazabilidadProjection> traerTrazabilidadPorCorrelativo(String corretivo);
}
