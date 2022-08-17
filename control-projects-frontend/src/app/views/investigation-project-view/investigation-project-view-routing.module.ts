import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListInvestigationProjectViewComponent } from './list-investigation-project-view/list-investigation-project-view.component';
import { CreateInvestigationProjectViewComponent } from './create-investigation-project-view/create-investigation-project-view.component';
import { AddParticipaProjectViewComponent } from './add-participa-project-view/add-participa-project-view.component';

const routes: Routes = [ 
  
  {
  path: '',
  redirectTo: 'list',
  pathMatch: 'full',
},
{
  path: 'list',
  component: ListInvestigationProjectViewComponent,
  title: 'Listado de proyectos de investigación',
},
{
  path: 'create',
  component: CreateInvestigationProjectViewComponent,
  title: 'Crear proyecto de investigacion',
},
{
  path: 'add-participant',
  component: AddParticipaProjectViewComponent,
  title: 'Añádir participante a un proyecto de investigacion',
},
{
  path: 'edit-participant/:nombreGrupo/:codigoGrupo/:codigoProyecto/:cedula',
  component: AddParticipaProjectViewComponent,
  title: 'Editar participante a un proyecto de investigacion',
},
{
  path: 'edit/:nombre/:codigo/:codigoProyecto',
  component: CreateInvestigationProjectViewComponent,
  title: 'Editar proyecto de investigacion',
  data: {
    isEdit: true,
  },
},


];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class InvestigationProjectViewRoutingModule { }
