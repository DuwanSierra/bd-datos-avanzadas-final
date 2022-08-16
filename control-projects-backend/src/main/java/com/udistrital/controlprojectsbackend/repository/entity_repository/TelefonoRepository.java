package com.udistrital.controlprojectsbackend.repository.entity_repository;

import com.udistrital.controlprojectsbackend.repository.entity.FacultadEntity;
import com.udistrital.controlprojectsbackend.repository.entity.TelefonoEntity;
import com.udistrital.controlprojectsbackend.repository.entity.TelefonoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TelefonoRepository extends JpaRepository<TelefonoEntity, TelefonoId> {
    @Transactional
    void deleteAllByFacultad(FacultadEntity facultad);
    List<TelefonoEntity> findAllByFacultad(FacultadEntity facultad);
}
