import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ConfigViewRoutingModule } from './config-view-routing.module';
import { CreateCatalogViewComponent } from './create-catalog-view/create-catalog-view.component';
import { ListCatalogViewComponent } from './list-catalog-view/list-catalog-view.component';
import { WindowModule } from 'src/app/components/window/window.module';
import { InputTextFormModule } from 'src/app/components/input-text-form/input-text-form.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    CreateCatalogViewComponent,
    ListCatalogViewComponent
  ],
  imports: [
    CommonModule,
    ConfigViewRoutingModule,
    WindowModule,
    InputTextFormModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class ConfigViewModule { }
