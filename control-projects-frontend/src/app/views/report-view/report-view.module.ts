import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ReportViewRoutingModule } from './report-view-routing.module';
import { ReportListComponent } from './report-list/report-list.component';
import { WindowModule } from 'src/app/components/window/window.module';
import {TableModule} from 'primeng/table';

@NgModule({
  declarations: [
    ReportListComponent
  ],
  imports: [
    CommonModule,
    ReportViewRoutingModule,
    
    WindowModule,
    TableModule
  ]
})
export class ReportViewModule { }
