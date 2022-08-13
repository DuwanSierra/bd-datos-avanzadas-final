package com.udistrital.controlprojectsbackend.command.rol;

import com.udistrital.controlprojectsbackend.controller.dto.RolDto;
import com.udistrital.controlprojectsbackend.exceptions.ConflictException;
import com.udistrital.controlprojectsbackend.exceptions.NotFoundException;
import com.udistrital.controlprojectsbackend.mappers.RolMapper;
import com.udistrital.controlprojectsbackend.repository.entity.RolEntity;
import com.udistrital.controlprojectsbackend.repository.entity_repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class EditRolCommandHandler implements EditRolCommand {
    private final RolRepository _rolRepository;
    private final RolMapper _rolMapper;

    @Autowired
    public EditRolCommandHandler(RolRepository rolRepository, RolMapper rolMapper){
        _rolRepository = rolRepository;
        _rolMapper = rolMapper;
    }
    @Override
    public Mono<RolDto> EditRol(RolDto rolDto, long id) {
        return Mono.fromCallable(() -> {
            try{
                RolEntity rolToEdit = _rolRepository.findById(id).orElse(null);
                if(rolToEdit==null){
                    throw new NotFoundException("No se ha encontrado el rol", "RolNotFound");
                }
                rolToEdit = _rolMapper.rolDtoToRolEntity(rolDto);
                rolToEdit.setRolId(id);
                rolToEdit = _rolRepository.save(rolToEdit);
                return _rolMapper.rolEntityToRolDto(rolToEdit);
            }
            catch (Exception e){
                throw new ConflictException("No se pudo editar el rol",e.getMessage());
            }
        });
    }
}
