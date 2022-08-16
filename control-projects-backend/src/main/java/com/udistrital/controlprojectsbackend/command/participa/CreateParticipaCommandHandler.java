package com.udistrital.controlprojectsbackend.command.participa;

import com.udistrital.controlprojectsbackend.controller.dto.ParticipaDto;
import com.udistrital.controlprojectsbackend.controller.dto.ProyectoInvestigacionDto;
import com.udistrital.controlprojectsbackend.exceptions.ConflictException;
import com.udistrital.controlprojectsbackend.mappers.ParticipaMapper;
import com.udistrital.controlprojectsbackend.mappers.ProyectoInvestigacionMapper;
import com.udistrital.controlprojectsbackend.repository.entity.ParticipaEntity;
import com.udistrital.controlprojectsbackend.repository.entity.ProyectoInvestigacionEntity;
import com.udistrital.controlprojectsbackend.repository.entity_repository.ParticipaRepository;
import com.udistrital.controlprojectsbackend.repository.entity_repository.ProyectoInvestigacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CreateParticipaCommandHandler implements CreateParticipaCommand {

    private final ParticipaRepository _participaRepository;
    private final ParticipaMapper _participaMapper;

    @Autowired
    public CreateParticipaCommandHandler(
            ParticipaRepository participaRepository,
            ParticipaMapper participaMapper) {
        _participaRepository = participaRepository;
        _participaMapper = participaMapper;
    }

    @Override
    public Mono<ParticipaDto> CreateParticipa(ParticipaDto participaDto) {
        return Mono.fromCallable(() -> {
            try {
                ParticipaEntity participaEntity = _participaMapper.convertParticipaDtoToParticipaEntity(participaDto);
                participaEntity = _participaRepository.save(participaEntity);
                return _participaMapper.convertParticipaEntityToParticipaDto(participaEntity);
            } catch (Exception e) {
                throw new ConflictException("No se pudo crear e", e.getMessage());
            }
        });
    }
}
