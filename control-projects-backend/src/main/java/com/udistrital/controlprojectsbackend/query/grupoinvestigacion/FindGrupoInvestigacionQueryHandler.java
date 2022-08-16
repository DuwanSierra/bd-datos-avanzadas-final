package com.udistrital.controlprojectsbackend.query.grupoinvestigacion;

import com.udistrital.controlprojectsbackend.controller.dto.FacultadDto;
import com.udistrital.controlprojectsbackend.controller.dto.GrupoInvestigacionDto;
import com.udistrital.controlprojectsbackend.mappers.FacultadMapper;
import com.udistrital.controlprojectsbackend.mappers.GrupoInvestigacionMapper;
import com.udistrital.controlprojectsbackend.mappers.TelefonoMapper;
import com.udistrital.controlprojectsbackend.repository.entity.FacultadEntity;
import com.udistrital.controlprojectsbackend.repository.entity.GrupoInvestigacionEntity;
import com.udistrital.controlprojectsbackend.repository.entity.TelefonoEntity;
import com.udistrital.controlprojectsbackend.repository.entity_repository.FacultadRepository;
import com.udistrital.controlprojectsbackend.repository.entity_repository.GrupoInvestigacionRepository;
import com.udistrital.controlprojectsbackend.repository.entity_repository.TelefonoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class FindGrupoInvestigacionQueryHandler implements FindGrupoInvestigacionQuery {
    private final GrupoInvestigacionRepository _grupoInvestigacionRepository;
    private final GrupoInvestigacionMapper _grupoInvestigacionMapper;

    @Autowired
    public FindGrupoInvestigacionQueryHandler(
            GrupoInvestigacionRepository grupoInvestigacionRepository,
            GrupoInvestigacionMapper grupoInvestigacionMapper
    ) {
        _grupoInvestigacionRepository = grupoInvestigacionRepository;
        _grupoInvestigacionMapper = grupoInvestigacionMapper;
    }
    @Override
    public Mono<Page<GrupoInvestigacionDto>> FindAllGrupoInvestigacion(long page, long size) {
        return Mono.fromCallable(() -> {
            Pageable pageToFind = PageRequest.of(Integer.parseInt(String.valueOf(page)), Integer.parseInt(String.valueOf(size)));
            Page<GrupoInvestigacionEntity> total = _grupoInvestigacionRepository.findAll(pageToFind);
            return total.map(_grupoInvestigacionMapper::convertGrupoInvestigacionEntityToGrupoInvestigacionDto);
        });
    }
}
