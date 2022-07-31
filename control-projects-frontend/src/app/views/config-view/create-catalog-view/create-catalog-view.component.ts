import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AreaInteresRequest } from 'src/app/managers/request-dto/area-interes.request';
import { GenericConstants } from 'src/app/utils/general.constants';
import { GenericView } from 'src/app/utils/generic-view';
import { CreateCatalogViewService } from './create-catalog-view.service';

@Component({
  selector: 'app-create-catalog-view',
  templateUrl: './create-catalog-view.component.html',
  styleUrls: ['./create-catalog-view.component.scss'],
})
export class CreateCatalogViewComponent extends GenericView implements OnInit {
  public title = 'Crear área de interés';
  public areaNombre: string = '';

  constructor(
    private createCatalogService: CreateCatalogViewService,
    public override activatedRoute: ActivatedRoute
  ) {
    super(activatedRoute);
  }

  ngOnInit(): void {
    this.getCurrentAreaInteres();
  }

  saveEvent(isValid: boolean) {
    if (isValid) {
      console.log(this.isEdit)
      this.isEdit ? this.createCatalogService.editAreaInteres(this.areaNombre) : this.createCatalogService.createAreaInteres(this.areaNombre || '');
    }
  }

  getCurrentAreaInteres() {
    this.createCatalogService.areaInteresDto.subscribe(
      (area: AreaInteresRequest) => {
        this.areaNombre = area.areaNombre || '';
      }
    );
  }

  override afterCheckIsEditMode(): void {
    this.title = 'Editar área de interés';
  }

  override afterLoadParams(data: any): void {
    if (data?.id) {
      this.createCatalogService.findAreaInteres(data?.id);
    }
  }
}
