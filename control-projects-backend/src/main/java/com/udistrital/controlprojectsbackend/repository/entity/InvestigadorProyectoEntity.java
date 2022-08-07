package com.udistrital.controlprojectsbackend.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "investigador_proyecto", indexes = {
        @Index(name = "idx_investigador_proyecto_id", columnList = "investigadorProyectoId")
})
@Data
public class InvestigadorProyectoEntity {
    @Id
    private Long investigadorProyectoId;
    @ManyToOne
    @JoinColumn(name = "investigador_cedula_profesor")
    private ProfesorEntity investigador;
    @ManyToOne
    @JoinColumn(name = "proyecto_investigacion_proyecto_id")
    private ProyectoInvestigacionEntity proyectoInvestigacion;
    @NotEmpty
    @Column(nullable = false)
    private Date fechaInicioInvestigacion;
    @NotEmpty
    @Column(nullable = false)
    private Date fechaFinInvestigacion;
    @NotEmpty
    @Column(nullable = false)
    private Long rolDesarrollaInvestigacion;
}
