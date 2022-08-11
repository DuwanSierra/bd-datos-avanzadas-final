import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ReportViewRoutingModule } from './report-view-routing.module';
import { ReportListComponent } from './report-list/report-list.component';


@NgModule({
  declarations: [
    ReportListComponent
  ],
  imports: [
    CommonModule,
    ReportViewRoutingModule
  ]
})
export class ReportViewModule { }
