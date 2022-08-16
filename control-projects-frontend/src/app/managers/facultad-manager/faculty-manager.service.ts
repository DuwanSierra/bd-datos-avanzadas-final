import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DeleteDto } from 'src/app/@core/dto/delete.dto';
import { CustomTablePaginateDto } from 'src/app/components/custom-table/custom-table.paginate.dto';
import { CustomTablePaginatorDto } from 'src/app/components/custom-table/custom-table.paginator.dto';
import { Utils } from 'src/app/utils/utils';
import { environment } from 'src/environments/environment';
import { FacultyRequest } from '../request-dto/faculty.request';

@Injectable({
  providedIn: 'root'
})
export class FacultyManagerService {

  private facultadEndpoint = environment.facultadEndpoint;

  constructor(private httpClient: HttpClient) {}

  public createFaculty(
    profesor: FacultyRequest
  ): Observable<FacultyRequest> {
    return this.httpClient.post<FacultyRequest>(
      `${this.facultadEndpoint}/create`,
      profesor
    );
  }

  public editFaculty(
    facultadRequest: FacultyRequest,
    facultadId: string
  ): Observable<FacultyRequest> {
    return this.httpClient.put<FacultyRequest>(
      `${this.facultadEndpoint}/edit/${encodeURIComponent(facultadId || '')}`,
      facultadRequest
    );
  }

  public findAllFaculty(
    pagination: CustomTablePaginateDto
  ): Observable<CustomTablePaginatorDto> {
    return this.httpClient.get<CustomTablePaginatorDto>(
      `${this.facultadEndpoint}/all?${Utils.getQueryParams(pagination)}`
    );
  }

  public deleteFaculty(facultad: FacultyRequest): Observable<DeleteDto>{
    return this.httpClient.delete<DeleteDto>(
      `${this.facultadEndpoint}/delete/${encodeURIComponent(facultad.facultadNombre || '')}`
    );
  }

  public findFaculty(facultadNombre: string): Observable<FacultyRequest>{
    return this.httpClient.get<FacultyRequest>(
      `${this.facultadEndpoint}/find/${encodeURIComponent(facultadNombre)}`
    );
  }
}
