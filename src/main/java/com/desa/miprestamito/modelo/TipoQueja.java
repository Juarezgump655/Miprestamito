package com.desa.miprestamito.modelo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

@Entity
@Table(name = "tipo_quejas")
@Getter
@Setter
public class TipoQueja  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_tipo_queja", unique = true, nullable = false)
    private Long idTipoQueja;

    @Column(name ="siglas_queja", nullable =false)
    private String siglasQueja;


    @Column(name ="descripcion_queja", nullable =false)
    private String descripcionQueja;

    @Column(name ="usuariocreo", nullable =false)
    private String usuariocreo;


    @Column(name = "fechacreacion", insertable = false,updatable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Calendar fechacreacion;

    @Column(name = "fechamodificacion", insertable = false, updatable = true,columnDefinition = "DATE DEFAULT CURRENT_DATE")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Calendar fechamodificacion;

    @Column(name ="usuariomodifico", nullable =false)
    private String usuariomodifico;

    @Column(name ="id_estado", nullable =false)
    private Long idEstado;

}
