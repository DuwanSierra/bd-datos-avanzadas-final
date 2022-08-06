import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateFacultyViewComponent } from './create-faculty-view/create-faculty-view.component';
import { ListFacultyViewComponent } from './list-faculty-view/list-faculty-view.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'list',
    pathMatch: 'full',
  },
  {
    path: 'list',
    component: ListFacultyViewComponent,
    title: 'Listado de facultades',
  },
  {
    path: 'create',
    component: CreateFacultyViewComponent,
    title: 'Crear facultad',
  },
  {
    path: 'edit/:id',
    component: CreateFacultyViewComponent,
    title: 'Editar facultad',
    data: {
      isEdit: true,
    },
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class FacultyViewRoutingModule {}
