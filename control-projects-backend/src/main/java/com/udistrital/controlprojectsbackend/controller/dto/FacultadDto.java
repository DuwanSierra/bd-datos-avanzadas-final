package com.udistrital.controlprojectsbackend.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FacultadDto {
    private String facultadNombre;
    private SedeDto sede;
    private List<TelefonoDto> telefonos;
}
