import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ConfigViewRoutingModule } from './config-view-routing.module';
import { CreateCatalogViewComponent } from './create-catalog-view/create-catalog-view.component';
import { ListCatalogViewComponent } from './list-catalog-view/list-catalog-view.component';
import { WindowModule } from 'src/app/components/window/window.module';


@NgModule({
  declarations: [
    CreateCatalogViewComponent,
    ListCatalogViewComponent
  ],
  imports: [
    CommonModule,
    ConfigViewRoutingModule,
    WindowModule
  ]
})
export class ConfigViewModule { }
