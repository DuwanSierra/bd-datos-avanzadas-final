import { Component, OnInit } from '@angular/core';
import { GenericConstants } from 'src/app/utils/general.constants';
import { GenericView } from 'src/app/utils/generic-view';
import { CreateCatalogViewService } from './create-catalog-view.service';

@Component({
  selector: 'app-create-catalog-view',
  templateUrl: './create-catalog-view.component.html',
  styleUrls: ['./create-catalog-view.component.scss'],
})
export class CreateCatalogViewComponent extends GenericView implements OnInit {
  public title = 'Crear área de interes';
  public areaNombre: string = '';

  constructor(private createCatalogService: CreateCatalogViewService) {
    super();
  }

  ngOnInit(): void {}

  saveEvent(isValid: boolean) {
    if (isValid) {
      this.createCatalogService.createAreaInteres(this.areaNombre || '');
    }
  }
}
