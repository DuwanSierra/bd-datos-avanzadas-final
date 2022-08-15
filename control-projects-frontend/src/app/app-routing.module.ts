import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';


const routes: Routes = [
  {
    path: 'config',
    loadChildren: ()=> import('./views/config-view/config-view.module').then(m=>m.ConfigViewModule)
  },
  {
    path: 'faculty',
    loadChildren: ()=> import('./views/faculty-view/faculty-view.module').then(m=>m.FacultyViewModule)
  },
  {
    path: 'professor',
    loadChildren: ()=> import('./views/professor-view/professor-view.module').then(m=>m.ProfessorViewModule)
  },
  {
    path: 'investigation-group',
    loadChildren: ()=> import('./views/investigation-group-view/investigation-group-view.module').then(m=>m.InvestigationGroupViewModule)
  },
  {
    path: 'investigation-project',
    loadChildren: ()=> import('./views/investigation-project-view/investigation-project-view.module').then(m=>m.InvestigationProjectViewModule)
  },
  {
    path: 'report',
    loadChildren: ()=> import('./views/report-view/report-view.module').then(m=>m.ReportViewModule)
  },


 

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
