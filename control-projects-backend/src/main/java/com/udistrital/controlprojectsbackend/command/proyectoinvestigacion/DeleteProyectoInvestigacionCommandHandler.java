package com.udistrital.controlprojectsbackend.command.proyectoinvestigacion;

import com.udistrital.controlprojectsbackend.controller.dto.DeleteDto;
import com.udistrital.controlprojectsbackend.controller.dto.GrupoInvestigacionDto;
import com.udistrital.controlprojectsbackend.exceptions.ConflictException;
import com.udistrital.controlprojectsbackend.mappers.GrupoInvestigacionMapper;
import com.udistrital.controlprojectsbackend.query.grupoinvestigacion.FindGrupoInvestigacionByIdQuery;
import com.udistrital.controlprojectsbackend.repository.entity.GrupoInvestigacionEntity;
import com.udistrital.controlprojectsbackend.repository.entity.GrupoInvestigacionId;
import com.udistrital.controlprojectsbackend.repository.entity.ProyectoInvestigacionEntity;
import com.udistrital.controlprojectsbackend.repository.entity.ProyectoInvestigacionId;
import com.udistrital.controlprojectsbackend.repository.entity_repository.GrupoInvestigacionRepository;
import com.udistrital.controlprojectsbackend.repository.entity_repository.ProyectoInvestigacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DeleteProyectoInvestigacionCommandHandler implements DeleteProyectoInvestigacionCommand {

    private final ProyectoInvestigacionRepository _proyectoInvestigacionRepository;
    private final FindGrupoInvestigacionByIdQuery _findGrupoInvestigacionByIdQuery;
    private final GrupoInvestigacionMapper _grupoInvestigacionMapper;

    @Autowired
    public DeleteProyectoInvestigacionCommandHandler(
            ProyectoInvestigacionRepository proyectoInvestigacionRepository,
            FindGrupoInvestigacionByIdQuery findGrupoInvestigacionByIdQuery,
            GrupoInvestigacionMapper grupoInvestigacionMapper
    ){
        _proyectoInvestigacionRepository = proyectoInvestigacionRepository;
        _findGrupoInvestigacionByIdQuery = findGrupoInvestigacionByIdQuery;
        _grupoInvestigacionMapper = grupoInvestigacionMapper;
    }
    @Override
    public Mono<DeleteDto> deleteProyectoInvestigacion(String nombreGrupo, String codigoGrupo, String codigoProyecto) {
        return Mono.fromCallable(() -> {
            try{
                GrupoInvestigacionDto grupoInvestigacionDto = _findGrupoInvestigacionByIdQuery.FindGrupoInvestigacionByid(nombreGrupo,codigoGrupo).block();
                ProyectoInvestigacionId proyectoInvestigacionId = new ProyectoInvestigacionId(_grupoInvestigacionMapper.convertGrupoInvestigacionDtoToGrupoInvestigacionEntity(grupoInvestigacionDto),codigoProyecto);
                ProyectoInvestigacionEntity proyectoInvestigacionEntity = _proyectoInvestigacionRepository.getReferenceById(proyectoInvestigacionId);
                _proyectoInvestigacionRepository.delete(proyectoInvestigacionEntity);
                return new DeleteDto("Se ha borrado el proyecto de investigación con éxito",true);
            }
            catch (Exception e){
                throw new ConflictException("No se pudo borrar el proyecto de investigación",e.getMessage());
            }
        });
    }
}
