import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListInvestigationGroupViewComponent } from './list-investigation-group-view/list-investigation-group-view.component';
import { CreateInvestigationGroupViewComponent } from './create-investigation-group-view/create-investigation-group-view.component';

const routes: Routes = [

  {
    path: '',
    redirectTo: 'list',
    pathMatch: 'full',
  },
  {
    path: 'list',
    component: ListInvestigationGroupViewComponent,
    title: 'Listado de profesores',
  },
  {
    path: 'create',
    component: CreateInvestigationGroupViewComponent,
    title: 'Crear grupo de investigacion',
  },
  {
    path: 'edit/:nombre/:codigo',
    component: CreateInvestigationGroupViewComponent,
    title: 'Editar grupo de investigacion',
    data: {
      isEdit: true,
    },
  },




];


@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class InvestigationGroupViewRoutingModule { }
