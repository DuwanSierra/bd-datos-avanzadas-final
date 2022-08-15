package com.udistrital.controlprojectsbackend.repository.entity_repository;

import com.udistrital.controlprojectsbackend.repository.entity.ParticipaEntity;
import com.udistrital.controlprojectsbackend.repository.entity.ParticipaId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipaRepository extends JpaRepository<ParticipaEntity, ParticipaId> {
    Page<ParticipaEntity> findAll(Specification<ParticipaEntity> entitySpecification, Pageable pageable);
}
