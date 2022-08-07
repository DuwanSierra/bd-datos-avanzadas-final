import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProfessorViewRoutingModule } from './professor-view-routing.module';
import { CreateProfessorViewComponent } from './create-professor-view/create-professor-view.component';
import { ListprofessorViewComponent } from './list-professor-view/listprofessor-view.component';

import { WindowModule } from 'src/app/components/window/window.module';
import { ReactiveFormsModule } from '@angular/forms';
import { InputTextFormModule } from 'src/app/components/input-text-form/input-text-form.module';
import { CustomDropdownModule } from 'src/app/components/custom-dropdown/custom-dropdown.module';
import { CustomMultipleInputTextModule } from 'src/app/components/custom-multiple-input-text/custom-multiple-input-text.module';

@NgModule({
  declarations: [
    CreateProfessorViewComponent,
    ListprofessorViewComponent
  ],
  imports: [
    CommonModule,
    ProfessorViewRoutingModule,
    
    WindowModule,
    ReactiveFormsModule,
    InputTextFormModule,
    CustomDropdownModule,
    CustomMultipleInputTextModule
  ]
})
export class ProfessorViewModule { }
