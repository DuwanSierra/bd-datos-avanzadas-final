import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DeleteDto } from 'src/app/@core/dto/delete.dto';
import { CustomTablePaginateDto } from 'src/app/components/custom-table/custom-table.paginate.dto';
import { CustomTablePaginatorDto } from 'src/app/components/custom-table/custom-table.paginator.dto';
import { Utils } from 'src/app/utils/utils';
import { environment } from 'src/environments/environment';
import { ProyectoInvestigacionRequest } from '../request-dto/proyecto-investigacion.request';

@Injectable({
  providedIn: 'root',
})
export class ProyectoInvestigacionManagerService {
  private proyectoEndpoint = environment.proyectoEndpoint;

  constructor(private httpClient: HttpClient) {}

  public createProject(
    profesor: ProyectoInvestigacionRequest
  ): Observable<ProyectoInvestigacionRequest> {
    return this.httpClient.post<ProyectoInvestigacionRequest>(
      `${this.proyectoEndpoint}/create`,
      profesor
    );
  }

  public editProject(
    grupo: ProyectoInvestigacionRequest,
    grupoNombre: string,
    grupoCodigo: number,
    proyectoCodigo: number
  ): Observable<ProyectoInvestigacionRequest> {
    return this.httpClient.put<ProyectoInvestigacionRequest>(
      `${this.proyectoEndpoint}/edit/${encodeURIComponent(
        grupoNombre || ''
      )}/${encodeURIComponent(grupoCodigo || '')}/${encodeURIComponent(
        proyectoCodigo || ''
      )}`,
      grupo
    );
  }

  public findAllGProjects(
    pagination: CustomTablePaginateDto
  ): Observable<CustomTablePaginatorDto> {
    return this.httpClient.get<CustomTablePaginatorDto>(
      `${this.proyectoEndpoint}/all?${Utils.getQueryParams(pagination)}`
    );
  }

  public deleteProjects(
    grupo: ProyectoInvestigacionRequest
  ): Observable<DeleteDto> {
    return this.httpClient.delete<DeleteDto>(
      `${this.proyectoEndpoint}/delete/${encodeURIComponent(
        grupo.grupoInvestigacion?.nombreGrupoInvestigacion || ''
      )}/${encodeURIComponent(
        grupo.grupoInvestigacion?.codigoGrupoInvestigacion || ''
      )}/${encodeURIComponent(grupo.codigo || '')}`
    );
  }

  public findProject(
    nombreGrupo: string,
    codigoGrupo: number,
    codigoProyecto: number
  ): Observable<ProyectoInvestigacionRequest> {
    return this.httpClient.get<ProyectoInvestigacionRequest>(
      `${this.proyectoEndpoint}/find/${encodeURIComponent(
        nombreGrupo || ''
      )}/${encodeURIComponent(codigoGrupo || '')}/${encodeURIComponent(
        codigoProyecto || ''
      )}`
    );
  }
}
