import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs';
import { ProfesorManagerService } from 'src/app/managers/profesor-manager/profesor-manager.service';
import { ProfessorRequest } from 'src/app/managers/request-dto/professor.request';

@Injectable({
  providedIn: 'root'
})
export class CreateProfessorViewService {

  public profesorDto = new BehaviorSubject<ProfessorRequest>(
    new ProfessorRequest()
  );

  public titles : any[]= [];

  constructor(
    private profesorManager: ProfesorManagerService,
    private router: Router
  ) {}

  public createProfesor(profesorRequest: ProfessorRequest) {
    this.profesorManager.createProfessor(profesorRequest).subscribe((res) => {
      this.resetAll();
      this.router.navigate(['professor/list']);
    });
  }

  public editProfesor(profesorRequest: ProfessorRequest) {
    this.profesorManager.editProfessor(profesorRequest).subscribe((res) => {
      this.resetAll();
      this.router.navigate(['professor/list']);
    });
  }

  public findProfesor(cedulaProfesor: number) {
    this.profesorManager
      .findProfessir(cedulaProfesor)
      .subscribe((res: ProfessorRequest) => {
        this.profesorDto.next(res);
      });
  }

  public resetAll() {
    this.profesorDto.next(new ProfessorRequest());
  }
}
