package com.desa.miprestamito.servicio;

import com.desa.miprestamito.modelo.Usuario;


import java.util.Optional;

public interface UsuarioServicio {

    public Usuario save(Usuario usuario);

    public Iterable<Usuario> listarUsuarios();

    public Usuario listarId(Long id);
    public Optional<Usuario>  findbyCorreo(String correo);


}
