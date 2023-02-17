package com.desa.miprestamito.modelo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "queja")
public class Queja implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_queja", unique = true, nullable = false)
    private Long idQueja;

    @Column(name ="id_medio_ingreso_queja", nullable =false)
    private Long idMedioIngresoQueja;

    @Column(name ="id_documento", nullable =false)
    private Long idDocumento;

    @Column(name ="idusuario", nullable =false)
    private Long idUsuario;

    @Column(name ="fecha_hora_ingreso", nullable =false)
    @Temporal(TemporalType.DATE)
    private Date fechaHoraIngreso;

    @Column(name ="detalle_queja", nullable =false)
    private Long detalleQueja;


    @Column(name ="usuariocreo", nullable =false)
    private Long usuariocreo;


    @Column(name = "fechacreacion", updatable = false, nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Calendar fechacreacion;

    @Column(name = "fechamodificacion", nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Calendar fechamodificacion;

    @Column(name ="usuariomodifico", nullable =false)
    private Long usuariomodifico;

    @Column(name ="id_tipo_queja", nullable =false)
    private Long idTipoQueja;


    @Column(name ="id_estado", nullable =false)
    private Long idEstado;

    public Queja() {
    }

    public Queja(Long idQueja, Long idMedioIngresoQueja, Long idDocumento, Long idUsuario, Date fechaHoraIngreso, Long detalleQueja, Long usuariocreo, Calendar fechacreacion, Calendar fechamodificacion, Long usuariomodifico, Long idTipoQueja, Long idEstado) {
        this.idQueja = idQueja;
        this.idMedioIngresoQueja = idMedioIngresoQueja;
        this.idDocumento = idDocumento;
        this.idUsuario = idUsuario;
        this.fechaHoraIngreso = fechaHoraIngreso;
        this.detalleQueja = detalleQueja;
        this.usuariocreo = usuariocreo;
        this.fechacreacion = fechacreacion;
        this.fechamodificacion = fechamodificacion;
        this.usuariomodifico = usuariomodifico;
        this.idTipoQueja = idTipoQueja;
        this.idEstado = idEstado;
    }

    public Long getIdQueja() {
        return idQueja;
    }

    public void setIdQueja(Long idQueja) {
        this.idQueja = idQueja;
    }

    public Long getIdMedioIngresoQueja() {
        return idMedioIngresoQueja;
    }

    public void setIdMedioIngresoQueja(Long idMedioIngresoQueja) {
        this.idMedioIngresoQueja = idMedioIngresoQueja;
    }

    public Long getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Long idDocumento) {
        this.idDocumento = idDocumento;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getFechaHoraIngreso() {
        return fechaHoraIngreso;
    }

    public void setFechaHoraIngreso(Date fechaHoraIngreso) {
        this.fechaHoraIngreso = fechaHoraIngreso;
    }

    public Long getDetalleQueja() {
        return detalleQueja;
    }

    public void setDetalleQueja(Long detalleQueja) {
        this.detalleQueja = detalleQueja;
    }

    public Long getUsuariocreo() {
        return usuariocreo;
    }

    public void setUsuariocreo(Long usuariocreo) {
        this.usuariocreo = usuariocreo;
    }

    public Calendar getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Calendar fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public Calendar getFechamodificacion() {
        return fechamodificacion;
    }

    public void setFechamodificacion(Calendar fechamodificacion) {
        this.fechamodificacion = fechamodificacion;
    }

    public Long getUsuariomodifico() {
        return usuariomodifico;
    }

    public void setUsuariomodifico(Long usuariomodifico) {
        this.usuariomodifico = usuariomodifico;
    }

    public Long getIdTipoQueja() {
        return idTipoQueja;
    }

    public void setIdTipoQueja(Long idTipoQueja) {
        this.idTipoQueja = idTipoQueja;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }
}
