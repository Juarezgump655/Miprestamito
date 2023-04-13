package com.desa.miprestamito.servicio.impl;

import com.desa.miprestamito.Projections.CorrelativoProjection;
import com.desa.miprestamito.Projections.TableReportesProjection;
import com.desa.miprestamito.controlador.CorreoController;
import com.desa.miprestamito.excepciones.ResourceNotFoundException;
import com.desa.miprestamito.modelo.Queja;
import com.desa.miprestamito.modelo.Trazabilidad;
import com.desa.miprestamito.repositorio.QuejaRepo;
import com.desa.miprestamito.servicio.QuejaService;
import com.desa.miprestamito.servicio.TrazabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuejaServicempl implements QuejaService {

    @Autowired
    private QuejaRepo repositorio;

    @Autowired
    private TrazabilidadService trazabilidadService;

    @Autowired
    private CorreoController correoController;


    private static final String cuerpoCorreo = "Señor cuentahabiente,  agradecemos su comunicación,  le informamos que su queja ha sido recibida exitosamente. Para el seguimiento o cualquier consulta relacionada, no olvide que el número de su queja es: ";
    @Override
    @Transactional
    public Queja save(Queja queja) {
        try {
            Queja queja1 = repositorio.save(queja);
            Trazabilidad trazabilidad = new Trazabilidad(1L, queja1.getIdQueja(), queja1.getUsuariocreo());
            trazabilidadService.guardar(trazabilidad);
            CorrelativoProjection correlativo = getCorrelativo(queja1.getIdQueja());
            correoController.enviarCorreo(queja1.getCorreo(), "Estimado cliente, su queja ha sido recibida",cuerpoCorreo+correlativo.getcorrelativo());
            return  queja1;
        } catch (Exception e) {
            throw new ResourceNotFoundException("No se pudo guardar la queja");
        }
    }



    @Override
    @Transactional(readOnly = true)
    public Iterable<Queja> listarQuejas() {
        return repositorio.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Queja listarId(Long id) {
        return repositorio.findById(id).orElseThrow(()-> new ResourceNotFoundException("No se encontro la queja con el id:" + id));
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Queja> listarQuejasIdTipoQueja(Long id) {
        return repositorio.findByIdTipoQueja(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Queja> listarQuejasPorUsuario(String id) {
        return repositorio.findByUsuariocreo(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TableReportesProjection> listarQuejasPorPuntoAtencion(Long id) {
     return( List<TableReportesProjection>) repositorio.findByIdPuntoAtencion(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Queja> listarQuejasPorEstado(Long estado) {
        return repositorio.findByIdEstado(estado);
    }

    @Override
    public CorrelativoProjection getCorrelativo(Long correlativo) {
        return repositorio.findByCorrelativ(correlativo);
    }

    public void enviarCorreo(String correo, String asunto, String mensaje) {
    	correoController.enviarCorreo(correo, asunto, mensaje);
    }



}
