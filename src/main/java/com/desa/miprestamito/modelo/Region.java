package com.desa.miprestamito.modelo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

@Entity
@Table(name = "region")
public class Region implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_region", unique = true, nullable = false)
    private Long idRegion;


    @Column(name ="nombre", nullable =false)
    private String nombre;

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

    public Region() {
    }

    public Region(Long idRegion, String nombre, Long usuariocreo, Calendar fechacreacion, Calendar fechamodificacion, Long usuariomodifico) {
        this.idRegion = idRegion;
        this.nombre = nombre;
        this.usuariocreo = usuariocreo;
        this.fechacreacion = fechacreacion;
        this.fechamodificacion = fechamodificacion;
        this.usuariomodifico = usuariomodifico;
    }

    public Long getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(Long idRegion) {
        this.idRegion = idRegion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
}
