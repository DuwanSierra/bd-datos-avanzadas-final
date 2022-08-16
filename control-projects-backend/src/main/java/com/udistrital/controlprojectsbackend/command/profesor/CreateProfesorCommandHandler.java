package com.udistrital.controlprojectsbackend.command.profesor;

import com.udistrital.controlprojectsbackend.controller.dto.ProfesorDto;
import com.udistrital.controlprojectsbackend.controller.dto.SedeDto;
import com.udistrital.controlprojectsbackend.exceptions.ConflictException;
import com.udistrital.controlprojectsbackend.exceptions.NotFoundException;
import com.udistrital.controlprojectsbackend.mappers.ProfesorMapper;
import com.udistrital.controlprojectsbackend.mappers.TituloMapper;
import com.udistrital.controlprojectsbackend.repository.entity.*;
import com.udistrital.controlprojectsbackend.repository.entity_repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class CreateProfesorCommandHandler implements CreateProfesorCommand {
    private final ProfesorRepository _profesorRepository;
    private final GrupoInvestigacionRepository _grupoInvetigacionRepository;
    private final FacultadRepository _facultadRepository;
    private final ProfesorMapper _profesorMapper;
    private final TituloMapper _tituloMapper;
    private final TituloRepository _tituloRepository;
    @Autowired
    public CreateProfesorCommandHandler(
            ProfesorRepository profesorRepository,
            GrupoInvestigacionRepository grupoInvestigacionRepository,
            FacultadRepository facultadRepository,
            ProfesorMapper profesorMapper,
            TituloMapper tituloMapper,
            TituloRepository tituloRepository
    ){
        _profesorRepository = profesorRepository;
        _grupoInvetigacionRepository = grupoInvestigacionRepository;
        _facultadRepository = facultadRepository;
        _profesorMapper = profesorMapper;
        _tituloMapper = tituloMapper;
        _tituloRepository = tituloRepository;
    }
    @Override
    public Mono<ProfesorDto> CreateProfesor(ProfesorDto profesorDto) {
        return Mono.fromCallable(() -> {
            try{
                ProfesorEntity profesor = _profesorMapper.profesorDtoToProfesorEntity(profesorDto);
                List<TituloEntity> titulos = _tituloMapper.convertListTitulotDtoToListTitulooEntity(profesorDto.getTitulos(), profesor);
                profesor = _profesorRepository.save(profesor);
                titulos = _tituloRepository.saveAll(titulos);
                ProfesorDto responseProfesor = _profesorMapper.profesorEntityToProfesorDto(profesor);
                responseProfesor.setTitulos(_tituloMapper.convertListTitulotEntityToListTituloDto(titulos));
                return responseProfesor;
            }
            catch (Exception e){
                throw new ConflictException("No se pudo crear el profesor",e.getMessage());
            }
        });
    }
}
