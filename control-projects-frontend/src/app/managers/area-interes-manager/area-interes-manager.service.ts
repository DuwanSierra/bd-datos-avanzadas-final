import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AreaInteresRequest } from '../request-dto/area-interes.request';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

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
}
