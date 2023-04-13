package com.desa.miprestamito.repositorio;

import com.desa.miprestamito.Projections.CorrelativoProjection;
import com.desa.miprestamito.Projections.TableReportesProjection;
import com.desa.miprestamito.modelo.Queja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuejaRepo extends CrudRepository<Queja, Long> {

    public  Iterable<Queja> findByUsuariocreo(String id);

    public List<Queja> findByIdTipoQueja(Long id);


    @Query(value = " SELECT q.correlativo, pa.nombre_punto_atencion as puntoAtencion, r.nombre as region,\n" +
            "       e.nombre_estado_solicitud as estado, m.nombre_medio as medioIngreso,\n" +
            "       q.fecha_hora_ingreso as fechaCreacion, q.detalle_queja as detalle\n" +
            "FROM public.queja q\n" +
            "INNER JOIN puntos_atencion pa ON pa.id_punto_atencion = q.id_punto_atencion\n" +
            "INNER JOIN region r ON r.id_region = pa.id_region\n" +
            "INNER JOIN estados_socitud e ON e.id_estadosolicitud = q.id_estado\n" +
            "INNER JOIN medio_ingreso_queja m ON m.id_medio_ingreso_queja = q.id_medio_ingreso_queja\n" +
            "WHERE q.id_punto_atencion = :id \n" +
            "GROUP BY q.correlativo, pa.nombre_punto_atencion, r.nombre, e.nombre_estado_solicitud, m.nombre_medio, q.fecha_hora_ingreso, q.detalle_queja;\n" , nativeQuery = true)
    public Iterable<TableReportesProjection> findByIdPuntoAtencion(@Param("id")  Long id);

    public List<Queja> findByIdEstado(Long id);

    @Query(value = "SELECT q.correlativo as correlativo FROM public.queja q WHERE q.id_queja = :correlativo", nativeQuery = true)
    public CorrelativoProjection findByCorrelativ(Long correlativo);


}
