package com.udistrital.controlprojectsbackend.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "proyecto_investigacion", indexes = {
        @Index(name = "idx_codigo_proyecto", columnList = "codigoProyecto")
})
@Data
public class ProyectoInvestigacionEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long codigoProyecto;

}
