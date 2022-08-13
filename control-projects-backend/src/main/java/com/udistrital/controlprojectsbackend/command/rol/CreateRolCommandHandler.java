package com.udistrital.controlprojectsbackend.command.rol;

import com.udistrital.controlprojectsbackend.controller.dto.RolDto;
import com.udistrital.controlprojectsbackend.exceptions.ConflictException;
import com.udistrital.controlprojectsbackend.mappers.RolMapper;
import com.udistrital.controlprojectsbackend.repository.entity.CargoEntity;
import com.udistrital.controlprojectsbackend.repository.entity.RolEntity;
import com.udistrital.controlprojectsbackend.repository.entity_repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CreateRolCommandHandler implements CreateRolCommand{
    private final RolRepository _rolRepository;
    private final RolMapper _rolMapper;
    @Autowired
    public CreateRolCommandHandler(RolRepository rolRepository, RolMapper rolMapper){
        _rolMapper = rolMapper;
        _rolRepository = rolRepository;
    }
    @Override
    public Mono<RolDto> CreateRol(RolDto rolDto) {
        return Mono.fromCallable(() -> {
            try {
                RolEntity rolEntity = _rolMapper.rolDtoToRolEntity(rolDto);
                rolEntity.setRolId(null);
                rolEntity = _rolRepository.save(rolEntity);
                return _rolMapper.rolEntityToRolDto(rolEntity);
            } catch (Exception e) {
                throw new ConflictException("No se pudo crear el rol", e.getMessage());
            }
        });
    }
}
