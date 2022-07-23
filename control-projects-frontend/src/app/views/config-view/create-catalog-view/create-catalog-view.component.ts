import { Component, OnInit } from '@angular/core';
import { GenericConstants } from 'src/app/utils/general.constants';
import { GenericView } from 'src/app/utils/generic-view';

@Component({
  selector: 'app-create-catalog-view',
  templateUrl: './create-catalog-view.component.html',
  styleUrls: ['./create-catalog-view.component.scss'],
})
export class CreateCatalogViewComponent extends GenericView implements OnInit {
  public title = 'Crear área de interes';

  constructor() {
    super();
  }

  ngOnInit(): void {}

  saveEvent(isValid: boolean) {
    if (isValid) {
      console.log('Is valid, save');
    }
  }
}
