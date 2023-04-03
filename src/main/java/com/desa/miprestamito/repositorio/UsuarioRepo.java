package com.desa.miprestamito.repositorio;


import com.desa.miprestamito.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, Long> {


    Optional<Usuario> findByCorreo(String correo);


    List<Usuario> findUsuarioByIdpuntoatecion(Long idPuntoAtencion);

}

