package com.desa.miprestamito.modelo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

@Entity
@Getter
@NoArgsConstructor
@Setter
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
    private String usuariocreo;


    @Column(name = "fechacreacion", updatable = false, nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Calendar fechacreacion;

    @Column(name = "fechamodificacion", nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Calendar fechamodificacion;

    @Column(name ="usuariomodifico", nullable =false)
    private String usuariomodifico;

    @Column(name= "estado", nullable = false)
    private Long estado;


}
