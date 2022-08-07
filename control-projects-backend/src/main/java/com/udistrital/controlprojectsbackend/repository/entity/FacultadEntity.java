package com.udistrital.controlprojectsbackend.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "facultad", indexes = {
        @Index(name = "idx_facultad_nombre", columnList = "facultadNombre")
})
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FacultadEntity {
    @Id
    private String facultadNombre;
    @ManyToOne
    @JoinColumn(name="sedeId", nullable=false)
    private SedeEntity sede;
}
