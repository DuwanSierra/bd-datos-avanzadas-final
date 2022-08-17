import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { InvestigationProjectViewRoutingModule } from './investigation-project-view-routing.module';
import { CreateInvestigationProjectViewComponent } from './create-investigation-project-view/create-investigation-project-view.component';
import { ListInvestigationProjectViewComponent } from './list-investigation-project-view/list-investigation-project-view.component';

import { WindowModule } from 'src/app/components/window/window.module';
import { ReactiveFormsModule } from '@angular/forms';
import { InputTextFormModule } from 'src/app/components/input-text-form/input-text-form.module';
import { CustomDropdownModule } from 'src/app/components/custom-dropdown/custom-dropdown.module';
import { CustomMultipleInputTextModule } from 'src/app/components/custom-multiple-input-text/custom-multiple-input-text.module';
import { FormsModule } from '@angular/forms';
import { CalendarModule } from 'primeng/calendar';
import { CustomDatepickerModule } from 'src/app/components/custom-datepicker/custom-datepicker.module';
import { CustomTableModule } from 'src/app/components/custom-table/custom-table.module';
import { AddParticipaProjectViewComponent } from './add-participa-project-view/add-participa-project-view.component';

@NgModule({
  declarations: [
    CreateInvestigationProjectViewComponent,
    ListInvestigationProjectViewComponent,
    AddParticipaProjectViewComponent
  ],
  imports: [
    CommonModule,
    InvestigationProjectViewRoutingModule,
    WindowModule,
    ReactiveFormsModule,
    InputTextFormModule,
    CustomDropdownModule,
    CustomDatepickerModule,
    CustomMultipleInputTextModule,
    FormsModule,
    CalendarModule,
    CustomTableModule

  ]
})
export class InvestigationProjectViewModule { }
