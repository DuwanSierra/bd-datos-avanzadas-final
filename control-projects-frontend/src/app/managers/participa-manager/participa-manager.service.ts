import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DeleteDto } from 'src/app/@core/dto/delete.dto';
import { CustomTablePaginateDto } from 'src/app/components/custom-table/custom-table.paginate.dto';
import { CustomTablePaginatorDto } from 'src/app/components/custom-table/custom-table.paginator.dto';
import { Utils } from 'src/app/utils/utils';
import { environment } from 'src/environments/environment';
import { ParticipaRequest } from '../request-dto/participa.request';

@Injectable({
  providedIn: 'root',
})
export class ParticipaManagerService {
  private participaEndpoint = environment.participaEndpoint;

  constructor(private httpClient: HttpClient) {}

  public createParticipa(
    participa: ParticipaRequest
  ): Observable<ParticipaRequest> {
    return this.httpClient.post<ParticipaRequest>(
      `${this.participaEndpoint}/create`,
      participa
    );
  }

  public editParticipa(
    participa: ParticipaRequest
  ): Observable<ParticipaRequest> {
    return this.httpClient.put<ParticipaRequest>(
      `${this.participaEndpoint}/edit/${encodeURIComponent(
        participa.proyecto?.grupoInvestigacion?.nombreGrupoInvestigacion || ''
      )}/
      ${encodeURIComponent(
        participa.proyecto?.grupoInvestigacion?.codigoGrupoInvestigacion || ''
      )}/
      ${encodeURIComponent(participa.proyecto?.codigo || '')}/
      ${encodeURIComponent(participa.profesor?.cedulaProfesor || '')}
      `,
      participa
    );
  }

  public findAllParticipa(
    pagination: CustomTablePaginateDto
  ): Observable<CustomTablePaginatorDto> {
    return this.httpClient.get<CustomTablePaginatorDto>(
      `${this.participaEndpoint}/all?${Utils.getQueryParams(pagination)}`
    );
  }

  public deleteParticipa(participa: ParticipaRequest): Observable<DeleteDto> {
    return this.httpClient.delete<DeleteDto>(
      `${this.participaEndpoint}/delete/${encodeURIComponent(
        participa.proyecto?.grupoInvestigacion?.nombreGrupoInvestigacion || ''
      )}/
      ${encodeURIComponent(
        participa.proyecto?.grupoInvestigacion?.codigoGrupoInvestigacion || ''
      )}/
      ${encodeURIComponent(participa.proyecto?.codigo || '')}/
      ${encodeURIComponent(participa.profesor?.cedulaProfesor || '')}`
    );
  }

  public findParticipa(
    nombreGrupoInvestigacion: string,
    codigoGrupoInvestigacion: number,
    codigo: number,
    cedulaProfesor: number,
  ): Observable<ParticipaRequest> {
    return this.httpClient.get<ParticipaRequest>(
      `${this.participaEndpoint}/find/${encodeURIComponent(
        nombreGrupoInvestigacion || ''
      )}/
      ${encodeURIComponent(
        codigoGrupoInvestigacion || ''
      )}/
      ${encodeURIComponent(codigo || '')}/
      ${encodeURIComponent(cedulaProfesor || '')}`
    );
  }
}
