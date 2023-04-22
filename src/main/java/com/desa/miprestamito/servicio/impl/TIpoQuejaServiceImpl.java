package com.desa.miprestamito.servicio.impl;

import com.desa.miprestamito.Projections.TipoQuejaProjection;
import com.desa.miprestamito.Projections.contTipoQuejaProjection;
import com.desa.miprestamito.excepciones.ResourceNotFoundException;
import com.desa.miprestamito.modelo.TipoQueja;
import com.desa.miprestamito.repositorio.TipoQuejaRepo;
import com.desa.miprestamito.servicio.TipoQuejaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TIpoQuejaServiceImpl implements TipoQuejaService {

    @Autowired
    private TipoQuejaRepo tipoQuejaRepo;

    @Override
    public List<TipoQuejaProjection> listarTipoQueja() {
        return tipoQuejaRepo.listarTipoQueja();
    }

    @Override
    public TipoQueja save(TipoQueja tipoQueja){
        return tipoQuejaRepo.save(tipoQueja);
    }

    @Override
    public TipoQueja modificarTipo(Long idTipoQueja, TipoQueja newTipoqueja){
        Optional<TipoQueja> tipoQueja = tipoQuejaRepo.findById(idTipoQueja);
            Long tQueja= idTipoQueja;
            if(tipoQueja.isPresent()){
                TipoQueja tipoM= tipoQueja.get();

                tipoM.setSiglasQueja(newTipoqueja.getSiglasQueja());
                tipoM.setDescripcionQueja(newTipoqueja.getDescripcionQueja());
               tipoM.setIdEstado(newTipoqueja.getIdEstado());
               tipoM.setFechamodificacion(newTipoqueja.getFechamodificacion());
               tipoM.setUsuariomodifico(newTipoqueja.getUsuariomodifico());

               tipoQuejaRepo.save(tipoM);
               return tipoM;
            }else{
                throw new ResourceNotFoundException("El objeto TipoQueja con identificador " + idTipoQueja + " no existe en el repositorio.");
            }
    }


    public contTipoQuejaProjection contSiglasQueja(String siglasQueja){
        return tipoQuejaRepo.contSiglasQueja(siglasQueja);
    }



}
