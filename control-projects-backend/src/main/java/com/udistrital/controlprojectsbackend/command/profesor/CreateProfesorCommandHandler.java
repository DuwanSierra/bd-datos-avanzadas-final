package com.udistrital.controlprojectsbackend.command.profesor;

import com.udistrital.controlprojectsbackend.controller.dto.ProfesorDto;
import com.udistrital.controlprojectsbackend.controller.dto.SedeDto;
import com.udistrital.controlprojectsbackend.exceptions.ConflictException;
import com.udistrital.controlprojectsbackend.exceptions.NotFoundException;
import com.udistrital.controlprojectsbackend.mappers.ProfesorMapper;
import com.udistrital.controlprojectsbackend.repository.entity.*;
import com.udistrital.controlprojectsbackend.repository.entity_repository.FacultadRepository;
import com.udistrital.controlprojectsbackend.repository.entity_repository.GrupoInvestigacionRepository;
import com.udistrital.controlprojectsbackend.repository.entity_repository.ProfesorRepository;
import com.udistrital.controlprojectsbackend.repository.entity_repository.SedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CreateProfesorCommandHandler implements CreateProfesorCommand {
    private final ProfesorRepository _profesorRepository;
    private final GrupoInvestigacionRepository _grupoInvetigacionRepository;
    private final FacultadRepository _facultadRepository;
    private final ProfesorMapper _profesorMapper;
    @Autowired
    public CreateProfesorCommandHandler(
            ProfesorRepository profesorRepository,
            GrupoInvestigacionRepository grupoInvestigacionRepository,
            FacultadRepository facultadRepository,
            ProfesorMapper profesorMapper
    ){
        _profesorRepository = profesorRepository;
        _grupoInvetigacionRepository = grupoInvestigacionRepository;
        _facultadRepository = facultadRepository;
        _profesorMapper = profesorMapper;
    }
    @Override
    public Mono<ProfesorDto> CreateProfesor(ProfesorDto profesorDto) {
        return Mono.fromCallable(() -> {
            try{
                ProfesorEntity profesor = _profesorMapper.profesorDtoToProfesorEntity(profesorDto);
                profesor = _profesorRepository.save(profesor);
                return _profesorMapper.profesorEntityToProfesorDto(profesor);
            }
            catch (Exception e){
                throw new ConflictException("No se pudo crear el profesor",e.getMessage());
            }
        });
    }
}
