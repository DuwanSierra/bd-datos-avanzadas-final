package com.udistrital.controlprojectsbackend.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class SedeDto {
    private Long sedeId;
    private String nombre;
}
