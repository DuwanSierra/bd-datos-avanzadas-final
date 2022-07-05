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
    title: "Crear catálogo"
  },
  {
    path: 'edit/:id',
    component: CreateCatalogViewComponent,
    title: "Editar catálogo",
    data: {
      isEdit: true,
    },
  },
  {
    path: 'list',
    title: "Listado de catálogos",
    component: ListCatalogViewComponent,
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ConfigViewRoutingModule {}
