import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FacultyRequest } from 'src/app/managers/request-dto/faculty.request';
import { PhoneRequest } from 'src/app/managers/request-dto/phone.request';
import { SedeManagerService } from 'src/app/managers/sede-manager/sede-manager.service';
import { GenericView } from 'src/app/utils/generic-view';

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
    public sedeManager: SedeManagerService
  ) {
    super(activatedRoute);
  }

  ngOnInit(): void {}

  saveEvent(isValid: boolean) {
    if (isValid) {
      this.isEdit;
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
          (tel) => tel.idTelefono === phone?.id
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
          phoneFaculty.idTelefono = phone?.id;
          phoneFaculty.telefono = phone?.value;
          this.faculty.telefonos?.push(phoneFaculty);
        }
      }
    });
  }
}
