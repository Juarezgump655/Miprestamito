package com.desa.miprestamito.modelo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor
@Setter
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
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraIngreso;

    @Column(name ="detalle_queja", nullable =false)
    private String detalleQueja;


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

    @Column(name ="id_tipo_queja", nullable =false)
    private Long idTipoQueja;


    @Column(name ="id_estado", nullable =false)
    private Long idEstado;

}
