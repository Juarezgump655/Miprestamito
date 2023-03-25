package com.desa.miprestamito.servicio.impl;

import com.desa.miprestamito.modelo.MedioIngeresoQueja;
import com.desa.miprestamito.repositorio.MedioIngresoQuejaRepo;
import com.desa.miprestamito.servicio.MedioIngresoQuejaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedioIngresoQUejaServiceImpl implements MedioIngresoQuejaService {

    @Autowired
    private MedioIngresoQuejaRepo repositorio;
    @Override
    public List<MedioIngeresoQueja> listarMedioIngresoQueja() {
        return(List<MedioIngeresoQueja>) repositorio.findAll();
    }
}
