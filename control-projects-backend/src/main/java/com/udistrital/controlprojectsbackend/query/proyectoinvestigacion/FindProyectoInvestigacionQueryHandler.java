package com.udistrital.controlprojectsbackend.query.proyectoinvestigacion;

import com.udistrital.controlprojectsbackend.controller.dto.ProyectoInvestigacionDto;
import com.udistrital.controlprojectsbackend.mappers.ProyectoInvestigacionMapper;
import com.udistrital.controlprojectsbackend.repository.entity.ProyectoInvestigacionEntity;
import com.udistrital.controlprojectsbackend.repository.entity_repository.ProyectoInvestigacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class FindProyectoInvestigacionQueryHandler implements FindProyectoInvestigacionQuery {
    private final ProyectoInvestigacionRepository _proyectoInvestigacionRepository;
    private final ProyectoInvestigacionMapper _proyectoInvestigacionMapper;

    @Autowired
    public FindProyectoInvestigacionQueryHandler(
            ProyectoInvestigacionRepository proyectoInvestigacionRepository,
            ProyectoInvestigacionMapper proyectoInvestigacionMapper
    ) {
        _proyectoInvestigacionRepository = proyectoInvestigacionRepository;
        _proyectoInvestigacionMapper = proyectoInvestigacionMapper;
    }
    @Override
    public Mono<Page<ProyectoInvestigacionDto>> FindAllProyectoInvestigacion(long page, long size){
        return Mono.fromCallable(() -> {
            Pageable pageToFind = PageRequest.of(Integer.parseInt(String.valueOf(page)), Integer.parseInt(String.valueOf(size)));
            Page<ProyectoInvestigacionEntity> total = _proyectoInvestigacionRepository.findAll(pageToFind);
            return total.map(_proyectoInvestigacionMapper::convertProyectoInvestigacionEntityToProyectoInvestigacionDto);
        });
    }
}
