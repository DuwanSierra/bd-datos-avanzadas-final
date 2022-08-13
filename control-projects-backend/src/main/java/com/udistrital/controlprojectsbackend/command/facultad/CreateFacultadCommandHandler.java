package com.udistrital.controlprojectsbackend.command.facultad;

import com.udistrital.controlprojectsbackend.controller.dto.FacultadDto;
import com.udistrital.controlprojectsbackend.exceptions.ConflictException;
import com.udistrital.controlprojectsbackend.mappers.CargoMapper;
import com.udistrital.controlprojectsbackend.mappers.FacultadMapper;
import com.udistrital.controlprojectsbackend.repository.entity.CargoEntity;
import com.udistrital.controlprojectsbackend.repository.entity.FacultadEntity;
import com.udistrital.controlprojectsbackend.repository.entity_repository.CargoRepository;
import com.udistrital.controlprojectsbackend.repository.entity_repository.FacultadRepository;
import com.udistrital.controlprojectsbackend.repository.entity_repository.TelefonoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CreateFacultadCommandHandler implements CreateFacultadCommand {
    private final FacultadRepository _facultadRepository;
    private final FacultadMapper _facultadMapper;
    @Autowired
    public CreateFacultadCommandHandler(FacultadRepository facultadRepository, FacultadMapper facultadMapper){
        _facultadRepository = facultadRepository;
        _facultadMapper = facultadMapper;
    }
    @Override
    public Mono<FacultadDto> CreateFacultad(FacultadDto facultadDto) {
        return Mono.fromCallable(() -> {
            try {
                FacultadEntity facultadEntity = _facultadMapper.facultadDtoToFacultadEntity(facultadDto);
                facultadEntity = _facultadRepository.save(facultadEntity);
                // Crear numeros de telefono
                return _facultadMapper.factultadEntityToFactultadDto(facultadEntity);
            } catch (Exception e) {
                throw new ConflictException("No se pudo crear la facultad", e.getMessage());
            }
        });
    }
}
