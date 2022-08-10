import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { InvestigationGroupViewRoutingModule } from './investigation-group-view-routing.module';
import { CreateInvestigationGroupViewComponent } from './create-investigation-group-view/create-investigation-group-view.component';
import { ListInvestigationGroupViewComponent } from './list-investigation-group-view/list-investigation-group-view.component';


import { WindowModule } from 'src/app/components/window/window.module';
import { ReactiveFormsModule } from '@angular/forms';
import { InputTextFormModule } from 'src/app/components/input-text-form/input-text-form.module';
import { CustomDropdownModule } from 'src/app/components/custom-dropdown/custom-dropdown.module';
import { CustomMultipleInputTextModule } from 'src/app/components/custom-multiple-input-text/custom-multiple-input-text.module';


@NgModule({
  declarations: [
    CreateInvestigationGroupViewComponent,
    ListInvestigationGroupViewComponent
  ],
  imports: [ 
    CommonModule,
    InvestigationGroupViewRoutingModule,
    WindowModule,
    ReactiveFormsModule,
    InputTextFormModule,
    CustomDropdownModule,
    CustomMultipleInputTextModule
  ]
})
export class InvestigationGroupViewModule { }
