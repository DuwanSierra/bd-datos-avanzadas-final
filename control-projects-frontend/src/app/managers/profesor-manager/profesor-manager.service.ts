import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DeleteDto } from 'src/app/@core/dto/delete.dto';
import { CustomTablePaginateDto } from 'src/app/components/custom-table/custom-table.paginate.dto';
import { CustomTablePaginatorDto } from 'src/app/components/custom-table/custom-table.paginator.dto';
import { Utils } from 'src/app/utils/utils';
import { environment } from 'src/environments/environment';
import { ProfessorRequest } from '../request-dto/professor.request';

@Injectable({
  providedIn: 'root'
})
export class ProfesorManagerService {

  private profesorEndpoint = environment.profesorEndpoint;

  constructor(private httpClient: HttpClient) {}

  public createProfessor(
    profesor: ProfessorRequest
  ): Observable<ProfessorRequest> {
    return this.httpClient.post<ProfessorRequest>(
      `${this.profesorEndpoint}/create`,
      profesor
    );
  }

  public editProfessor(
    profesorRequest: ProfessorRequest
  ): Observable<ProfessorRequest> {
    return this.httpClient.put<ProfessorRequest>(
      `${this.profesorEndpoint}/edit/${profesorRequest.cedulaProfesor}`,
      profesorRequest
    );
  }

  public findAllProfessor(
    pagination: CustomTablePaginateDto
  ): Observable<CustomTablePaginatorDto> {
    return this.httpClient.get<CustomTablePaginatorDto>(
      `${this.profesorEndpoint}/all?${Utils.getQueryParams(pagination)}`
    );
  }

  public deleteProfessor(profesor: ProfessorRequest): Observable<DeleteDto>{
    return this.httpClient.delete<DeleteDto>(
      `${this.profesorEndpoint}/delete/${profesor.cedulaProfesor}`
    );
  }

  public findProfessor(cedulaProfesor: number): Observable<ProfessorRequest>{
    return this.httpClient.get<ProfessorRequest>(
      `${this.profesorEndpoint}/find/${cedulaProfesor}`
    );
  }
}
