package com.udistrital.controlprojectsbackend.command.grupoinvestigacion;

import com.udistrital.controlprojectsbackend.controller.dto.DeleteDto;
import com.udistrital.controlprojectsbackend.exceptions.ConflictException;
import com.udistrital.controlprojectsbackend.repository.entity.GrupoInvestigacionEntity;
import com.udistrital.controlprojectsbackend.repository.entity.GrupoInvestigacionId;
import com.udistrital.controlprojectsbackend.repository.entity.SedeEntity;
import com.udistrital.controlprojectsbackend.repository.entity_repository.GrupoInvestigacionRepository;
import com.udistrital.controlprojectsbackend.repository.entity_repository.SedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DeleteGrupoInvestigacionCommandHandler implements DeleteGrupoInvestigacionCommand {

    private final GrupoInvestigacionRepository _grupoInvestigacionRepository;

    @Autowired
    public DeleteGrupoInvestigacionCommandHandler( GrupoInvestigacionRepository grupoInvestigacionRepository){
        _grupoInvestigacionRepository = grupoInvestigacionRepository;
    }
    @Override
    public Mono<DeleteDto> deleteGrupoInvestigacion(String nombre, String codigo) {
        return Mono.fromCallable(() -> {
            try{
                GrupoInvestigacionId grupoInvestigacionId = new GrupoInvestigacionId(codigo,nombre);
                GrupoInvestigacionEntity grupoInvestigacionEntity = _grupoInvestigacionRepository.getReferenceById(grupoInvestigacionId);
                _grupoInvestigacionRepository.delete(grupoInvestigacionEntity);
                return new DeleteDto("Se ha borrado el grupo de investigación con éxito",true);
            }
            catch (Exception e){
                throw new ConflictException("No se pudo borrar el grupo de investigación",e.getMessage());
            }
        });
    }
}
