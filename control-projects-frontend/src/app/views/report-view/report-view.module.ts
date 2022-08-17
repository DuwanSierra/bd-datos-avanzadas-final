import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ReportViewRoutingModule } from './report-view-routing.module';
import { ReportListComponent } from './report-list/report-list.component';
import { WindowModule } from 'src/app/components/window/window.module';
import { TabViewModule } from 'primeng/tabview';
import { ChartModule } from 'primeng/chart';
import { CustomDropdownModule } from 'src/app/components/custom-dropdown/custom-dropdown.module';
@NgModule({
  declarations: [ReportListComponent],
  imports: [
    CommonModule,
    ReportViewRoutingModule,
    TabViewModule,
    WindowModule,
    ChartModule,
    CustomDropdownModule
  ],
})
export class ReportViewModule {}
