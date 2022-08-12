package com.udistrital.controlprojectsbackend.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ParticipaId implements Serializable {
    private ProfesorEntity profesor;
    private ProyectoInvestigacionEntity proyecto;
}
