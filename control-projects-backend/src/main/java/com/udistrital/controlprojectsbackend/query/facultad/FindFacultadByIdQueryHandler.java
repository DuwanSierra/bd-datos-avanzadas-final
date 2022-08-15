package com.udistrital.controlprojectsbackend.query.facultad;

import com.udistrital.controlprojectsbackend.controller.dto.FacultadDto;
import com.udistrital.controlprojectsbackend.exceptions.NotFoundException;
import com.udistrital.controlprojectsbackend.mappers.FacultadMapper;
import com.udistrital.controlprojectsbackend.mappers.TelefonoMapper;
import com.udistrital.controlprojectsbackend.repository.entity.FacultadEntity;
import com.udistrital.controlprojectsbackend.repository.entity.TelefonoEntity;
import com.udistrital.controlprojectsbackend.repository.entity_repository.FacultadRepository;
import com.udistrital.controlprojectsbackend.repository.entity_repository.TelefonoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class FindFacultadByIdQueryHandler implements FindFacultadByIdQuery {

    private final FacultadRepository _facultadRepository;
    private final TelefonoRepository _telefonoRepository;
    private final FacultadMapper _facultadMapper;
    private final TelefonoMapper _telefonoMapper;

    @Autowired
    public FindFacultadByIdQueryHandler(FacultadRepository facultadRepository, FacultadMapper facultadMapper, TelefonoRepository telefonoRepository, TelefonoMapper telefonoMapper) {
        _facultadRepository = facultadRepository;
        _facultadMapper = facultadMapper;
        _telefonoRepository = telefonoRepository;
        _telefonoMapper = telefonoMapper;
    }

    @Override
    public Mono<FacultadDto> FindFacultadByid(String id) {
        return Mono.fromCallable(() -> {
            FacultadEntity facultad = _facultadRepository.findById(id).orElse(null);
            if (facultad == null) {
                throw new NotFoundException("No se ha encontrado la facultad", "FacultadNotFound");
            }
            FacultadDto facultadDtoResponse = _facultadMapper.factultadEntityToFactultadDto(facultad);
            List<TelefonoEntity> telefonoEntities = _telefonoRepository.findAllByFacultad(facultad);
            if(telefonoEntities!= null && telefonoEntities.size()>0){
                facultadDtoResponse.setTelefonos(_telefonoMapper.convertListTelefonotEntityToListTelefonoDto(telefonoEntities));
            }
            return facultadDtoResponse;
        });
    }
}
