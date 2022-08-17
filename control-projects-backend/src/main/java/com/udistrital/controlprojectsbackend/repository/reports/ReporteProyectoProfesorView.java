package com.udistrital.controlprojectsbackend.repository.reports;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Immutable
public class ReporteProyectoProfesorView {
    @Id
    private Long id;
    private String codigogrupo;
    private String nombregrupo;
    private String codigoproyecto;
    private String nombreproyecto;
    private Long cedulaprofesor;
    private String nombreprofesor;
}
