package com.udistrital.controlprojectsbackend.command.facultad;

import com.udistrital.controlprojectsbackend.controller.dto.FacultadDto;
import com.udistrital.controlprojectsbackend.exceptions.ConflictException;
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
public class CreateFacultadCommandHandler implements CreateFacultadCommand {
    private final FacultadRepository _facultadRepository;
    private final FacultadMapper _facultadMapper;
    private final TelefonoMapper _telefonoMapper;
    private final TelefonoRepository _telefonoRepository;

    @Autowired
    public CreateFacultadCommandHandler(FacultadRepository facultadRepository, FacultadMapper facultadMapper, TelefonoMapper telefonoMapper, TelefonoRepository telefonoRepository) {
        _facultadRepository = facultadRepository;
        _facultadMapper = facultadMapper;
        _telefonoMapper = telefonoMapper;
        _telefonoRepository = telefonoRepository;
    }

    @Override
    public Mono<FacultadDto> CreateFacultad(FacultadDto facultadDto) {
        return Mono.fromCallable(() -> {
            FacultadEntity facultadEntity = _facultadMapper.facultadDtoToFacultadEntity(facultadDto);
            facultadEntity = _facultadRepository.findById(facultadEntity.getNombreFacultad()).orElse(null);
            if (facultadEntity != null) {
                throw new ConflictException("Ya existe la facultad", "FacultyAlreadyExist");
            }
            try {
                facultadEntity = _facultadMapper.facultadDtoToFacultadEntity(facultadDto);
                facultadEntity = _facultadRepository.save(facultadEntity);
                // Crear numeros de telefono
                List<TelefonoEntity> telefonoEntitys = _telefonoMapper.convertListTelefonotDtoToListTelefonoEntity(facultadDto.getTelefonos(), facultadEntity);
                if (telefonoEntitys != null) {
                    telefonoEntitys = _telefonoRepository.saveAll(telefonoEntitys);
                }
                FacultadDto response = _facultadMapper.factultadEntityToFactultadDto(facultadEntity);
                response.setTelefonos(_telefonoMapper.convertListTelefonotEntityToListTelefonoDto(telefonoEntitys));
                return response;
            } catch (Exception e) {
                throw new ConflictException("No se pudo crear la facultad", e.getMessage());
            }
        });
    }
}
