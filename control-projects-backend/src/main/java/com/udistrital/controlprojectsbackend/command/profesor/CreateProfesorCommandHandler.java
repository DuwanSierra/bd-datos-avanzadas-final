package com.udistrital.controlprojectsbackend.command.profesor;

import com.udistrital.controlprojectsbackend.controller.dto.ProfesorDto;
import com.udistrital.controlprojectsbackend.controller.dto.SedeDto;
import com.udistrital.controlprojectsbackend.exceptions.ConflictException;
import com.udistrital.controlprojectsbackend.exceptions.NotFoundException;
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
    private ProfesorRepository _profesorRepository;
    private GrupoInvestigacionRepository _grupoInvetigacionRepository;
    private FacultadRepository _facultadRepository;
    @Autowired
    public CreateProfesorCommandHandler(ProfesorRepository profesorRepository,GrupoInvestigacionRepository grupoInvestigacionRepository, FacultadRepository facultadRepository ){
        _profesorRepository = profesorRepository;
        _grupoInvetigacionRepository = grupoInvestigacionRepository;
        _facultadRepository = facultadRepository;
    }
    @Override
    public Mono<ProfesorDto> CreateProfesor(ProfesorDto profesorDto) {
        return Mono.fromCallable(() -> {
            try{
                ProfesorEntity profesor = new ProfesorEntity();
                profesor.setCedulaProfesor(profesorDto.getCedulaProfesor());
                GrupoInvestigacionId grupoId = new GrupoInvestigacionId();
                FacultadEntity facultad = _facultadRepository.getReferenceById(profesorDto.getGrupoInvestigacion().getFacultad().getFacultadNombre());
                if(facultad.getNombreFacultad() == null){
                    throw new NotFoundException("FacultyNotFound","No existe la facultad con la que relacionas el profesor");
                }
                profesor = _profesorRepository.save(profesor);
                return profesorDto;
            }
            catch (Exception e){
                throw new ConflictException("No se pudo crear la sede",e.getMessage());
            }
        });
    }
}
