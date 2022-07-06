import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateCatalogViewComponent } from './create-catalog-view/create-catalog-view.component';
import { ListCatalogViewComponent } from './list-catalog-view/list-catalog-view.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'list',
    pathMatch: 'full',
  },
  {
    path: 'create',
    component: CreateCatalogViewComponent,
    title: "Crear área de interés"
  },
  {
    path: 'edit/:id',
    component: CreateCatalogViewComponent,
    title: "Editar área de interés",
    data: {
      isEdit: true,
    },
  },
  {
    path: 'list',
    title: "Listado de áreas de interés",
    component: ListCatalogViewComponent,
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ConfigViewRoutingModule {}
