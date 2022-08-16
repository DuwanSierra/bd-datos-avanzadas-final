import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DeleteDto } from 'src/app/@core/dto/delete.dto';
import { CustomTablePaginateDto } from 'src/app/components/custom-table/custom-table.paginate.dto';
import { CustomTablePaginatorDto } from 'src/app/components/custom-table/custom-table.paginator.dto';
import { Utils } from 'src/app/utils/utils';
import { environment } from 'src/environments/environment';
import { GrupoInvestigacionRequest } from '../request-dto/grupo-investigacion.request';

@Injectable({
  providedIn: 'root'
})
export class GrupoInvestigacionManagerService {

  private grupoEndpoint = environment.grupoEndpoint;

  constructor(private httpClient: HttpClient) {}

  public createGrupo(
    profesor: GrupoInvestigacionRequest
  ): Observable<GrupoInvestigacionRequest> {
    return this.httpClient.post<GrupoInvestigacionRequest>(
      `${this.grupoEndpoint}/create`,
      profesor
    );
  }

  public editGrupo(
    grupo: GrupoInvestigacionRequest,
    grupoNombre: string,
    grupoCodigo: number
  ): Observable<GrupoInvestigacionRequest> {
    return this.httpClient.put<GrupoInvestigacionRequest>(
      `${this.grupoEndpoint}/edit/${encodeURIComponent(grupoNombre || '')}/${encodeURIComponent(grupoCodigo || '')}`,
      grupo
    );
  }

  public findAllGrupo(
    pagination: CustomTablePaginateDto
  ): Observable<CustomTablePaginatorDto> {
    return this.httpClient.get<CustomTablePaginatorDto>(
      `${this.grupoEndpoint}/all?${Utils.getQueryParams(pagination)}`
    );
  }

  public deleteGrupo(grupo: GrupoInvestigacionRequest): Observable<DeleteDto>{
    return this.httpClient.delete<DeleteDto>(
      `${this.grupoEndpoint}/delete/${encodeURIComponent(grupo.nombreGrupoInvestigacion || '')}/${encodeURIComponent(grupo.codigoGrupoInvestigacion || '')}`
    );
  }

  public findGrupo(nombre: string, codigo: number): Observable<GrupoInvestigacionRequest>{
    return this.httpClient.get<GrupoInvestigacionRequest>(
      `${this.grupoEndpoint}/find/${encodeURIComponent(nombre || '')}/${encodeURIComponent(codigo || '')}`
    );
  }
}
