import { Component, OnInit } from '@angular/core';
import { GenericView } from 'src/app/utils/generic-view';
import { ActivatedRoute } from '@angular/router';
import { ProfessorRequest } from 'src/app/managers/request-dto/professor.request';
import { FacultyManagerService } from 'src/app/managers/facultad-manager/faculty-manager.service';
import { CreateProfessorViewService } from './create-professor-view.service';
import { CargoManagerService } from 'src/app/managers/cargo-manager/cargo-manager.service';
import { TituloRequest } from 'src/app/managers/request-dto/titulo.request';

@Component({
  selector: 'app-create-professor-view',
  templateUrl: './create-professor-view.component.html',
  styleUrls: ['./create-professor-view.component.scss'],
})
export class CreateProfessorViewComponent
  extends GenericView
  implements OnInit
{
  profesor = new ProfessorRequest();
  title = 'Crear profesor';
  public titles: any[] = [
    {
      id: 0,
      value: '',
    },
  ];

  constructor(
    public override activatedRoute: ActivatedRoute,
    public facultadManager: FacultyManagerService,
    public profesorService: CreateProfessorViewService,
    public cargoManager: CargoManagerService
  ) {
    super(activatedRoute);
  }

  ngOnInit(): void {}

  saveEvent(isValid: boolean) {
    if (isValid) {
      this.isEdit
        ? this.profesorService.editProfesor(this.profesor)
        : this.profesorService.createProfesor(this.profesor);
    }
  }

  setTitles(titles: any[]) {
    this.titles = titles;
    if (!this.profesor.titulos) {
      this.profesor.titulos = [];
    }
    this.titles.forEach((titulo) => {
      if (titulo?.value) {
        let tituloCreated = this.profesor.titulos?.find(
          (tituloHave) => tituloHave.titulo === titulo?.value
        );
        if (
          tituloCreated &&
          this.profesor.titulos?.indexOf(tituloCreated) &&
          this.profesor.titulos?.indexOf(tituloCreated) >= 0
        ) {
          tituloCreated.titulo = titulo?.value;
          this.profesor.titulos[this.profesor.titulos?.indexOf(tituloCreated)] =
            tituloCreated;
        } else {
          let tituloRequest = new TituloRequest();
          tituloRequest.titulo = titulo?.value;
          this.profesor.titulos?.push(tituloRequest);
        }
      }
    });
  }

  override afterCheckIsEditMode(): void {
    this.title = 'Editar profesor';
  }

  override afterLoadParams(data: any): void {
    if (data?.id) {
      this.profesorService.findProfesor(data?.id);
    } else {
      this.profesorService.resetAll();
    }
  }
}
