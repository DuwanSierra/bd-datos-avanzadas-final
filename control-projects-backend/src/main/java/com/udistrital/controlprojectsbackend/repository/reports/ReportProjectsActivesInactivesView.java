package com.udistrital.controlprojectsbackend.repository.reports;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Immutable
public class ReportProjectsActivesInactivesView {
    @Id
    private Long id;
    private String codigoproyecto;
    private String nombreproyecto;
    private Date fechainicio;
    private Date fechaterminacion;
    private String estado;
}
