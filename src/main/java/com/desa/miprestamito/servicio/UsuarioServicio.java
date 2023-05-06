package com.desa.miprestamito.servicio;

import com.desa.miprestamito.Projections.contUsuariosProjection;
import com.desa.miprestamito.Projections.tablaUsersProjection;
import com.desa.miprestamito.Projections.traerCargoProjection;
import com.desa.miprestamito.Projections.traerPaProjection;
import com.desa.miprestamito.modelo.Usuario;


import java.util.List;
import java.util.Optional;

public interface UsuarioServicio {

    public Usuario save(Usuario usuario);

    public Iterable<Usuario> listarUsuarios();

    public Usuario listarId(Long id);
    public Optional<Usuario>  findbyCorreo(String correo);

    public  List<tablaUsersProjection> tablaUsuarios();

    public List<traerPaProjection> traerPuntos();
    public List<traerCargoProjection> traerCargo();

    public Usuario modificarUsuario (Long idUsuario, Usuario Usuario1);

    public contUsuariosProjection contUsuarios(String dpi);

}
