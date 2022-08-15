package com.udistrital.controlprojectsbackend.query.participa;

import com.udistrital.controlprojectsbackend.controller.dto.ParticipaDto;
import com.udistrital.controlprojectsbackend.controller.dto.ProyectoInvestigacionDto;
import com.udistrital.controlprojectsbackend.mappers.ParticipaMapper;
import com.udistrital.controlprojectsbackend.mappers.ProyectoInvestigacionMapper;
import com.udistrital.controlprojectsbackend.query.profesor.FindProfesorByIdQuery;
import com.udistrital.controlprojectsbackend.query.proyectoinvestigacion.FindProyectoInvestigacionByIdQuery;
import com.udistrital.controlprojectsbackend.repository.entity.ParticipaEntity;
import com.udistrital.controlprojectsbackend.repository.entity.ProyectoInvestigacionEntity;
import com.udistrital.controlprojectsbackend.repository.entity_repository.ParticipaRepository;
import com.udistrital.controlprojectsbackend.repository.entity_repository.ProyectoInvestigacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class FindParticipaQueryHandler implements FindParticipaQuery {
    private final ParticipaRepository _participaRepository;
    private final ParticipaMapper _participaMapper;
    private final ProyectoInvestigacionMapper _proyectoInvestigacionMapper;
    private final FindProyectoInvestigacionByIdQuery _findProyectoInvestigacionByIdQuery;

    @Autowired
    public FindParticipaQueryHandler(
            ParticipaRepository participaRepository,
            ParticipaMapper participaMapper,
            ProyectoInvestigacionMapper proyectoInvestigacionMapper,
            FindProyectoInvestigacionByIdQuery findProyectoInvestigacionByIdQuery
    ) {
        _participaMapper = participaMapper;
        _participaRepository = participaRepository;
        _proyectoInvestigacionMapper = proyectoInvestigacionMapper;
        _findProyectoInvestigacionByIdQuery = findProyectoInvestigacionByIdQuery;
    }

    @Override
    public Mono<Page<ParticipaDto>> FindAllParticipa(long page, long size, String nombreGrupo, String codigoGrupo, String codigoProyecto) {
        return Mono.fromCallable(() -> {
            Pageable pageToFind = PageRequest.of(Integer.parseInt(String.valueOf(page)), Integer.parseInt(String.valueOf(size)));
            Page<ParticipaEntity> total;
            if (nombreGrupo != null && codigoGrupo != null && codigoProyecto != null) {
                ProyectoInvestigacionEntity proyectoInvestigacionEntity = _proyectoInvestigacionMapper.convertProyectoInvestigacionDtoToProyectoInvestigacionEntity(_findProyectoInvestigacionByIdQuery.FindProyectoInvestigacionByid(nombreGrupo, codigoGrupo, codigoProyecto).block());
                Specification<ParticipaEntity> participaEntitySpecification = new ParticipaFilterSpecification(proyectoInvestigacionEntity);
                total = _participaRepository.findAll(participaEntitySpecification,pageToFind);
            }
            else{
                total = _participaRepository.findAll(pageToFind);
            }
            return total.map(_participaMapper::convertParticipaEntityToParticipaDto);
        });
    }
}
