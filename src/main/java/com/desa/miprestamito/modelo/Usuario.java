package com.desa.miprestamito.modelo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idusuario;


    @Column(name= "DPI", nullable = false,unique = true)
    private String nit;

    @Column(name= "nombre", nullable = false)
    private String nombre;

    @Column(name= "apellidos", nullable = false)
    private String apellidos;

    @Column(name= "correo",unique = true, nullable = false)
    private String correo;

    @Column(name= "id_cargo", nullable = false)
    private Long id_cargo;

    @Column(name= "estado", nullable = false)
    private Long estado;

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

    @Column(name="password", nullable = false)
    private String password;
    @Column(name ="rol", nullable =false)
    private Long rol;

    @Column(name= "id_puntoatencion")
    private Long idpuntoatecion;

    public Usuario() {
    }

    public Usuario(Long idusuario, String nit, String nombre, String apellidos, String correo, Long id_cargo, Long estado, Long usuariocreo, Calendar fechacreacion, Calendar fechamodificacion, Long usuariomodifico, String password, Long rol, Long idpuntoatecion) {
        this.idusuario = idusuario;
        this.nit = nit;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.id_cargo = id_cargo;
        this.estado = estado;
        this.usuariocreo = usuariocreo;
        this.fechacreacion = fechacreacion;
        this.fechamodificacion = fechamodificacion;
        this.usuariomodifico = usuariomodifico;
        this.password = password;
        this.rol = rol;
        this.idpuntoatecion = idpuntoatecion;
    }

    public Long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Long idusuario) {
        this.idusuario = idusuario;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Long getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(Long id_cargo) {
        this.id_cargo = id_cargo;
    }

    public Long getEstado() {
        return estado;
    }

    public void setEstado(Long estado) {
        this.estado = estado;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getRol() {
        return rol;
    }

    public void setRol(Long rol) {
        this.rol = rol;
    }

    public Long getIdpuntoatecion() {
        return idpuntoatecion;
    }

    public void setIdpuntoatecion(Long idpuntoatecion) {
        this.idpuntoatecion = idpuntoatecion;
    }
}
