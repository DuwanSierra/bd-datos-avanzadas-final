import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DeleteDto } from 'src/app/@core/dto/delete.dto';
import { CustomTablePaginateDto } from 'src/app/components/custom-table/custom-table.paginate.dto';
import { CustomTablePaginatorDto } from 'src/app/components/custom-table/custom-table.paginator.dto';
import { Utils } from 'src/app/utils/utils';
import { environment } from 'src/environments/environment';
import { SedeRequest } from '../request-dto/sede.request';

@Injectable({
  providedIn: 'root'
})
export class SedeManagerService {
  private sedeEndpoint = environment.sedeEndpoint;

  constructor(private httpClient: HttpClient) {}

  public createSede(
    sede: SedeRequest
  ): Observable<SedeRequest> {
    return this.httpClient.post<SedeRequest>(
      `${this.sedeEndpoint}/create`,
      sede
    );
  }

  public editSede(
    sede: SedeRequest
  ): Observable<SedeRequest> {
    return this.httpClient.put<SedeRequest>(
      `${this.sedeEndpoint}/edit/${sede.sedeId}`,
      sede
    );
  }

  public findAllSedes(
    pagination: CustomTablePaginateDto
  ): Observable<CustomTablePaginatorDto> {
    return this.httpClient.get<CustomTablePaginatorDto>(
      `${this.sedeEndpoint}/all?${Utils.getQueryParams(pagination)}`
    );
  }

  public deleteSede(sede: SedeRequest): Observable<DeleteDto>{
    return this.httpClient.delete<DeleteDto>(
      `${this.sedeEndpoint}/delete/${sede.sedeId}`
    );
  }

  public findSedeById(sedeId: number): Observable<SedeRequest>{
    return this.httpClient.get<SedeRequest>(
      `${this.sedeEndpoint}/find/${sedeId}`
    );
  }
}
