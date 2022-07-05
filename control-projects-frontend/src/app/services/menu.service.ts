import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { MenuItem } from 'primeng/api';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class MenuService {
  public menuItems = new BehaviorSubject<MenuItem[]>([]);
  public menuDockItems = new BehaviorSubject<MenuItem[]>([]);

  constructor(private router: Router) {
    this.generateMenus();
    this.generateDockMenus();
  }

  generateMenus() {
    let menubarItems = [
      {
        label: 'Configuración',
        items: [
          {
            label: 'Crear Catálogos',
            icon: 'pi pi-fw pi-cog',
            id: 'create-catalog',
          },
          {
            separator: true,
          },
          {
            label: 'Listado de catálogos',
            icon: 'pi pi-fw pi-list',
            id: 'list-catalog',
          },
        ],
      },
      {
        label: 'Facultades',
        items: [
          {
            label: 'Registrar facultad',
            icon: 'pi pi-fw pi-building',
          },
          {
            separator: true,
          },
          {
            label: 'Listado de facultades',
            icon: 'pi pi-fw pi-list',
          },
        ],
      },
      {
        label: 'Profesores',
        items: [
          {
            label: 'Registrar profesor',
            icon: 'pi pi-fw pi-user',
          },
          {
            separator: true,
          },
          {
            label: 'Listado de profesores',
            icon: 'pi pi-fw pi-users',
          },
        ],
      },
      {
        label: 'Grupos de investigación',
        items: [
          {
            label: 'Registrar grupo',
            icon: 'pi pi-fw pi-book',
          },
          {
            separator: true,
          },
          {
            label: 'Listado de grupos',
            icon: 'pi pi-fw pi-list',
          },
        ],
      },
      {
        label: 'Reportes',
        items: [
          {
            label: 'Proyectos por profesor',
            icon: 'pi pi-fw pi-list',
          },
          {
            separator: true,
          },
          {
            label: 'Proyectos activos, y terminados',
            icon: 'pi pi-fw pi-list',
          },
          {
            separator: true,
          },
          {
            label: 'Profesores con sus proyectos de investigación',
            icon: 'pi pi-fw pi-list',
          },
          {
            separator: true,
          },
          {
            label: 'Presupuesto por facultad',
            icon: 'pi pi-fw pi-list',
          },
        ],
      },
    ];
    this.menuItems.next(menubarItems);
  }

  generateDockMenus() {
    let dockItems = [
      {
        label: 'Catálogos',
        tooltipOptions: {
          tooltipLabel: 'Catálogos',
          tooltipPosition: 'top',
          positionTop: -15,
          positionLeft: 15,
          showDelay: 1000,
        },
        icon: 'assets/images/settings.png',
        command: () => {
          this.router.navigateByUrl("config");
        },
      },
      {
        label: 'Facultades',
        tooltipOptions: {
          tooltipLabel: 'Facultades',
          tooltipPosition: 'top',
          positionTop: -15,
          positionLeft: 15,
          showDelay: 1000,
        },
        icon: 'assets/images/faculty.png',
        command: () => {
          console.log('navigate to faculty');
        },
      },
      {
        label: 'Profesores',
        tooltipOptions: {
          tooltipLabel: 'Profesores',
          tooltipPosition: 'top',
          positionTop: -15,
          positionLeft: 15,
          showDelay: 1000,
        },
        icon: 'assets/images/professor.png',
        command: () => {
          console.log('navigate to professor');
        },
      },
      {
        label: 'Grupos de investigación',
        tooltipOptions: {
          tooltipLabel: 'Grupos de investigación',
          tooltipPosition: 'top',
          positionTop: -15,
          positionLeft: 15,
          showDelay: 1000,
        },
        icon: 'assets/images/group-investigation.png',
        command: () => {
          console.log('investigation');
        },
      },
      {
        label: 'Reportes',
        tooltipOptions: {
          tooltipLabel: 'Reportes',
          tooltipPosition: 'top',
          positionTop: -15,
          positionLeft: 15,
          showDelay: 1000,
        },
        icon: 'assets/images/reports.png',
        command: () => {
          console.log('reports');
        },
      },
    ];
    this.menuDockItems.next(dockItems);
  }
}
