package com.desa.miprestamito.modelo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor
@Setter
@Table(name = "puntos_atencion")
public class PuntosAtencion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_punto_atencion",unique = true)
    private Long iDpuntoAtencion;

    @Column(name ="id_region",  nullable = false)
    private Long idRegion;
    @Column(name= "nombre_punto_atencion", nullable = false)
    private String nombrePuntoAtencion;

    @Column(name ="usuariocreo", nullable =false)
    private String usuariocreo;

    @Column(name = "fechacreacion", insertable = false,updatable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Date fechacreacion;

    @Column(name = "fechamodificacion",insertable = false, updatable = true,columnDefinition = "DATE DEFAULT CURRENT_DATE")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Date fechamodificacion;

    @Column(name ="usuariomodifico", nullable =false)
    private String usuariomodifico;


    @Column(name= "id_estado", nullable = false)
    private Long estado;


}
