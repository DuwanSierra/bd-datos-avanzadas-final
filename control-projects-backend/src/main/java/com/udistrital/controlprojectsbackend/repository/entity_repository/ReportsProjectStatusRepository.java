package com.udistrital.controlprojectsbackend.repository.entity_repository;

import com.udistrital.controlprojectsbackend.repository.reports.ReportProjectsActivesInactivesView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportsProjectStatusRepository extends JpaRepository<ReportProjectsActivesInactivesView, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM VISTA_PROYECTO_ESTADO")
    List<ReportProjectsActivesInactivesView> FindAllProjectsActiveInactive();
}
