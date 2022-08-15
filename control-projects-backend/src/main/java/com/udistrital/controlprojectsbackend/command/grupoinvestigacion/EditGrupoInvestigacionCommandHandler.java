package com.udistrital.controlprojectsbackend.command.grupoinvestigacion;

import com.udistrital.controlprojectsbackend.controller.dto.GrupoInvestigacionDto;
import com.udistrital.controlprojectsbackend.controller.dto.SedeDto;
import com.udistrital.controlprojectsbackend.exceptions.ConflictException;
import com.udistrital.controlprojectsbackend.exceptions.NotFoundException;
import com.udistrital.controlprojectsbackend.mappers.GrupoInvestigacionMapper;
import com.udistrital.controlprojectsbackend.mappers.SedeMapper;
import com.udistrital.controlprojectsbackend.repository.entity.FacultadEntity;
import com.udistrital.controlprojectsbackend.repository.entity.GrupoInvestigacionEntity;
import com.udistrital.controlprojectsbackend.repository.entity.GrupoInvestigacionId;
import com.udistrital.controlprojectsbackend.repository.entity.SedeEntity;
import com.udistrital.controlprojectsbackend.repository.entity_repository.GrupoInvestigacionRepository;
import com.udistrital.controlprojectsbackend.repository.entity_repository.SedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class EditGrupoInvestigacionCommandHandler implements EditGrupoInvestigacionCommand {
    private final GrupoInvestigacionRepository _grupoInvestigacionRepository;
    private final GrupoInvestigacionMapper _grupoInvestigacionMapper;

    @Autowired
    public EditGrupoInvestigacionCommandHandler(
            GrupoInvestigacionRepository grupoInvestigacionRepository,
            GrupoInvestigacionMapper grupoInvestigacionMapper) {
        _grupoInvestigacionRepository = grupoInvestigacionRepository;
        _grupoInvestigacionMapper = grupoInvestigacionMapper;
    }
    @Override
    public Mono<GrupoInvestigacionDto> EditGrupoInvestigacion(GrupoInvestigacionDto grupoInvestigacionDto, String nombre, String codigo) {
        return Mono.fromCallable(() -> {
            GrupoInvestigacionId id = new GrupoInvestigacionId(codigo,nombre);
            GrupoInvestigacionEntity grupoInvestigacionEntity = _grupoInvestigacionRepository.findById(id).orElse(null);
            if(grupoInvestigacionEntity==null){
                throw new NotFoundException("No se ha encontrado el el grupo de investigación", "GrupoInvestigacionNotFound");
            }
            try {
                grupoInvestigacionEntity = _grupoInvestigacionMapper.convertGrupoInvestigacionDtoToGrupoInvestigacionEntity(grupoInvestigacionDto);
                grupoInvestigacionEntity = _grupoInvestigacionRepository.save(grupoInvestigacionEntity);
                return _grupoInvestigacionMapper.convertGrupoInvestigacionEntityToGrupoInvestigacionDto(grupoInvestigacionEntity);
            } catch (Exception e) {
                throw new ConflictException("No se pudo crear el grupo de investigación", e.getMessage());
            }
        });
    }
}
