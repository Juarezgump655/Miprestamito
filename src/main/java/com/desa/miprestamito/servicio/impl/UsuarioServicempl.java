package com.desa.miprestamito.servicio.impl;

import com.desa.miprestamito.Projections.tablaUsersProjection;
import com.desa.miprestamito.Projections.traerCargoProjection;
import com.desa.miprestamito.Projections.traerPaProjection;
import com.desa.miprestamito.excepciones.ResourceNotFoundException;
import com.desa.miprestamito.modelo.Usuario;
import com.desa.miprestamito.repositorio.UsuarioRepo;
import com.desa.miprestamito.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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

    @Override
    public  List<tablaUsersProjection> tablaUsuarios(){
        return repositorio.tablaUsuarios();
    }

    @Override
    public List<traerPaProjection> traerPuntos(){
        return repositorio.traerPuntos();
    }

    @Override
    public List<traerCargoProjection> traerCargo(){
        return repositorio.traerCargo();
    }

    @Override
    public Usuario modificarUsuario(Long idUsuario, Usuario Usuario1){
        Optional<Usuario> usuarioModificar= repositorio.findById(idUsuario);
        if(usuarioModificar.isPresent()){
            Usuario newUsuario= usuarioModificar.get();

            newUsuario.setNombre(Usuario1.getNombre());
            newUsuario.setApellidos(Usuario1.getApellidos());
            newUsuario.setIdpuntoatencion(Usuario1.getIdpuntoatencion());
            newUsuario.setDpi(Usuario1.getDpi());
            newUsuario.setCorreo(Usuario1.getCorreo());
            newUsuario.setId_cargo(Usuario1.getId_cargo());
            newUsuario.setEstado(Usuario1.getEstado());
            newUsuario.setFechamodificacion(Usuario1.getFechamodificacion());
            newUsuario.setUsuariomodifico(Usuario1.getUsuariomodifico());

            repositorio.save(newUsuario);
            return newUsuario;

        }else{
            throw new ResourceNotFoundException("El objeto Usuario con identificador " + idUsuario + " no existe en el repositorio.");
        }
    }



}
