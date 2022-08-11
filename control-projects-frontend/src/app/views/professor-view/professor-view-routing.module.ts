import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateProfessorViewComponent } from './create-professor-view/create-professor-view.component';
import { ListprofessorViewComponent } from './list-professor-view/listprofessor-view.component';


const routes: Routes = [
  {
    path: '',
    redirectTo: 'list',
    pathMatch: 'full',
  },
  {
    path: 'list',
    component: ListprofessorViewComponent,
    title: 'Listado de profesores',
  },
  {
    path: 'create',
    component: CreateProfessorViewComponent,
    title: 'Crear facultad',
  },
  {
    path: 'edit/:id',
    component: CreateProfessorViewComponent,
    title: 'Editar Profesor',
    data: {
      isEdit: true,
    },
  },



];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProfessorViewRoutingModule { }
