package com.udistrital.controlprojectsbackend.repository.entity_repository;

import com.udistrital.controlprojectsbackend.repository.entity.ProfesorEntity;
import com.udistrital.controlprojectsbackend.repository.entity.TituloEntity;
import com.udistrital.controlprojectsbackend.repository.entity.TituloId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TituloRepository extends JpaRepository<TituloEntity, TituloId> {
    void deleteAllByProfesor(ProfesorEntity profesor);
}
