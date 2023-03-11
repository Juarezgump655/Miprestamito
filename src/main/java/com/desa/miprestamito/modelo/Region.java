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
@Table(name = "region")
public class Region implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_region", unique = true, nullable = false)
    private Long idRegion;


    @Column(name ="nombre", nullable =false)
    private String nombre;

    @Column(name ="usuariocreo", nullable =false)
    private String  usuariocreo;


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



}
