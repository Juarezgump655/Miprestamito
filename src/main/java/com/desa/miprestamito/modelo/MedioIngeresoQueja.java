package com.desa.miprestamito.modelo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "medio_ingreso_queja")
@Getter
@Setter
@NoArgsConstructor
public class MedioIngeresoQueja implements Serializable {


    @Id
    @Column(name ="id_medio_ingreso_queja", unique = true, nullable = false)
    private Long idMedioIngresoQueja;


    @Column(name ="nombre_medio", nullable =false)
    private String nombreMedio;
}
