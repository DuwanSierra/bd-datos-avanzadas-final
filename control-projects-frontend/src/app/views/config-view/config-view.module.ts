import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ConfigViewRoutingModule } from './config-view-routing.module';
import { CreateCatalogViewComponent } from './create-catalog-view/create-catalog-view.component';
import { ListCatalogViewComponent } from './list-catalog-view/list-catalog-view.component';
import { WindowModule } from 'src/app/components/window/window.module';
import { InputTextFormModule } from 'src/app/components/input-text-form/input-text-form.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CustomTableModule } from 'src/app/components/custom-table/custom-table.module';
import { CreateSedeViewComponent } from './create-sede-view/create-sede-view.component';
import { ListSedeViewComponent } from './list-sede-view/list-sede-view.component';
import { CreateRolViewComponent } from './create-rol-view/create-rol-view.component';
import { CreateCargoViewComponent } from './create-cargo-view/create-cargo-view.component';
import { ListCargoViewComponent } from './list-cargo-view/list-cargo-view.component';
import { ListRolViewComponent } from './list-rol-view/list-rol-view.component';


@NgModule({
  declarations: [
    CreateCatalogViewComponent,
    ListCatalogViewComponent,
    CreateSedeViewComponent,
    ListSedeViewComponent,
    CreateRolViewComponent,
    CreateCargoViewComponent,
    ListCargoViewComponent,
    ListRolViewComponent
  ],
  imports: [
    CommonModule,
    ConfigViewRoutingModule,
    WindowModule,
    InputTextFormModule,
    FormsModule,
    ReactiveFormsModule,
    CustomTableModule
  ]
})
export class ConfigViewModule { }
