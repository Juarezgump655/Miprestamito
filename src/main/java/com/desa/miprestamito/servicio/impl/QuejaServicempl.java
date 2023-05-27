package com.desa.miprestamito.servicio.impl;

import com.desa.miprestamito.Projections.*;
import com.desa.miprestamito.controlador.CorreoController;
import com.desa.miprestamito.excepciones.ResourceNotFoundException;
import com.desa.miprestamito.modelo.Queja;
import com.desa.miprestamito.modelo.Trazabilidad;
import com.desa.miprestamito.repositorio.QuejaRepo;
import com.desa.miprestamito.repositorio.TrazabilidadRepo;
import com.desa.miprestamito.repositorio.UsuarioRepo;
import com.desa.miprestamito.servicio.QuejaService;
import com.desa.miprestamito.servicio.TrazabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
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
    private TrazabilidadRepo trazabilidadRepo;

    @Autowired
    private UsuarioRepo usuarioRepo;

    // Crear un Executor con un pool de hilos para las tareas asíncronas
    private Executor asyncExecutor = Executors.newFixedThreadPool(5);
    private static Date date = new Date();
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

    @Override
    public List<String> findUsuariosPuntos(Long idPuntoAtencion){
        return usuarioRepo.findUsuariosPuntos(idPuntoAtencion);
    }

    @Override
    public List<String> findUsuariosPuntosNombres(Long idPuntoAtencion, String correo){
        return usuarioRepo.findUsuariosPuntosNombres(idPuntoAtencion, correo);
    }

    @Override
    public FichaPAProjection findByCorrelativoPA(String correlativo) {
        return repositorio.findByCorrelativoPA(correlativo);
    }

    @Override
    @Transactional
    public void actualizarPropiedad(String correlativo) {
       repositorio.actualizarPropiedad(correlativo);
    }

    @Override
    @Transactional
    public void actualizarJustificacionPunto(String correlativo, String justificacion) {
            repositorio.actualizarJustificacionPunto(correlativo, justificacion);
    }


    public void enviarCorreo(String correo, String asunto, String mensaje) {
    	correoController.enviarCorreo(correo, asunto, mensaje);
    }

    public static final String asunto = "Se a ingresado una nueva queja";
    public static final String asuntoRechazo = "Se Ha rechazado una queja";

    public static final String asuntoAsignacion = "Se ha asignado una queja ";

    public static final String asuntoResolucion = "Se ha resuelto su queja ";
    public static final String mensajeRechazo = "Señor(a) Cuentahabiente, la atención a su queja no procede,  ";

    public static final String mensajeAsignadoPunto = "Señor(a) Cuentahabiente, su queja ha sido trasladada al administrador del punto de atención correspondiente para su análisis";
    public static final String mensajeResolucion = "Señor(a) Cuentahabiente, su queja ha sido atendida y resuelta correctamente, gracias por utilizar nuestros servicios.";
    public static final String mensaje = "El sistema de quejas le informa que se ha recibido una queja, la cual debe ser asignada dentro de las próximas 24 horas.";
    public void  enviarCorreoCentralizador(Long id) {
        List<String> correos = findEmails(id);

        for (String correo : correos) {
            System.out.println(correo);
            correoController.enviarCorreo(correo, asunto, mensaje);
        }
    }

    public void  enviarCorreoPunto(Long idPuntoAtencion, Queja quejaModificada) {
        List<String> correos = findUsuariosPuntos(idPuntoAtencion);

        for (String correo : correos) {
            List<String> nombres= findUsuariosPuntosNombres(idPuntoAtencion,correo);
            String mensajeParaUsuariosPuntos="Estimado  " +nombres+
                    "El sistema para control de quejas por mal servicio o servicio no conforme le informa que se le asignó la queja No: "+quejaModificada.getCorrelativo()+
                    ", Para su atención tiene un plazo máximo de 5 días hábiles, según normativa vigente.\n";
            correoController.enviarCorreo(correo, asuntoAsignacion, mensajeParaUsuariosPuntos);
        }
    }

    public void  enviarCorreoPuntoSeguimiento(Long idPuntoAtencion, Queja quejaModificada) {
        List<String> correos = findUsuariosPuntos(idPuntoAtencion);

        for (String correo : correos) {
            List<String> nombres= findUsuariosPuntosNombres(idPuntoAtencion,correo);
            String mensajeParaUsuariosPuntos="Estimado  " +nombres+
                    "El sistema para control de quejas por mal servicio o servicio no conforme le informa que se le asignó la queja No : "+quejaModificada.getCorrelativo()+
                    "  para su reanálisis; para su atención tiene un plazo máximo de 24 horas, según normativa vigente..\n";
            correoController.enviarCorreo(correo, asuntoAsignacion, mensajeParaUsuariosPuntos);
        }
    }




    public List<tablaAsignacionQuejaProjection> tablaAsignacionQueja(){
        return repositorio.tablaAsignacionQueja();
    }

    @Override
    public List<TableReportesProjection> findByCorrelativo(String correlativo) {
        return repositorio.findByCorrelativo(correlativo);
    }

    @Override
    public List<TableReportesProjection> findByPuntoAtencion(Long puntoAtencion) {
        return repositorio.findByPuntoAtencion(puntoAtencion);
    }
    public fichaQuejaProjection fichaQueja(Long idQueja){
        return repositorio.fichaQueja(idQueja);
    }

    @Override
    public List<TableReportesProjection> findByRegion(Long region) {
        return repositorio.findByRegion(region);
    }

    @Override
    public List<TableQuejaSeguimientoProjection> findByPuntoAtencionAtendidas(Long idPuntoAtencion) {
        return repositorio.findByPuntoAtencionAtendidas(idPuntoAtencion);
    }

    @Override
    public List<TableReportesProjection> listarQuejasFechas(String fechaInicio, String fechaFin){
        return repositorio.findByFechas(fechaInicio, fechaFin);
    }


    @Override
    public Queja asignarQueja(Long idQueja, Queja queja1) {
        Optional<Queja> queja = this.repositorio.findById(idQueja);
        final Trazabilidad nuevoEstado = new Trazabilidad();



        if(queja.isPresent()){
            Queja quejaModificada= queja.get();

            if(queja1.getIdEstado()==3){
                CompletableFuture.runAsync(() -> {
                    quejaModificada.setUsuariomodifico(queja1.getUsuariomodifico());
                    quejaModificada.setFechamodificacion(queja1.getFechamodificacion());
                    quejaModificada.setFechaFinal(queja1.getFechaFinal());
                    quejaModificada.setJustificacionRechazo(queja1.getJustificacionRechazo());
                    quejaModificada.setIdEstado(2L);

                    nuevoEstado.setIdEstadoSolicitud(3L);
                    nuevoEstado.setIdSolicitud(idQueja);
                    nuevoEstado.setUsuariomodifico(queja1.getUsuariomodifico());
                    nuevoEstado.setFechaModifico(queja1.getFechamodificacion());
                    nuevoEstado.setUsuarioIngreso(queja1.getUsuariomodifico());
                    nuevoEstado.setEstadoRegistro(2L);
                    trazabilidadRepo.save(nuevoEstado);

                    this.enviarCorreo(quejaModificada.getCorreo(),asuntoRechazo,mensajeRechazo+queja1.getJustificacionRechazo() );
                }, asyncExecutor);


               return repositorio.save(quejaModificada);


            }else{
                CompletableFuture.runAsync(() -> {
                    quejaModificada.setIdPuntoAsignado(queja1.getIdPuntoAsignado());
                    quejaModificada.setUsuariomodifico(queja1.getUsuariomodifico());
                    quejaModificada.setFechamodificacion(queja1.getFechamodificacion());
                    quejaModificada.setIdEstado(2L);

                    nuevoEstado.setIdEstadoSolicitud(2L);
                    nuevoEstado.setIdSolicitud(idQueja);
                    nuevoEstado.setUsuariomodifico(queja1.getUsuariomodifico());
                    nuevoEstado.setFechaModifico(queja1.getFechamodificacion());
                    nuevoEstado.setEstadoRegistro(1L);
                    nuevoEstado.setUsuarioIngreso(queja1.getUsuariomodifico());
                    trazabilidadRepo.save(nuevoEstado);

                    this.enviarCorreo(quejaModificada.getCorreo(),asuntoAsignacion, mensajeAsignadoPunto);

                    this.enviarCorreoPunto(quejaModificada.getIdPuntoAsignado(), quejaModificada);


                }, asyncExecutor);


                return repositorio.save(quejaModificada);

            }
        }else{
            throw new ResourceNotFoundException("El objeto Queja con identificador " + idQueja+ " no existe en el repositorio.");
        }
    }


    public List<seguimientoTablaProjection> tablaSeguimientoQueja(){
        return repositorio.tablaSeguimientoQueja();
    }

    public seguimientoTablaDetalleProjection tablaSeguimientoDetalleQueja(Long idQueja){
        return repositorio.tablaSeguimientoDetalleQueja(idQueja);
    }

    public Queja seguimientoCentralizador(Long idQueja, Queja queja2){
        Optional<Queja> queja = this.repositorio.findById(idQueja);
        final Trazabilidad nuevoEstado = new Trazabilidad();
        if(queja.isPresent()){
            Queja quejaModificada= queja.get();
            if(queja2.getIdEstado()==2){
                CompletableFuture.runAsync(() -> {

                    quejaModificada.setUsuariomodifico(queja2.getUsuariomodifico());
                    quejaModificada.setFechacreacion(queja2.getFechamodificacion());
                    quejaModificada.setFechaFinal(queja2.getFechaFinal());
                    quejaModificada.setResultadoSeguimiento(queja2.getResultadoSeguimiento());
                    quejaModificada.setIdEstado(2L);


                    nuevoEstado.setIdEstadoSolicitud(6L);
                    nuevoEstado.setIdSolicitud(idQueja);
                    nuevoEstado.setUsuariomodifico(queja2.getUsuariomodifico());
                    nuevoEstado.setFechaModifico(queja2.getFechamodificacion());
                    nuevoEstado.setUsuarioIngreso(queja2.getUsuariomodifico());
                    nuevoEstado.setEstadoRegistro(2L);
                    trazabilidadRepo.save(nuevoEstado);

                    this.enviarCorreo(quejaModificada.getCorreo(), asuntoResolucion, mensajeResolucion);
                }, asyncExecutor);

                return repositorio.save(quejaModificada);
            }else{
                CompletableFuture.runAsync(() -> {
                    quejaModificada.setUsuariomodifico(queja2.getUsuariomodifico());
                    quejaModificada.setIdPuntoAsignado(queja2.getIdPuntoAsignado());
                    quejaModificada.setIdEstado(1L);

                    nuevoEstado.setIdEstadoSolicitud(7L);
                    nuevoEstado.setIdSolicitud(idQueja);
                    nuevoEstado.setUsuariomodifico(queja2.getUsuariomodifico());
                    nuevoEstado.setFechaModifico(queja2.getFechamodificacion());
                    nuevoEstado.setUsuarioIngreso(queja2.getUsuariomodifico());
                    nuevoEstado.setEstadoRegistro(1L);
                    trazabilidadRepo.save(nuevoEstado);

                    this.enviarCorreoPuntoSeguimiento(quejaModificada.getIdPuntoAsignado(), quejaModificada);

                }, asyncExecutor);

                return repositorio.save(quejaModificada);

            }

        }else{
            throw new ResourceNotFoundException("El objeto Queja con identificador " + idQueja+ " no existe en el repositorio.");

        }
    }

    public Long findPuntoAsignado(Long idQueja){
        return repositorio.findPuntoAsignado(idQueja);
    }

}
