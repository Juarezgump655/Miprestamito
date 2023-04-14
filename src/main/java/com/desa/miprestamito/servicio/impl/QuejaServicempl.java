package com.desa.miprestamito.servicio.impl;

import com.desa.miprestamito.Projections.CorrelativoProjection;
import com.desa.miprestamito.Projections.TableReportesProjection;
import com.desa.miprestamito.controlador.CorreoController;
import com.desa.miprestamito.excepciones.ResourceNotFoundException;
import com.desa.miprestamito.modelo.Queja;
import com.desa.miprestamito.modelo.Trazabilidad;
import com.desa.miprestamito.repositorio.QuejaRepo;
import com.desa.miprestamito.repositorio.UsuarioRepo;
import com.desa.miprestamito.servicio.QuejaService;
import com.desa.miprestamito.servicio.TrazabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Service
public class QuejaServicempl implements QuejaService {

    @Autowired
    private QuejaRepo repositorio;

    @Autowired
    private TrazabilidadService trazabilidadService;

    @Autowired
    private CorreoController correoController;

    @Autowired
    private UsuarioRepo usuarioRepo;

    // Crear un Executor con un pool de hilos para las tareas asíncronas
    private Executor asyncExecutor = Executors.newFixedThreadPool(5);

    private static final String cuerpoCorreo = "Señor cuentahabiente,  agradecemos su comunicación,  le informamos que su queja ha sido recibida exitosamente. Para el seguimiento o cualquier consulta relacionada, no olvide que el número de su queja es: ";
    @Override
    public Queja save(Queja queja) {
        try {
            Queja queja1 = repositorio.save(queja);
            CompletableFuture.runAsync(() -> {
                Trazabilidad trazabilidad = new Trazabilidad(1L, queja.getIdQueja(), queja.getUsuariocreo());
                trazabilidadService.guardar(trazabilidad);
                CorrelativoProjection correlativo = getCorrelativo(queja1.getIdQueja());
                enviarCorreoCentralizador(queja.getIdPuntoAtencion());
                correoController.enviarCorreo(queja.getCorreo(), "Estimado cliente, su queja ha sido recibida",cuerpoCorreo+correlativo.getcorrelativo());
            }, asyncExecutor);
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

    @Override
    public List<String> findEmails(Long id) {
        return usuarioRepo.findEmails(id);
    }

    public void enviarCorreo(String correo, String asunto, String mensaje) {
    	correoController.enviarCorreo(correo, asunto, mensaje);
    }

    public static final String asunto = "Se a ingresado una nueva queja";
    public static final String mensaje = "El sistema de quejas le informa que se ha recibido una queja, la cual debe ser asignada dentro de las próximas 24 horas.";
    public void  enviarCorreoCentralizador(Long id) {
        List<String> correos = findEmails(id);
        for (String correo : correos) {
            System.out.println(correo);
            correoController.enviarCorreo(correo, asunto, mensaje);
        }
    }



}
