import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DeleteDto } from 'src/app/@core/dto/delete.dto';
import { CustomTablePaginateDto } from 'src/app/components/custom-table/custom-table.paginate.dto';
import { CustomTablePaginatorDto } from 'src/app/components/custom-table/custom-table.paginator.dto';
import { Utils } from 'src/app/utils/utils';
import { environment } from 'src/environments/environment';
import { CargoRequest } from '../request-dto/cargo.request';

@Injectable({
  providedIn: 'root'
})
export class CargoManagerService {

  private cargoEndpoint?:string;

  constructor(private httpClient: HttpClient) { 
    this.cargoEndpoint = environment.cargoEndpoint;
  }
  public findAllCargo(
    pagination: CustomTablePaginateDto
  ): Observable<CustomTablePaginatorDto> {
    return this.httpClient.get<CustomTablePaginatorDto>(
      `${this.cargoEndpoint}/all?${Utils.getQueryParams(pagination)}`
    );
  }

  public deleteCargo(cargo: CargoRequest): Observable<DeleteDto>{
    return this.httpClient.delete<DeleteDto>(
      `${this.cargoEndpoint}/delete/${cargo.cargoId}`
    );
  }

  public createCargo(
    rol: CargoRequest
  ): Observable<CargoRequest> {
    return this.httpClient.post<CargoRequest>(
      `${this.cargoEndpoint}/create`,
      rol
    );
  }

  public editCargo(
    cargo: CargoRequest
  ): Observable<CargoRequest> {
    return this.httpClient.put<CargoRequest>(
      `${this.cargoEndpoint}/edit/${cargo.cargoId}`,
      cargo
    );
  }

  public findCargo(cargoId: number): Observable<CargoRequest>{
    return this.httpClient.get<CargoRequest>(
      `${this.cargoEndpoint}/find/${cargoId}`
    );
  }
}
