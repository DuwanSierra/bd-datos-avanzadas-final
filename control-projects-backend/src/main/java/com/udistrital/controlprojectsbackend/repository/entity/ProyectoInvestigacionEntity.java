package com.udistrital.controlprojectsbackend.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "proyecto_investigacion", indexes = {
        @Index(name = "idx_grupo_proyecto_Id", columnList = "codigoGrupo"),
        @Index(name = "idx_grupo_nombre_proyecto_Id", columnList = "nombreGrupo"),
        @Index(name = "idx_proyecto_Id", columnList = "codigoProyecto")
})
@Data
@IdClass(ProyectoInvestigacionId.class)
public class ProyectoInvestigacionEntity {
    @Id
    @ManyToOne(optional = false)
    @JoinColumns(value = {
            @JoinColumn(name = "codigoGrupo", referencedColumnName = "codigoGrupo", nullable = false),
            @JoinColumn(name = "nombreGrupo", referencedColumnName = "nombreGrupo", nullable = false)
    }, foreignKey = @ForeignKey(name = "FK_PROYECTO_INVESTIGACION_GRUPO"))
    private GrupoInvestigacionEntity grupoInvestigacion;
    @Id
    private String codigoProyecto;
    @NotEmpty
    @Column(nullable = false)
    @Size(max = 70, message = "El nombre del proyecto debe ser alfanúmerico no mayor a 70 carácteres")
    private String nombre;
    @NotEmpty
    @Column(nullable = false)
    private BigDecimal valorPres;
    @NotEmpty
    @Column(nullable = false)
    private Date fechaInicio;
    @NotEmpty
    @Column(nullable = false)
    private Date fechaTerminacion;
}
