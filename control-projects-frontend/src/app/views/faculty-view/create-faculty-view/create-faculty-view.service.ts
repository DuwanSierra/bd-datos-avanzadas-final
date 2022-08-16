import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs';
import { FacultyManagerService } from 'src/app/managers/facultad-manager/faculty-manager.service';
import { FacultyRequest } from 'src/app/managers/request-dto/faculty.request';
import { PhoneRequest } from 'src/app/managers/request-dto/phone.request';
import { SedeRequest } from 'src/app/managers/request-dto/sede.request';

@Injectable({
  providedIn: 'root'
})
export class CreateFacultyViewService {

  public facultadDto = new BehaviorSubject<FacultyRequest>(
    new FacultyRequest()
  );

  constructor(
    private facultadManager: FacultyManagerService,
    private router: Router
  ) {}

  public createFacultad(nombre?: string, telefonos?: PhoneRequest[], sede?: SedeRequest) {
    let facultad = new FacultyRequest();
    facultad.facultadNombre = nombre;
    facultad.sede = sede;
    facultad.telefonos = telefonos;
    this.facultadManager.createFaculty(facultad).subscribe((res) => {
      this.resetAll();
      this.router.navigate(['faculty/list']);
    });
  }

  public editFacultad(nombre?: string, telefonos?: PhoneRequest[], sede?: SedeRequest) {
    let facultad = new FacultyRequest();
    facultad.facultadNombre = nombre;
    facultad.sede = sede;
    facultad.telefonos = telefonos;
    this.facultadManager.editFaculty(facultad, this.facultadDto.value.facultadNombre || '').subscribe((res) => {
      this.resetAll();
      this.router.navigate(['faculty/list']);
    });
  }

  public findFacultad(facultadNombre: string) {
    this.facultadManager
      .findFaculty(facultadNombre)
      .subscribe((res: FacultyRequest) => {
        this.facultadDto.next(res);
      });
  }

  public resetAll() {
    this.facultadDto.next(new FacultyRequest());
  }
}
