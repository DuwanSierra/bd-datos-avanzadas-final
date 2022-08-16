package com.udistrital.controlprojectsbackend.query.proyectoinvestigacion;

import com.udistrital.controlprojectsbackend.controller.dto.GrupoInvestigacionDto;
import com.udistrital.controlprojectsbackend.controller.dto.ProyectoInvestigacionDto;
import com.udistrital.controlprojectsbackend.exceptions.NotFoundException;
import com.udistrital.controlprojectsbackend.mappers.GrupoInvestigacionMapper;
import com.udistrital.controlprojectsbackend.mappers.ProyectoInvestigacionMapper;
import com.udistrital.controlprojectsbackend.query.grupoinvestigacion.FindGrupoInvestigacionByIdQuery;
import com.udistrital.controlprojectsbackend.repository.entity.GrupoInvestigacionEntity;
import com.udistrital.controlprojectsbackend.repository.entity.GrupoInvestigacionId;
import com.udistrital.controlprojectsbackend.repository.entity.ProyectoInvestigacionEntity;
import com.udistrital.controlprojectsbackend.repository.entity.ProyectoInvestigacionId;
import com.udistrital.controlprojectsbackend.repository.entity_repository.GrupoInvestigacionRepository;
import com.udistrital.controlprojectsbackend.repository.entity_repository.ProyectoInvestigacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class FindProyectoInvestigacionByIdQueryHandler implements FindProyectoInvestigacionByIdQuery {

    private final ProyectoInvestigacionRepository _proyectoInvestigacionRepository;
    private final FindGrupoInvestigacionByIdQuery _findGrupoInvestigacionByIdQuery;
    private final GrupoInvestigacionMapper _grupoInvestigacionMapper;
    private final ProyectoInvestigacionMapper _proyectoInvestigacionMapper;

    @Autowired
    public FindProyectoInvestigacionByIdQueryHandler(
            ProyectoInvestigacionRepository proyectoInvestigacionRepository,
            FindGrupoInvestigacionByIdQuery findGrupoInvestigacionByIdQuery,
            GrupoInvestigacionMapper grupoInvestigacionMapper,
            ProyectoInvestigacionMapper proyectoInvestigacionMapper
    ){
        _proyectoInvestigacionRepository = proyectoInvestigacionRepository;
        _findGrupoInvestigacionByIdQuery = findGrupoInvestigacionByIdQuery;
        _grupoInvestigacionMapper = grupoInvestigacionMapper;
        _proyectoInvestigacionMapper = proyectoInvestigacionMapper;
    }

    @Override
    public Mono<ProyectoInvestigacionDto> FindProyectoInvestigacionByid(String nombreGrupo, String codigoGrupo, String codigo) {
        return Mono.fromCallable(() -> {
            GrupoInvestigacionDto grupoInvestigacionDto = _findGrupoInvestigacionByIdQuery.FindGrupoInvestigacionByid(nombreGrupo,codigoGrupo).block();
            GrupoInvestigacionEntity grupoInvestigacionEntity = _grupoInvestigacionMapper.convertGrupoInvestigacionDtoToGrupoInvestigacionEntity(grupoInvestigacionDto);
            ProyectoInvestigacionId proyectoInvestigacionId = new ProyectoInvestigacionId(null,codigo);
            ProyectoInvestigacionEntity proyectoInvestigacionEntity = _proyectoInvestigacionRepository.findById(proyectoInvestigacionId).orElse(null);
            if (proyectoInvestigacionEntity == null) {
                throw new NotFoundException("No se ha encontrado el proyecto de investigación", "ProyectoInvestigacionNotFound");
            }
            return _proyectoInvestigacionMapper.convertProyectoInvestigacionEntityToProyectoInvestigacionDto(proyectoInvestigacionEntity);
        });
    }
}
