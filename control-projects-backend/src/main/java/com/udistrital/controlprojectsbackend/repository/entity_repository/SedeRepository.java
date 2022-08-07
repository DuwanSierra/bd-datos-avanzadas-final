package com.udistrital.controlprojectsbackend.repository.entity_repository;

import com.udistrital.controlprojectsbackend.repository.entity.SedeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SedeRepository extends JpaRepository<SedeEntity, Long> {
    Page<SedeEntity> findAll(Pageable pageable);
}
