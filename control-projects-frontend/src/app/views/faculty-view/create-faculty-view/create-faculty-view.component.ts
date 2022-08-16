import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProfesorManagerService } from 'src/app/managers/profesor-manager/profesor-manager.service';
import { FacultyRequest } from 'src/app/managers/request-dto/faculty.request';
import { PhoneRequest } from 'src/app/managers/request-dto/phone.request';
import { SedeManagerService } from 'src/app/managers/sede-manager/sede-manager.service';
import { GenericView } from 'src/app/utils/generic-view';
import { CreateFacultyViewService } from './create-faculty-view.service';

@Component({
  selector: 'app-create-faculty-view',
  templateUrl: './create-faculty-view.component.html',
  styleUrls: ['./create-faculty-view.component.scss'],
})
export class CreateFacultyViewComponent extends GenericView implements OnInit {
  title = 'Crear facultad';
  faculty: FacultyRequest = new FacultyRequest();
  phones = [
    {
      id: 0,
      value: '',
    },
  ];

  constructor(
    public override activatedRoute: ActivatedRoute,
    public sedeManager: SedeManagerService,
    public createFacultadService: CreateFacultyViewService
  ) {
    super(activatedRoute);
  }

  ngOnInit(): void {
    this.getCurrentFacultad();
  }

  saveEvent(isValid: boolean) {
    if (isValid) {
      this.isEdit
        ? this.createFacultadService.editFacultad(
            this.faculty.facultadNombre,
            this.faculty.telefonos,
            this.faculty.sede
          )
        : this.createFacultadService.createFacultad(
            this.faculty.facultadNombre,
            this.faculty.telefonos,
            this.faculty.sede
          );
    }
  }

  getCurrentFacultad() {
    this.createFacultadService.facultadDto.subscribe(
      (facultad: FacultyRequest) => {
        this.faculty.facultadNombre = facultad.facultadNombre || '';
        this.faculty.sede = facultad.sede;
        this.faculty.telefonos = facultad.telefonos;
        let items= facultad.telefonos?.map((newPhone, index) => {
          return {
            id: index,
            value: newPhone.telefono || '',
          };
        });
        this.phones = items || [];
      }
    );
  }

  override afterCheckIsEditMode(): void {
    this.title = 'Editar área de interés';
  }

  override afterLoadParams(data: any): void {
    if (data?.id) {
      this.createFacultadService.findFacultad(data?.id);
    } else {
      this.createFacultadService.resetAll();
    }
  }

  setPhones(phones: any[]) {
    this.phones = phones;
    if (!this.faculty.telefonos) {
      this.faculty.telefonos = [];
    }
    this.phones.forEach((phone) => {
      if (phone?.value) {
        let phoneCreated = this.faculty.telefonos?.find(
          (tel) => tel.telefono === phone?.value
        );
        if (
          phoneCreated &&
          this.faculty.telefonos?.indexOf(phoneCreated) &&
          this.faculty.telefonos?.indexOf(phoneCreated) >= 0
        ) {
          phoneCreated.telefono = phone?.value;
          this.faculty.telefonos[
            this.faculty.telefonos?.indexOf(phoneCreated)
          ] = phoneCreated;
        } else {
          let phoneFaculty = new PhoneRequest();
          phoneFaculty.telefono = phone?.value;
          this.faculty.telefonos?.push(phoneFaculty);
        }
      }
    });
  }
}
