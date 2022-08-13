package com.udistrital.controlprojectsbackend.query.rol;

import com.udistrital.controlprojectsbackend.controller.dto.CargoDto;
import com.udistrital.controlprojectsbackend.controller.dto.RolDto;
import com.udistrital.controlprojectsbackend.exceptions.NotFoundException;
import com.udistrital.controlprojectsbackend.mappers.CargoMapper;
import com.udistrital.controlprojectsbackend.mappers.RolMapper;
import com.udistrital.controlprojectsbackend.repository.entity.CargoEntity;
import com.udistrital.controlprojectsbackend.repository.entity.RolEntity;
import com.udistrital.controlprojectsbackend.repository.entity_repository.CargoRepository;
import com.udistrital.controlprojectsbackend.repository.entity_repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class FindRolByIdQueryHandler implements FindRolByIdQuery {

    private final RolRepository _rolRepository;
    private final RolMapper _rolMapper;

    @Autowired
    public FindRolByIdQueryHandler(RolRepository rolRepository, RolMapper rolMapper) {
        _rolRepository = rolRepository;
        _rolMapper = rolMapper;
    }

    @Override
    public Mono<RolDto> FindRolById(long id) {
        return Mono.fromCallable(() -> {
            RolEntity rolEntity = _rolRepository.findById(id).orElse(null);
            if (rolEntity == null) {
                throw new NotFoundException("No se ha encontrado el rol", "RolNotFound");
            }
            return _rolMapper.rolEntityToRolDto(rolEntity);
        });
    }
}
