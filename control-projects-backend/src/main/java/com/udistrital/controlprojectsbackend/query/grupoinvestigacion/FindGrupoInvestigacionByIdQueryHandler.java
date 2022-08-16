package com.udistrital.controlprojectsbackend.query.grupoinvestigacion;

import com.udistrital.controlprojectsbackend.controller.dto.FacultadDto;
import com.udistrital.controlprojectsbackend.controller.dto.GrupoInvestigacionDto;
import com.udistrital.controlprojectsbackend.exceptions.NotFoundException;
import com.udistrital.controlprojectsbackend.mappers.FacultadMapper;
import com.udistrital.controlprojectsbackend.mappers.GrupoInvestigacionMapper;
import com.udistrital.controlprojectsbackend.mappers.TelefonoMapper;
import com.udistrital.controlprojectsbackend.repository.entity.FacultadEntity;
import com.udistrital.controlprojectsbackend.repository.entity.GrupoInvestigacionEntity;
import com.udistrital.controlprojectsbackend.repository.entity.GrupoInvestigacionId;
import com.udistrital.controlprojectsbackend.repository.entity.TelefonoEntity;
import com.udistrital.controlprojectsbackend.repository.entity_repository.FacultadRepository;
import com.udistrital.controlprojectsbackend.repository.entity_repository.GrupoInvestigacionRepository;
import com.udistrital.controlprojectsbackend.repository.entity_repository.TelefonoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class FindGrupoInvestigacionByIdQueryHandler implements FindGrupoInvestigacionByIdQuery {

    private final GrupoInvestigacionRepository _grupoInvestigacionRepository;
    private final GrupoInvestigacionMapper _grupoInvestigacionMapper;

    @Autowired
    public FindGrupoInvestigacionByIdQueryHandler(
            GrupoInvestigacionRepository grupoInvestigacionRepository,
            GrupoInvestigacionMapper grupoInvestigacionMapper
    ) {
        _grupoInvestigacionRepository = grupoInvestigacionRepository;
        _grupoInvestigacionMapper = grupoInvestigacionMapper;
    }

    @Override
    public Mono<GrupoInvestigacionDto> FindGrupoInvestigacionByid(String nombre, String codigo) {
        return Mono.fromCallable(() -> {
            GrupoInvestigacionId id = new GrupoInvestigacionId(codigo,nombre);
            GrupoInvestigacionEntity grupoInvestigacionEntity = _grupoInvestigacionRepository.findById(id).orElse(null);
            if (grupoInvestigacionEntity == null) {
                throw new NotFoundException("No se ha encontrado el grupo de investigación", "GrupoInvestigacionNotFound");
            }
            return _grupoInvestigacionMapper.convertGrupoInvestigacionEntityToGrupoInvestigacionDto(grupoInvestigacionEntity);
        });
    }
}
