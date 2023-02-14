package com.desa.miprestamito.modelo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

@Entity
@Table(name = "cargo")
public class Cargo  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_cargo;

    @Column(name= "nombre_cargo", nullable = false, unique = true)
    private String nombre_cargo;

    @Column(name= "descripcion", nullable = false)
    private String descripcion;

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

    @Column(name= "estado", nullable = false)
    private Long estado;


    public Cargo() {
    }

    public Cargo(Long id_cargo, String nombre_cargo, String descripcion, Long usuariocreo, Calendar fechacreacion, Calendar fechamodificacion, Long usuariomodifico, Long estado) {
        this.id_cargo = id_cargo;
        this.nombre_cargo = nombre_cargo;
        this.descripcion = descripcion;
        this.usuariocreo = usuariocreo;
        this.fechacreacion = fechacreacion;
        this.fechamodificacion = fechamodificacion;
        this.usuariomodifico = usuariomodifico;
        this.estado = estado;
    }

    public Long getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(Long id_cargo) {
        this.id_cargo = id_cargo;
    }

    public String getNombre_cargo() {
        return nombre_cargo;
    }

    public void setNombre_cargo(String nombre_cargo) {
        this.nombre_cargo = nombre_cargo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public Long getEstado() {
        return estado;
    }

    public void setEstado(Long estado) {
        this.estado = estado;
    }
}
