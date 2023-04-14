package com.desa.miprestamito.repositorio;


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


    List<Usuario> findUsuarioByIdpuntoatecion(Long idPuntoAtencion);


    @Query(value = "select u.correo  from usuarios u where id_cargo =6 and id_puntoatencion = :id and estado =1" , nativeQuery = true)
    public List<String> findEmails(@Param("id") Long id);

}

