import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { RolRequest } from 'src/app/managers/request-dto/rol.request';
import { GenericView } from 'src/app/utils/generic-view';
import { CreateRolViewService } from './create-rol-view.service';

@Component({
  selector: 'app-create-rol-view',
  templateUrl: './create-rol-view.component.html',
  styleUrls: ['./create-rol-view.component.scss']
})
export class CreateRolViewComponent extends GenericView implements OnInit {
  title: string = 'Crear nuevo rol';
  public nombreRol = '';
  constructor(
    public override activatedRoute: ActivatedRoute,
    public createRolService: CreateRolViewService
  ) {
    super(activatedRoute);
  }

  ngOnInit(): void {
    this.getCurrentSede();
  }

  saveEvent(isValid: boolean) {
    if (isValid) {
      this.isEdit
        ? this.createRolService.editRol(this.nombreRol)
        : this.createRolService.createRol(this.nombreRol);
    }
  }

  getCurrentSede() {
    this.createRolService.rol.subscribe((sede: RolRequest) => {
      this.nombreRol = sede.rol || '';
    });
  }

  override afterCheckIsEditMode(): void {
    this.title = 'Editar rol';
  }

  override afterLoadParams(data: any): void {
    if (data?.id) {
      this.createRolService.findRol(data?.id);
    } else {
      this.createRolService.resetAll();
    }
  }
}
