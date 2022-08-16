package com.udistrital.controlprojectsbackend.command.profesor;

import com.udistrital.controlprojectsbackend.controller.dto.ProfesorDto;
import com.udistrital.controlprojectsbackend.exceptions.ConflictException;
import com.udistrital.controlprojectsbackend.exceptions.NotFoundException;
import com.udistrital.controlprojectsbackend.mappers.ProfesorMapper;
import com.udistrital.controlprojectsbackend.mappers.TituloMapper;
import com.udistrital.controlprojectsbackend.repository.entity.ProfesorEntity;
import com.udistrital.controlprojectsbackend.repository.entity.TituloEntity;
import com.udistrital.controlprojectsbackend.repository.entity_repository.ProfesorRepository;
import com.udistrital.controlprojectsbackend.repository.entity_repository.TituloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class EditProfesorCommandHandler implements EditProfesorCommand {
    private final ProfesorRepository _profesorRepository;
    private final ProfesorMapper _profesorMapper;
    private final TituloMapper _tituloMapper;
    private final TituloRepository _tituloRepository;
    @Autowired
    public EditProfesorCommandHandler(ProfesorRepository profesorRepository,
                                      ProfesorMapper profesorMapper,
                                      TituloMapper tituloMapper,
                                      TituloRepository tituloRepository){
        _profesorRepository = profesorRepository;
        _profesorMapper = profesorMapper;
        _tituloRepository = tituloRepository;
        _tituloMapper = tituloMapper;
    }
    @Override
    public Mono<ProfesorDto> EditProfesor(ProfesorDto profesorDto, Long id) {
        return Mono.fromCallable(() -> {
            ProfesorEntity profesor  = _profesorRepository.findById(id).orElse(null);
            if(profesor==null){
                throw new NotFoundException("No se ha encontrado el le profesor", "ProfesorNotFound");
            }
            try{
                profesor = _profesorMapper.profesorDtoToProfesorEntity(profesorDto);
                List<TituloEntity> titulos = _tituloMapper.convertListTitulotDtoToListTitulooEntity(profesorDto.getTitulos(), profesor);
                profesor = _profesorRepository.save(profesor);
                _tituloRepository.deleteAllByProfesor(profesor);
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
