package com.udistrital.controlprojectsbackend.command.participa;

import com.udistrital.controlprojectsbackend.controller.dto.DeleteDto;
import com.udistrital.controlprojectsbackend.controller.dto.GrupoInvestigacionDto;
import com.udistrital.controlprojectsbackend.exceptions.ConflictException;
import com.udistrital.controlprojectsbackend.mappers.GrupoInvestigacionMapper;
import com.udistrital.controlprojectsbackend.mappers.ProfesorMapper;
import com.udistrital.controlprojectsbackend.mappers.ProyectoInvestigacionMapper;
import com.udistrital.controlprojectsbackend.query.grupoinvestigacion.FindGrupoInvestigacionByIdQuery;
import com.udistrital.controlprojectsbackend.query.profesor.FindProfesorByIdQuery;
import com.udistrital.controlprojectsbackend.query.proyectoinvestigacion.FindProyectoInvestigacionByIdQuery;
import com.udistrital.controlprojectsbackend.repository.entity.*;
import com.udistrital.controlprojectsbackend.repository.entity_repository.ParticipaRepository;
import com.udistrital.controlprojectsbackend.repository.entity_repository.ProyectoInvestigacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DeleteParticipaCommandHandler implements DeleteParticipaCommand {

    private final FindProyectoInvestigacionByIdQuery _findProyectoInvestigacionByIdQuery;
    private final FindProfesorByIdQuery _findProfesorByIdQuery;
    private final ProyectoInvestigacionMapper _proyectoInvestigacionMapper;
    private final ProfesorMapper _profesorMapper;
    private final ParticipaRepository _participaRepository;

    @Autowired
    public DeleteParticipaCommandHandler(
            FindProyectoInvestigacionByIdQuery findProyectoInvestigacionByIdQuery,
            ProyectoInvestigacionMapper proyectoInvestigacionMapper,
            FindProfesorByIdQuery findProfesorByIdQuery,
            ProfesorMapper profesorMapper,
            ParticipaRepository participaRepository
    ){
        _findProyectoInvestigacionByIdQuery = findProyectoInvestigacionByIdQuery;
        _proyectoInvestigacionMapper = proyectoInvestigacionMapper;
        _findProfesorByIdQuery = findProfesorByIdQuery;
        _profesorMapper = profesorMapper;
        _participaRepository = participaRepository;
    }
    @Override
    public Mono<DeleteDto> deleteParticipa(String nombreGrupo, String codigoGrupo, String codigoProyecto, Long cedulaProfesor) {
        return Mono.fromCallable(() -> {
            try{
                ProyectoInvestigacionEntity proyectoInvestigacionEntity = _proyectoInvestigacionMapper.convertProyectoInvestigacionDtoToProyectoInvestigacionEntity(_findProyectoInvestigacionByIdQuery.FindProyectoInvestigacionByid(nombreGrupo,codigoGrupo,codigoProyecto).block());
                ProfesorEntity profesorEntity = _profesorMapper.profesorDtoToProfesorEntity(_findProfesorByIdQuery.FindProfesorById(cedulaProfesor).block());
                ParticipaId participaId = new ParticipaId(profesorEntity,proyectoInvestigacionEntity);
                ParticipaEntity participaEntity = _participaRepository.getReferenceById(participaId);
                _participaRepository.delete(participaEntity);
                return new DeleteDto("Se ha borrado la participación con éxito",true);
            }
            catch (Exception e){
                throw new ConflictException("No se pudo borrar la participación",e.getMessage());
            }
        });
    }
}
