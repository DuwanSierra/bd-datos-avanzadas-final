import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AreaInteresRequest } from '../request-dto/area-interes.request';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { CustomTablePaginateDto } from 'src/app/components/custom-table/custom-table.paginate.dto';
import { CustomTablePaginatorDto } from 'src/app/components/custom-table/custom-table.paginator.dto';
import { Utils } from 'src/app/utils/utils';
import { DeleteDto } from 'src/app/@core/dto/delete.dto';

@Injectable({
  providedIn: 'root',
})
export class AreaInteresManagerService {
  private areaInteresendpoint = environment.areaInteresEndpoint;

  constructor(private httpClient: HttpClient) {}

  public createAreaInteres(
    areaInteres: AreaInteresRequest
  ): Observable<AreaInteresRequest> {
    return this.httpClient.post<AreaInteresRequest>(
      `${this.areaInteresendpoint}/create`,
      areaInteres
    );
  }

  public editAreaInteres(
    areaInteres: AreaInteresRequest
  ): Observable<AreaInteresRequest> {
    return this.httpClient.put<AreaInteresRequest>(
      `${this.areaInteresendpoint}/edit/${areaInteres.areaId}`,
      areaInteres
    );
  }

  public findAllAreaInteres(
    pagination: CustomTablePaginateDto
  ): Observable<CustomTablePaginatorDto> {
    return this.httpClient.get<CustomTablePaginatorDto>(
      `${this.areaInteresendpoint}/all?${Utils.getQueryParams(pagination)}`
    );
  }

  public deleteAreaInteres(areaInteres: AreaInteresRequest): Observable<DeleteDto>{
    return this.httpClient.delete<DeleteDto>(
      `${this.areaInteresendpoint}/delete/${areaInteres.areaId}`
    );
  }

  public findAreaInteres(areaInteresId: number): Observable<AreaInteresRequest>{
    return this.httpClient.get<AreaInteresRequest>(
      `${this.areaInteresendpoint}/find/${areaInteresId}`
    );
  }
}
