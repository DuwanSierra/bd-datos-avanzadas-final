package com.udistrital.controlprojectsbackend.command.areainteres;

import com.udistrital.controlprojectsbackend.controller.dto.AreaInteresDto;
import com.udistrital.controlprojectsbackend.exceptions.ConflictException;
import com.udistrital.controlprojectsbackend.exceptions.NotFoundException;
import com.udistrital.controlprojectsbackend.mappers.AreaInteresMapper;
import com.udistrital.controlprojectsbackend.repository.entity_repository.AreaInteresRepository;
import com.udistrital.controlprojectsbackend.repository.entity.AreaInteresEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class EditAreaInteresCommandHandler implements  EditAreaInteresCommand{
    private final AreaInteresRepository _areaInteresRepository;
    private final AreaInteresMapper _areaInteresMapper;

    @Autowired
    public EditAreaInteresCommandHandler(AreaInteresRepository areaInteresRepository, AreaInteresMapper areaInteresMapper){
        _areaInteresRepository = areaInteresRepository;
        _areaInteresMapper = areaInteresMapper;
    }
    @Override
    public Mono<AreaInteresDto> EditAreaInteres(AreaInteresDto areaInteresDto, long id) {
        return Mono.fromCallable(() -> {
            try{
                AreaInteresEntity areaToEdit = _areaInteresRepository.findById(id).orElse(null);
                if(areaToEdit==null){
                    throw new NotFoundException("No se ha encontrado el área de interes", "AreInteresNotFound");
                }
                areaToEdit = _areaInteresMapper.areaInteresDtoToAreaInteresEntity(areaInteresDto);
                areaToEdit.setIdAreaInteres(id);
                areaToEdit = _areaInteresRepository.save(areaToEdit);
                return _areaInteresMapper.areaInteresEntityToAreaInteresDto(areaToEdit);
            }
            catch (Exception e){
                throw new ConflictException("No se pudo editar el área de interés",e.getMessage());
            }
        });
    }
}
