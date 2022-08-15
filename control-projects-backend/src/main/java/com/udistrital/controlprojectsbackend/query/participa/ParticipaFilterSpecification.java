package com.udistrital.controlprojectsbackend.query.participa;

import com.udistrital.controlprojectsbackend.repository.entity.ParticipaEntity;
import com.udistrital.controlprojectsbackend.repository.entity.ProyectoInvestigacionEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ParticipaFilterSpecification implements Specification<ParticipaEntity> {
    private ProyectoInvestigacionEntity _proyectoInvestigacionEntity;
    public ParticipaFilterSpecification(ProyectoInvestigacionEntity proyectoInvestigacionEntity){
        _proyectoInvestigacionEntity = proyectoInvestigacionEntity;
    }
    @Override
    public Predicate toPredicate(Root<ParticipaEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if(_proyectoInvestigacionEntity!=null){
            return criteriaBuilder.equal(root.get("proyecto"),_proyectoInvestigacionEntity);
        }
        return null;
    }
}
