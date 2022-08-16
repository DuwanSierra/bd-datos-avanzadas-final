package com.udistrital.controlprojectsbackend.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProfesorDto {
    private Long cedulaProfesor;
    private String nombreProfesor;
    private Date inicioInvestigacion;
    private Long aniosInvestigacion;
    private FacultadDto facultad;
    private CargoDto cargo;
    private List<TituloDto> titulos;
}
