import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateCargoViewComponent } from './create-cargo-view/create-cargo-view.component';
import { CreateCatalogViewComponent } from './create-catalog-view/create-catalog-view.component';
import { CreateRolViewComponent } from './create-rol-view/create-rol-view.component';
import { CreateSedeViewComponent } from './create-sede-view/create-sede-view.component';
import { ListCargoViewComponent } from './list-cargo-view/list-cargo-view.component';
import { ListCatalogViewComponent } from './list-catalog-view/list-catalog-view.component';
import { ListRolViewComponent } from './list-rol-view/list-rol-view.component';
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
  {
    path: 'rol',
    children: [
      {
        path: 'create',
        component: CreateRolViewComponent,
        title: 'Crear rol',
      },
      {
        path: 'edit/:id',
        component: CreateRolViewComponent,
        title: 'Editar rol',
        data: {
          isEdit: true,
        },
      },
      {
        path: 'list',
        component: ListRolViewComponent,
        title: 'Listado de roles',
      },
    ],
  },
  {
    path: 'cargo',
    children: [
      {
        path: 'create',
        component: CreateCargoViewComponent,
        title: 'Crear cargo',
      },
      {
        path: 'edit/:id',
        component: CreateCargoViewComponent,
        title: 'Editar cargo',
        data: {
          isEdit: true,
        },
      },
      {
        path: 'list',
        component: ListCargoViewComponent,
        title: 'Listado de cargos',
      },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ConfigViewRoutingModule {}
