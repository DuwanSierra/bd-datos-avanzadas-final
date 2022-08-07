package com.udistrital.controlprojectsbackend.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "decano_facultad", indexes = {
        @Index(name = "idx_decano_facultad_id", columnList = "decanoFacultadId")
})
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DecanoFacultadEntity {
    @Id
    private Long decanoFacultadId;
    @ManyToOne
    @JoinColumn(name = "decano_cedula_profesor")
    private ProfesorEntity decano;
    @ManyToOne
    @JoinColumn(name = "facultad_facultad_nombre")
    private FacultadEntity facultad;
    private Date fechaInicio;
    private Date fechaFin;
}
