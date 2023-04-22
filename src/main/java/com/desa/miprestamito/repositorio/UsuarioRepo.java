package com.desa.miprestamito.repositorio;


import com.desa.miprestamito.Projections.tablaUsersProjection;
import com.desa.miprestamito.Projections.traerCargoProjection;
import com.desa.miprestamito.Projections.traerPaProjection;
import com.desa.miprestamito.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, Long> {


    Optional<Usuario> findByCorreo(String correo);


    List<Usuario> findUsuarioByIdpuntoatencion(Long idPuntoAtencion);

    @Query(value = "select u.correo  from usuarios u where id_cargo =6 and id_puntoatencion = :id and estado =1" , nativeQuery = true)
    public List<String> findEmails(@Param("id") Long id);
    @Query(value = "select  u.idusuario as idUsuario,\n" +
            "\t   (u.nombre || ' ' || u.apellidos ) as nombreUsuario,\n" +
            "\t   r.nombre as region,\n" +
            "\t   pa.nombre_punto_atencion as PuntoAtencion,\n" +
            "\t   c.nombre_cargo as cargo,\n" +
            "\t   u.correo as correo,\n" +
            "\t   e.nombre as estado\n" +
            "from public.usuarios u \n" +
            " inner join public.estado e on\n" +
            " u.estado = e.id_estado \n" +
            " inner join public.puntos_atencion pa on\n" +
            " u.id_puntoatencion = pa.id_punto_atencion \n" +
            " inner join public.cargo c on\n" +
            " u.id_cargo = c.id_cargo \n" +
            "  inner join public.region r on\n" +
            " pa.id_region =r.id_region " +
            "where u.estado =1",nativeQuery = true)
   public  List<tablaUsersProjection> tablaUsuarios();


@Query(value = "select pa.id_punto_atencion as idPuntoAtencion, pa.nombre_punto_atencion as nombrePunto from public.puntos_atencion pa where pa.id_estado =1",
nativeQuery = true)
public List<traerPaProjection> traerPuntos();

@Query(value = "select c.id_cargo as idCargo, c.nombre_cargo as nombreCargo \n" +
        "from public.cargo c where c.estado =1 and c.id_cargo >= 1 and c.id_cargo <= 7",nativeQuery = true)
    public List<traerCargoProjection> traerCargo();
}


