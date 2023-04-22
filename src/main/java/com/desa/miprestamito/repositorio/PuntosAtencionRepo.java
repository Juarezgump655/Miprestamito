package com.desa.miprestamito.repositorio;

import com.desa.miprestamito.Projections.PuntoAtencionProjection;
import com.desa.miprestamito.Projections.contUsuariosProjections;
import com.desa.miprestamito.Projections.regionesParaPuntosProjection;
import com.desa.miprestamito.Projections.tablaPuntosAtencionProjection;
import com.desa.miprestamito.modelo.PuntosAtencion;
import com.desa.miprestamito.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PuntosAtencionRepo extends JpaRepository<PuntosAtencion, Long> {
@Query(value = "select r.id_region as idRegion, r.nombre as nombreRegion from public.region r ;",
        nativeQuery=true)
    List<regionesParaPuntosProjection>traerRegiones();

@Query(value = "select p.id_punto_atencion as idPuntoAtencion, p.nombre_punto_atencion as nombrePuntoAtencion \n" +
        "\t\tfrom puntos_atencion p\n" +
        "\t\twhere p.id_estado =1",
        nativeQuery=true)
    List<PuntoAtencionProjection>traerPuntosAtencion();

@Query(value = "select pa.id_punto_atencion as idPuntoAtencion, \n" +
        "\t   pa.nombre_punto_atencion as nombrePunto,\n" +
        "\t   e.nombre as nombreEstado,\n" +
        "\t   r.nombre as nombreRegion\n" +
        "\t    from public.puntos_atencion pa \n" +
        "\t    inner join public.estado e on\n" +
        "\t    pa.id_estado = e.id_estado \n" +
        "\t    inner join public.region r on\n" +
        "\t    pa.id_region = r.id_region \n" +
        "\t    where pa.id_region= ?1 and pa.id_estado =1", nativeQuery = true)
    List<tablaPuntosAtencionProjection>traerTablaPuntos(Long idRegion);


@Query(value= "update public.usuarios  set estado =2 where id_puntoatencion =?1", nativeQuery=true)
      List<Usuario> actualizarEstadoUsuario( Long idPuntoAtencion);

@Query(value="select count(*) from public.usuarios u where  u.estado =1 and u.id_puntoatencion = ?1", nativeQuery = true)
    public contUsuariosProjections contadorUsuarios (Long idPuntoAtencion);


}
