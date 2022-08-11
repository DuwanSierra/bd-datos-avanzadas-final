import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ReportListComponent } from './report-list/report-list.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'list',
    pathMatch: 'full',
  },
  {
    path: 'professor',
    component: ReportListComponent,
    title: 'Reporte de profesores',
  },
  {
    path: 'investigation-project',
    component: ReportListComponent,
    title: 'Reporte de grupos investigacion',
  },
  {
    path: 'investigation-group',
    component: ReportListComponent,
    title: 'Reporte de grupos investigacion',
  },
  {
    path: 'faculty',
    component: ReportListComponent,
    title: 'Reporte de projectos de investigacion',
  },
  

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ReportViewRoutingModule { }
