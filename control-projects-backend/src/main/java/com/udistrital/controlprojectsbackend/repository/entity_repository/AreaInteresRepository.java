package com.udistrital.controlprojectsbackend.repository.entity_repository;

import com.udistrital.controlprojectsbackend.repository.entity.AreaInteresEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;

@Repository
public interface AreaInteresRepository extends JpaRepository<AreaInteresEntity, Long> {
    Page<AreaInteresEntity> findAll(Pageable pageable);
}
