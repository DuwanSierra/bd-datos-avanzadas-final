import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { SedeRequest } from 'src/app/managers/request-dto/sede.request';
import { GenericView } from 'src/app/utils/generic-view';
import { CreateSedeViewService } from './create-sede-view.service';

@Component({
  selector: 'app-create-sede-view',
  templateUrl: './create-sede-view.component.html',
  styleUrls: ['./create-sede-view.component.scss'],
})
export class CreateSedeViewComponent extends GenericView implements OnInit {
  title: string = 'Crear nueva sede';
  public nombreSede = '';
  public codigoSede = '';
  constructor(public override activatedRoute: ActivatedRoute, public createSedeService: CreateSedeViewService) {
    super(activatedRoute);
  }

  ngOnInit(): void {
    this.getCurrentSede();
  }

  saveEvent(isValid: boolean) {
    if (isValid) {
      this.isEdit ? this.createSedeService.editSede(this.nombreSede, this.codigoSede) : this.createSedeService.createSede(this.nombreSede, this.codigoSede);
    }
  }

  getCurrentSede() {
    this.createSedeService.sedeDto.subscribe(
      (sede: SedeRequest) => {
        this.nombreSede = sede.nombre || '';
        this.codigoSede = sede.codigo || '';
      }
    );
  }

  override afterCheckIsEditMode(): void {
    this.title = 'Editar sede';
  }

  override afterLoadParams(data: any): void {
    if (data?.id) {
      this.createSedeService.findSede(data?.id);
    }
    else{
      this.createSedeService.resetAll();
    }
  }
}
