package com.desa.miprestamito.repositorio;

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


    @Query(value = "select  q.correlativo, pa.nombre_punto_atencion  as puntoAtencion, r.nombre as region, e.nombre_estado_solicitud as estado,\n" +
            "\t   \tm.nombre_medio  as medioIngreso, q.fecha_hora_ingreso as fechaCreacion , q.detalle_queja as detalle\n" +
            "        from public.queja q\n" +
            "        inner join  puntos_atencion pa on pa.id_punto_atencion  = q.id_punto_atencion\n" +
            "        inner join   region r on r.id_region = pa.id_region \n" +
            "        inner join  estados_socitud e  on e.id_estadosolicitud = q.id_estado \n" +
            "        inner join   medio_ingreso_queja m on m.id_medio_ingreso_queja = q.id_medio_ingreso_queja \n" +
            "        where  q.id_punto_atencion  =:id" , nativeQuery = true)
    public Iterable<TableReportesProjection> findByIdPuntoAtencion(@Param("id")  Long id);

    public List<Queja> findByIdEstado(Long id);


}
