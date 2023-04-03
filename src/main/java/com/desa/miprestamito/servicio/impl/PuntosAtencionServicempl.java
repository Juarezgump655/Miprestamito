package com.desa.miprestamito.servicio.impl;

import com.desa.miprestamito.Projections.PuntoAtencionProjection;
import com.desa.miprestamito.Projections.contUsuariosProjections;
import com.desa.miprestamito.Projections.regionesParaPuntosProjection;
import com.desa.miprestamito.Projections.tablaPuntosAtencionProjection;
import com.desa.miprestamito.excepciones.ResourceNotFoundException;
import com.desa.miprestamito.modelo.PuntosAtencion;
import com.desa.miprestamito.modelo.Usuario;
import com.desa.miprestamito.repositorio.PuntosAtencionRepo;
import com.desa.miprestamito.repositorio.UsuarioRepo;
import com.desa.miprestamito.servicio.PuntoAtencionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PuntosAtencionServicempl implements PuntoAtencionService {


    @Autowired

    private PuntosAtencionRepo repositorio;

    @Autowired
    private UsuarioRepo repositorioUsuario;

    @Override
    @Transactional
    public PuntosAtencion save(PuntosAtencion puntoAtencion) {
        return repositorio.save(puntoAtencion);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<PuntosAtencion> listarPuntosAtencion() {
        return repositorio.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public PuntosAtencion listarId(Long id) {
        return repositorio.findById(id).orElseThrow(()-> new ResourceNotFoundException("No se encontro el punto de atencion" + id));
    }

    @Override
    @Transactional
    public List<regionesParaPuntosProjection>traerRegiones(){
        return (List<regionesParaPuntosProjection>)repositorio.traerRegiones();
    }

    @Override
    public List<PuntoAtencionProjection> traerPuntosDeAencion() {
        return repositorio.traerPuntosAtencion();
    }

    @Override
    public List<tablaPuntosAtencionProjection>traerTablaPuntos(Long idRegion){
        return (List<tablaPuntosAtencionProjection>)repositorio.traerTablaPuntos(idRegion);
    }





    @Override
    public PuntosAtencion modificarPuntos(Long idPuntoAtencion, PuntosAtencion puntoModificado){
        Optional<PuntosAtencion> punto= repositorio.findById(idPuntoAtencion);
        Long puntoAtencion= idPuntoAtencion;
        System.out.println(idPuntoAtencion);
        if(punto.isPresent()){
            PuntosAtencion punto1= punto.get();
            punto1.setNombrePuntoAtencion(puntoModificado.getNombrePuntoAtencion());
            punto1.setEstado(puntoModificado.getEstado());
            punto1.setFechamodificacion(puntoModificado.getFechamodificacion());
            punto1.setUsuariomodifico(puntoModificado.getUsuariomodifico());

            repositorio.save(punto1);
            if (puntoModificado.getEstado()==2L) {
                List<Usuario> usuarios= repositorioUsuario.findUsuarioByIdpuntoatecion(puntoAtencion);
                for (Usuario usuario : usuarios) {
                    usuario.setEstado(2L);
                    repositorioUsuario.save(usuario);
                }
                
            }
            return punto1;
        }else{
            throw new ResourceNotFoundException("El objeto PuntosAtencion con identificador " + idPuntoAtencion + " no existe en el repositorio.");
        }
    }



    @Override
    public contUsuariosProjections contadorUsuarios (Long idPuntoAtencion){
        return repositorio.contadorUsuarios(idPuntoAtencion);
    }


}
