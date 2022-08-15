import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DeleteDto } from 'src/app/@core/dto/delete.dto';
import { CustomTablePaginateDto } from 'src/app/components/custom-table/custom-table.paginate.dto';
import { CustomTablePaginatorDto } from 'src/app/components/custom-table/custom-table.paginator.dto';
import { Utils } from 'src/app/utils/utils';
import { environment } from 'src/environments/environment';
import { RolRequest } from '../request-dto/rol.request';

@Injectable({
  providedIn: 'root'
})
export class RolManagerService {
  private rolEndpoint?:string;

  constructor(private httpClient: HttpClient) { 
    this.rolEndpoint = environment.rolEndpoint;
  }
  public findAllRol(
    pagination: CustomTablePaginateDto
  ): Observable<CustomTablePaginatorDto> {
    return this.httpClient.get<CustomTablePaginatorDto>(
      `${this.rolEndpoint}/all?${Utils.getQueryParams(pagination)}`
    );
  }

  public deleteRol(rol: RolRequest): Observable<DeleteDto>{
    return this.httpClient.delete<DeleteDto>(
      `${this.rolEndpoint}/delete/${rol.rolId}`
    );
  }

  public createRol(
    rol: RolRequest
  ): Observable<RolRequest> {
    return this.httpClient.post<RolRequest>(
      `${this.rolEndpoint}/create`,
      rol
    );
  }

  public editRol(
    rol: RolRequest
  ): Observable<RolRequest> {
    return this.httpClient.put<RolRequest>(
      `${this.rolEndpoint}/edit/${rol.rolId}`,
      rol
    );
  }

  public findRol(rolId: number): Observable<RolRequest>{
    return this.httpClient.get<RolRequest>(
      `${this.rolEndpoint}/find/${rolId}`
    );
  }
}
