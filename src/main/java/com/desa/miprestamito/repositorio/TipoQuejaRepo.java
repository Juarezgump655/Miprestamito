package com.desa.miprestamito.repositorio;

import com.desa.miprestamito.Projections.TipoQuejaProjection;
import com.desa.miprestamito.modelo.TipoQueja;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TipoQuejaRepo extends CrudRepository<TipoQueja, Long> {
     @Query(value = "select t.id_tipo_queja  as idTIpoQueja, t.siglas_queja  as siglasQueja, t.descripcion_queja as descripcionQueja\n" +
             "\t\tfrom tipo_quejas t\n" +
             "\t\twhere t.id_estado =1",
             nativeQuery=true)
     List<TipoQuejaProjection> listarTipoQueja();
}
