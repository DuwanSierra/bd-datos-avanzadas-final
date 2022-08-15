package com.udistrital.controlprojectsbackend.query.profesor;

import com.udistrital.controlprojectsbackend.controller.dto.FacultadDto;
import com.udistrital.controlprojectsbackend.controller.dto.ProfesorDto;
import com.udistrital.controlprojectsbackend.exceptions.NotFoundException;
import com.udistrital.controlprojectsbackend.mappers.FacultadMapper;
import com.udistrital.controlprojectsbackend.mappers.ProfesorMapper;
import com.udistrital.controlprojectsbackend.mappers.TelefonoMapper;
import com.udistrital.controlprojectsbackend.repository.entity.FacultadEntity;
import com.udistrital.controlprojectsbackend.repository.entity.ProfesorEntity;
import com.udistrital.controlprojectsbackend.repository.entity.TelefonoEntity;
import com.udistrital.controlprojectsbackend.repository.entity_repository.FacultadRepository;
import com.udistrital.controlprojectsbackend.repository.entity_repository.ProfesorRepository;
import com.udistrital.controlprojectsbackend.repository.entity_repository.TelefonoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class FindProfesorByIdQueryHandler implements FindProfesorByIdQuery {

    private final ProfesorRepository _profesorReposiroty;
    private final ProfesorMapper _profesorMapper;

    @Autowired
    public FindProfesorByIdQueryHandler(ProfesorRepository profesorRepository, ProfesorMapper profesorMapper){
        _profesorReposiroty = profesorRepository;
        _profesorMapper = profesorMapper;
    }

    @Override
    public Mono<ProfesorDto> FindProfesorById(Long id) {
        return Mono.fromCallable(() -> {
            ProfesorEntity profesor = _profesorReposiroty.findById(id).orElse(null);
            if (profesor == null) {
                throw new NotFoundException("No se ha encontrado el profesor", "ProfesorNotFound");
            }
            return _profesorMapper.profesorEntityToProfesorDto(profesor);
        });
    }
}
