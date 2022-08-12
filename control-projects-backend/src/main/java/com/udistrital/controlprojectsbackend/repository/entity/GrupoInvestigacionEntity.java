package com.udistrital.controlprojectsbackend.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "grupo_investigacion", indexes = {
        @Index(name = "idx_grupo_investigacion_nombre_id", columnList = "nombreGrupo"),
        @Index(name = "idx_grupo_investigacion_codigo_id", columnList = "codigoGrupo")
})
@Data
@IdClass(GrupoInvestigacionId.class)
public class GrupoInvestigacionEntity {
    @Id
    private String codigoGrupo;
    @Id
    private String nombreGrupo;
    @ManyToOne
    @JoinColumn(name = "FK_Nombre_Facultad", nullable = false, foreignKey = @ForeignKey(name = "FK_GRUPO_INVESTIGACION_FACULTAD"))
    private FacultadEntity facultad;
    @ManyToOne
    @JoinColumn(name = "FK_Id_Area_Interes", nullable = false, foreignKey = @ForeignKey(name = "FK_GRUPO_INVESTIGACION_AREA_INTERES"))
    private AreaInteresEntity areaInteres;
    @ManyToOne
    @JoinColumn(name = "FK_Cedula_Profesor", nullable = false, foreignKey = @ForeignKey(name = "FK_GRUPO_INVESTIGACION_PROFESOR"))
    private ProfesorEntity profesor;
}
