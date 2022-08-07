package com.udistrital.controlprojectsbackend.controller.dto;

import com.udistrital.controlprojectsbackend.repository.entity.ProfesorEntity;
import com.udistrital.controlprojectsbackend.repository.entity.SedeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FactultadDto {
    private String facultadNombre;
    private ProfesorEntity decano;
    private SedeEntity sede;
}
