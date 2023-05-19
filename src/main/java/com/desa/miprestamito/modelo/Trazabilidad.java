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
@Table(name = "trazabilidad")
@Getter
@Setter
@NoArgsConstructor
public class Trazabilidad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "id_trazabilidad")
    private Long idTrazabilidad;

    @Column(name = "id_estadosolicitud", nullable = false)
    private Long idEstadoSolicitud;

    @Column(name = "id_solicitud", nullable = false)
    private Long idSolicitud;

    @Column(name ="usuario_ingreso", nullable =false)
    private String usuarioIngreso;


    @Column(name = "fecha_ingreso", columnDefinition = "DATE DEFAULT CURRENT_DATE", updatable = false, insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngreso;

    @Column(name = "fechamodifico")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Calendar fechaModifico;

    @Column(name ="usuariomodifico")
    private String usuariomodifico;

    @Column(name="estado_registro")
    private Long estadoRegistro;


    public Trazabilidad(Long idEstadoSolicitud, Long idSolicitud, String usuarioIngreso) {
        this.idEstadoSolicitud = idEstadoSolicitud;
        this.idSolicitud = idSolicitud;
        this.usuarioIngreso = usuarioIngreso;
    }
}
