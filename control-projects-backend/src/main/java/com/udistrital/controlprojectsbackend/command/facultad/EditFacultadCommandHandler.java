package com.udistrital.controlprojectsbackend.command.facultad;

import com.udistrital.controlprojectsbackend.controller.dto.CargoDto;
import com.udistrital.controlprojectsbackend.controller.dto.FacultadDto;
import com.udistrital.controlprojectsbackend.exceptions.ConflictException;
import com.udistrital.controlprojectsbackend.exceptions.NotFoundException;
import com.udistrital.controlprojectsbackend.mappers.CargoMapper;
import com.udistrital.controlprojectsbackend.mappers.FacultadMapper;
import com.udistrital.controlprojectsbackend.mappers.TelefonoMapper;
import com.udistrital.controlprojectsbackend.repository.entity.CargoEntity;
import com.udistrital.controlprojectsbackend.repository.entity.FacultadEntity;
import com.udistrital.controlprojectsbackend.repository.entity.TelefonoEntity;
import com.udistrital.controlprojectsbackend.repository.entity_repository.CargoRepository;
import com.udistrital.controlprojectsbackend.repository.entity_repository.FacultadRepository;
import com.udistrital.controlprojectsbackend.repository.entity_repository.TelefonoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class EditFacultadCommandHandler implements EditFacultadCommand {
    private final FacultadRepository _facultadRepository;
    private final FacultadMapper _facultadMapper;
    private final TelefonoMapper _telefonoMapper;
    private final TelefonoRepository _telefonoRepository;
    @Autowired
    public EditFacultadCommandHandler(FacultadRepository facultadRepository, FacultadMapper facultadMapper, TelefonoMapper telefonoMapper, TelefonoRepository telefonoRepository){
        _facultadRepository = facultadRepository;
        _facultadMapper = facultadMapper;
        _telefonoMapper = telefonoMapper;
        _telefonoRepository = telefonoRepository;
    }
    @Override
    public Mono<FacultadDto> EditFacultad(FacultadDto facultadDto, String id) {
        return Mono.fromCallable(() -> {
            FacultadEntity facultadEntity = _facultadRepository.findById(id).orElse(null);
            if(facultadEntity==null){
                throw new NotFoundException("No se ha encontrado el laf acultad", "FacultadNotFound");
            }
            try {
                facultadEntity = _facultadMapper.facultadDtoToFacultadEntity(facultadDto);
                List<TelefonoEntity> telefonoEntitys = _telefonoMapper.convertListTelefonotDtoToListTelefonoEntity(facultadDto.getTelefonos(),facultadEntity);
                facultadEntity = _facultadRepository.save(facultadEntity);
                // Crear numeros de telefono
                _telefonoRepository.deleteAllByFacultad(facultadEntity);
                telefonoEntitys = _telefonoRepository.saveAll(telefonoEntitys);
                FacultadDto response = _facultadMapper.factultadEntityToFactultadDto(facultadEntity);
                response.setTelefonos(_telefonoMapper.convertListTelefonotEntityToListTelefonoDto(telefonoEntitys));
                return response;
            } catch (Exception e) {
                throw new ConflictException("No se pudo editar la facultad", e.getMessage());
            }
        });
    }
}
