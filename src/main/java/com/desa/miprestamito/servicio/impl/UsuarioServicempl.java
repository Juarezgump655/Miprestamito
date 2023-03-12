package com.desa.miprestamito.servicio.impl;

import com.desa.miprestamito.excepciones.ResourceNotFoundException;
import com.desa.miprestamito.modelo.Usuario;
import com.desa.miprestamito.repositorio.UsuarioRepo;
import com.desa.miprestamito.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class UsuarioServicempl implements UsuarioServicio {
    @Autowired
    private UsuarioRepo repositorio;


    @Override
    @Transactional
    public Usuario save(Usuario usuario) {
        return repositorio.save(usuario);
    }

    @Transactional(readOnly = true)
    public Iterable<Usuario> listarUsuarios(){
        return repositorio.findAll();
    }

    @Transactional(readOnly = true)
    public Usuario listarId(Long id){
        return repositorio.findById(id).orElseThrow(()-> new ResourceNotFoundException("No se encontro el usuario" + id));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> findbyCorreo(String correo) {
        return repositorio.findByCorreo(correo);
    }


}
