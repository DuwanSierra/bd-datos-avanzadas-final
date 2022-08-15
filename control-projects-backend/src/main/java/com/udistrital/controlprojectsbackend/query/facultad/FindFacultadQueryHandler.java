package com.udistrital.controlprojectsbackend.query.facultad;

import com.udistrital.controlprojectsbackend.controller.dto.FacultadDto;
import com.udistrital.controlprojectsbackend.controller.dto.RolDto;
import com.udistrital.controlprojectsbackend.mappers.FacultadMapper;
import com.udistrital.controlprojectsbackend.mappers.RolMapper;
import com.udistrital.controlprojectsbackend.mappers.TelefonoMapper;
import com.udistrital.controlprojectsbackend.repository.entity.FacultadEntity;
import com.udistrital.controlprojectsbackend.repository.entity.RolEntity;
import com.udistrital.controlprojectsbackend.repository.entity.TelefonoEntity;
import com.udistrital.controlprojectsbackend.repository.entity_repository.FacultadRepository;
import com.udistrital.controlprojectsbackend.repository.entity_repository.RolRepository;
import com.udistrital.controlprojectsbackend.repository.entity_repository.TelefonoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class FindFacultadQueryHandler implements FindFacultadQuery {
    private final FacultadRepository _facultadRepository;
    private final TelefonoRepository _telefonoRepository;
    private final FacultadMapper _facultadMapper;
    private final TelefonoMapper _telefonoMapper;

    @Autowired
    public FindFacultadQueryHandler(FacultadRepository facultadRepository, FacultadMapper facultadMapper, TelefonoRepository telefonoRepository, TelefonoMapper telefonoMapper) {
        _facultadRepository = facultadRepository;
        _facultadMapper = facultadMapper;
        _telefonoRepository = telefonoRepository;
        _telefonoMapper = telefonoMapper;
    }
    @Override
    public Mono<Page<FacultadDto>> FindAllFacultad(long page, long size) {
        return Mono.fromCallable(() -> {
            Pageable pageToFind = PageRequest.of(Integer.parseInt(String.valueOf(page)), Integer.parseInt(String.valueOf(size)));
            Page<FacultadEntity> total = _facultadRepository.findAll(pageToFind);
            return total.map(this::mapFacultad);
        });
    }

    protected FacultadDto mapFacultad(FacultadEntity facultadEntity){
        FacultadDto facultadDto = _facultadMapper.factultadEntityToFactultadDto(facultadEntity);
        List<TelefonoEntity> telefonoEntityList = _telefonoRepository.findAllByFacultad(facultadEntity);
        facultadDto.setTelefonos(_telefonoMapper.convertListTelefonotEntityToListTelefonoDto(telefonoEntityList));
        return facultadDto;
    }
}
