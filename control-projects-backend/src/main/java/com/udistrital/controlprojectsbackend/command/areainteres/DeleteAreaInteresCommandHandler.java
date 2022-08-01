package com.udistrital.controlprojectsbackend.command.areainteres;

import com.udistrital.controlprojectsbackend.exceptions.controller.dto.DeleteDto;
import com.udistrital.controlprojectsbackend.exceptions.ConflictException;
import com.udistrital.controlprojectsbackend.repository.AreaInteresRepository;
import com.udistrital.controlprojectsbackend.repository.entity.AreaInteresEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DeleteAreaInteresCommandHandler implements DeleteAreaInteresCommand {

    private AreaInteresRepository _areaInteresRepository;

    public DeleteAreaInteresCommandHandler(@Autowired AreaInteresRepository areaInteresRepository){
        _areaInteresRepository = areaInteresRepository;
    }

    @Override
    public Mono<DeleteDto> deleteAreaInteres(long id) {
        return Mono.fromCallable(() -> {
            try{
                AreaInteresEntity areaToDelete = _areaInteresRepository.getReferenceById(id);
                _areaInteresRepository.delete(areaToDelete);
                return  new DeleteDto("Se ha borrado el área de interés con éxito",true);
            }
            catch (Exception e){
                throw new ConflictException("No se pudo borrar el área de interés",e.getMessage());
            }
        });
    }
}
