package com.udistrital.controlprojectsbackend.command.areainteres;

import com.udistrital.controlprojectsbackend.exceptions.controller.dto.AreaInteresDto;
import com.udistrital.controlprojectsbackend.exceptions.ConflictException;
import com.udistrital.controlprojectsbackend.exceptions.NotFoundException;
import com.udistrital.controlprojectsbackend.repository.AreaInteresRepository;
import com.udistrital.controlprojectsbackend.repository.entity.AreaInteresEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class EditAreaInteresCommandHandler implements  EditAreaInteresCommand{
    private AreaInteresRepository _areaInteresRepository;

    public EditAreaInteresCommandHandler(@Autowired AreaInteresRepository areaInteresRepository){
        _areaInteresRepository = areaInteresRepository;
    }
    @Override
    public Mono<AreaInteresDto> EditAreaInteres(AreaInteresDto areaInteresDto, long id) {
        return Mono.fromCallable(() -> {
            try{
                AreaInteresEntity areaToEdit = _areaInteresRepository.findById(id).orElse(null);
                if(areaToEdit==null){
                    throw new NotFoundException("No se ha encontrado el área de interes", "AreInteresNotFound");
                }
                areaToEdit.setAreaNombre(areaInteresDto.getAreaNombre());
                areaToEdit = _areaInteresRepository.save(areaToEdit);
                areaInteresDto.setAreaId(areaToEdit.getAreaId());
                return areaInteresDto;
            }
            catch (Exception e){
                throw new ConflictException("No se pudo editar el área de interés",e.getMessage());
            }
        });
    }
}
