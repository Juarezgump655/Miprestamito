package com.desa.miprestamito.modelo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
@Getter
@Setter
@Entity
@Table(name = "usuarios")
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idusuario;


    @Column(name= "dpi", nullable = false,unique = true)
    private String dpi;

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
    private String usuariocreo;


    @Column(name = "fechacreacion", updatable = false)
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Calendar fechacreacion;

    @Column(name = "fechamodificacion")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Calendar fechamodificacion;

    @Column(name ="usuariomodifico", nullable =false)
    private String usuariomodifico;

    @Column(name="password", nullable = false)
    private String password;
    @Column(name ="rol", nullable =false)
    private Long rol;

    @Column(name= "id_puntoatencion")
    private Long idpuntoatecion;

    @Column(name= "no_telefono",nullable = false)
    private String telefono;

}
