package com.udistrital.controlprojectsbackend.repository.entity_repository;

import com.udistrital.controlprojectsbackend.repository.reports.ReporteProyectoProfesorView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportsRepository extends JpaRepository<ReporteProyectoProfesorView, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM VISTA_DETERMINADO_PROFESOR_PROYECTO where cedulaprofesor = :cedula")
    List<ReporteProyectoProfesorView> FindAllProjectsByProfessor(@Param("cedula") Long cedula);
}
