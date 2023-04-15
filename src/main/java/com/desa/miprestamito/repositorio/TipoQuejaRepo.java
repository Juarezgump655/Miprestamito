package com.desa.miprestamito.repositorio;

import com.desa.miprestamito.Projections.TipoQuejaProjection;
import com.desa.miprestamito.modelo.TipoQueja;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TipoQuejaRepo extends CrudRepository<TipoQueja, Long> {
     @Query(value = "select t.id_tipo_queja  as idTipoQueja, t.siglas_queja  as siglasQueja, t.descripcion_queja as descripcionQueja, e.nombre as estado\n" +
             "\t\tfrom tipo_quejas t\n" +
             "\t\tinner join public.estado e on t.id_estado =  e.id_estado\n"+
             "\t\twhere t.id_estado =1",
             nativeQuery=true)

     List<TipoQuejaProjection> listarTipoQueja();


}
