import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateCatalogViewComponent } from './create-catalog-view/create-catalog-view.component';
import { CreateSedeViewComponent } from './create-sede-view/create-sede-view.component';
import { ListCatalogViewComponent } from './list-catalog-view/list-catalog-view.component';
import { ListSedeViewComponent } from './list-sede-view/list-sede-view.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'area/list',
    pathMatch: 'full',
  },
  {
    path: 'area',
    children: [
      {
        path: 'create',
        component: CreateCatalogViewComponent,
        title: 'Crear área de interés',
      },
      {
        path: 'edit/:id',
        component: CreateCatalogViewComponent,
        title: 'Editar área de interés',
        data: {
          isEdit: true,
        },
      },
      {
        path: 'list',
        title: 'Listado de áreas de interés',
        component: ListCatalogViewComponent,
      },
    ],
  },
  {
    path: 'sede',
    children: [
      {
        path: 'create',
        component: CreateSedeViewComponent,
        title: 'Crear sede',
      },
      {
        path: 'edit/:id',
        component: CreateSedeViewComponent,
        title: 'Editar sede',
        data: {
          isEdit: true,
        },
      },
      {
        path: 'list',
        component: ListSedeViewComponent,
        title: 'Listado de sedes',
      },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ConfigViewRoutingModule {}
