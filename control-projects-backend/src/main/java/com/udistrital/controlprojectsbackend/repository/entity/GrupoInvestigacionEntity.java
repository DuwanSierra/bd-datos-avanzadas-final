package com.udistrital.controlprojectsbackend.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "grupo_investigacion", indexes = {
        @Index(name = "idx_grupo_investigacion_nombre_id", columnList = "nombreGrupoInvestigacion", unique = true),
        @Index(name = "idx_grupo_investigacion_codigo_id", columnList = "codigoGrupoInvestigacion", unique = true)
})
@Data
@IdClass(GrupoInvestigacionId.class)
public class GrupoInvestigacionEntity {
    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "facultad_nombre", nullable = false)
    public FacultadEntity facultad;
    @Id
    private String nombreGrupoInvestigacion;
    @Id
    private Long codigoGrupoInvestigacion;
    @ManyToOne
    @JoinColumn(name = "area_interes_area_id")
    private AreaInteresEntity areaInteres;
}
