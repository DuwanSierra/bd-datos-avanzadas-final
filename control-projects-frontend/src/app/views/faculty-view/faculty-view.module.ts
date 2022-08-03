import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FacultyViewRoutingModule } from './faculty-view-routing.module';
import { CreateFacultyViewComponent } from './create-faculty-view/create-faculty-view.component';
import { ListFacultyViewComponent } from './list-faculty-view/list-faculty-view.component';
import { WindowModule } from 'src/app/components/window/window.module';
import { ReactiveFormsModule } from '@angular/forms';
import { InputTextFormModule } from 'src/app/components/input-text-form/input-text-form.module';
import { CustomDropdownModule } from 'src/app/components/custom-dropdown/custom-dropdown.module';
import { CustomMultipleInputTextModule } from 'src/app/components/custom-multiple-input-text/custom-multiple-input-text.module';


@NgModule({
  declarations: [
    CreateFacultyViewComponent,
    ListFacultyViewComponent
  ],
  imports: [
    CommonModule,
    FacultyViewRoutingModule,
    WindowModule,
    ReactiveFormsModule,
    InputTextFormModule,
    CustomDropdownModule,
    CustomMultipleInputTextModule
  ]
})
export class FacultyViewModule { }
