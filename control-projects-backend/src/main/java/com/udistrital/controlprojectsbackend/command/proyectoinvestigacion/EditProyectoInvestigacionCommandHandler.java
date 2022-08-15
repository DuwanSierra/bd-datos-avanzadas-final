package com.udistrital.controlprojectsbackend.command.proyectoinvestigacion;

import com.udistrital.controlprojectsbackend.controller.dto.GrupoInvestigacionDto;
import com.udistrital.controlprojectsbackend.controller.dto.ProyectoInvestigacionDto;
import com.udistrital.controlprojectsbackend.exceptions.ConflictException;
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
public class EditProyectoInvestigacionCommandHandler implements EditProyectoInvestigacionCommand {
    private final ProyectoInvestigacionRepository _proyectoInvestigacionRepository;
    private final FindGrupoInvestigacionByIdQuery _findGrupoInvestigacionByIdQuery;
    private final GrupoInvestigacionMapper _grupoInvestigacionMapper;
    private final ProyectoInvestigacionMapper _proyectoInvestigacionMapper;

    @Autowired
    public EditProyectoInvestigacionCommandHandler(
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
    public Mono<ProyectoInvestigacionDto> EditProyectoInvestigacion(ProyectoInvestigacionDto proyectoInvestigacionDto, String nombreGrupo, String codigoGrupo, String codigoProyecto) {
        return Mono.fromCallable(() -> {
            GrupoInvestigacionDto grupoInvestigacionDto = _findGrupoInvestigacionByIdQuery.FindGrupoInvestigacionByid(nombreGrupo,codigoGrupo).block();
            GrupoInvestigacionEntity grupoInvestigacionEntity = _grupoInvestigacionMapper.convertGrupoInvestigacionDtoToGrupoInvestigacionEntity(grupoInvestigacionDto);
            ProyectoInvestigacionId proyectoInvestigacionId = new ProyectoInvestigacionId(grupoInvestigacionEntity,codigoProyecto);
            ProyectoInvestigacionEntity proyectoInvestigacionEntity = _proyectoInvestigacionRepository.findById(proyectoInvestigacionId).orElse(null);
            if(proyectoInvestigacionEntity==null){
                throw new NotFoundException("No se ha encontrado el el proyecto de investigación", "ProyectoInvestigacionNotFound");
            }
            try {
                proyectoInvestigacionEntity = _proyectoInvestigacionMapper.convertProyectoInvestigacionDtoToProyectoInvestigacionEntity(proyectoInvestigacionDto);
                proyectoInvestigacionEntity.setCodigoProyecto(codigoProyecto);
                proyectoInvestigacionEntity.setGrupoInvestigacion(grupoInvestigacionEntity);
                proyectoInvestigacionEntity = _proyectoInvestigacionRepository.save(proyectoInvestigacionEntity);
                return _proyectoInvestigacionMapper.convertProyectoInvestigacionEntityToProyectoInvestigacionDto(proyectoInvestigacionEntity);
            } catch (Exception e) {
                throw new ConflictException("No se pudo crear el proyecto de investigación", e.getMessage());
            }
        });
    }
}
