import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { ProjectsByProfessorView } from '../request-dto/projects-by-professor.view';
import { ReportActiveInactive } from '../request-dto/report-active-ianctive.report';

@Injectable({
  providedIn: 'root'
})
export class ReportManagerService {
  private reportEndpoint = environment.reportEndpoint;

  constructor(private httpClient: HttpClient) { }

  getProjectByCC(cedula: number){
    return this.httpClient.get<ProjectsByProfessorView[]>(
      `${this.reportEndpoint}/report-project-by-professor/${cedula}`
    );
  }

  getProjectsActiveInactives(){
    return this.httpClient.get<ReportActiveInactive[]>(
      `${this.reportEndpoint}/report-actives-inactives`
    );
  }
}
