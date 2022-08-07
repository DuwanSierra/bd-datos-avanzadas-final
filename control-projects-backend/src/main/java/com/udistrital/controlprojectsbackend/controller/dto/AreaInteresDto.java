package com.udistrital.controlprojectsbackend.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class AreaInteresDto {
    private Long areaId;
    @NotEmpty
    @Size(max = 70, message = "El nombre del área de interés debe ser alfanúmerico no mayor a 70 carácteres")
    private String areaNombre;
}
