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
        label: 'Cátalogos',
        items: [
          {
            label: 'Crear área de interés',
            icon: 'pi pi-fw pi-cog',
            id: 'create-catalog',
            command: () => {
              this.router.navigateByUrl("config/area/create");
            },
          },
          {
            label: 'Listado de áreas de interés',
            icon: 'pi pi-fw pi-list',
            id: 'list-catalog',
            command: () => {
              this.router.navigateByUrl("config/area/list");
            },
          },
          {
            separator: true,
          },
          {
            label: 'Crear sede',
            icon: 'pi pi-fw pi-building',
            id: 'create-catalog',
            command: () => {
              this.router.navigateByUrl("config/sede/create");
            },
          },
          {
            label: 'Listado de sedes',
            icon: 'pi pi-fw pi-list',
            id: 'list-catalog',
            command: () => {
              this.router.navigateByUrl("config/sede/list");
            },
          },
          {
            separator: true,
          },
          {
            label: 'Crear Rol',
            icon: 'pi pi-user-plus',
            id: 'create-rol',
            command: () => {
              this.router.navigateByUrl("config/rol/create");
            },
          },
          {
            label: 'Listado de Roles',
            icon: 'pi pi-users',
            id: 'list-rol',
            command: () => {
              this.router.navigateByUrl("config/rol/list");
            },
          },
          {
            separator: true,
          },
          {
            label: 'Crear Cargo',
            icon: 'pi pi-id-card',
            id: 'create-rol',
            command: () => {
              this.router.navigateByUrl("config/cargo/create");
            },
          },
          {
            label: 'Listado de Cargos',
            icon: 'pi pi-fw pi-list',
            id: 'list-rol',
            command: () => {
              this.router.navigateByUrl("config/cargo/list");
            },
          },
        ],
      },
      {
        label: 'Facultades',
        items: [
          {
            label: 'Registrar facultad',
            icon: 'pi pi-fw pi-building',
            id: 'faculty-create',
            command: () => {
              this.router.navigateByUrl("faculty/create");
            },
          },
          {
            separator: true,
          },
          {
            label: 'Listado de facultades',
            icon: 'pi pi-fw pi-list',
            id: 'faculty-list',
            command: () => {
              this.router.navigateByUrl("faculty/list");
            },
          },
        ],
      },
      {
        label: 'Profesores',
        items: [
          {
            label: 'Registrar profesor',
            icon: 'pi pi-fw pi-user',
            id: 'professor-create',
            command: () => {
              this.router.navigateByUrl("professor/create");
            }
          },
          {
            separator: true,
          },
          {
            label: 'Listado de profesores',
            icon: 'pi pi-fw pi-users',
            id: 'professor-list',
            command: () => {
              this.router.navigateByUrl("professor/list");
            },
          },
        ],
      },
      {
        label: 'Grupos de investigación',
        items: [
          {
            label: 'Registrar grupo de investigacion',
            icon: 'pi pi-fw pi-book',
            id: 'investigation-group-create',
            command: () => {
              this.router.navigateByUrl("investigation-group/create");
            }
          },
          {
            separator: true,
          },
          {
            label: 'Listado de grupos de investigacion',
            icon: 'pi pi-fw pi-book',
            id: 'professor-list',
            command: () => {
              this.router.navigateByUrl("investigation-group/list");
            }
          },
        ],
      },
      {
        label: 'Proyectos de investigación',
        items: [
          {
          label: 'Proyectos de investigación',
            icon: 'pi pi pi-fw pi-list',
            id: 'investigation-project-create',
            command: () => {
              this.router.navigateByUrl("investigation-project/create");
            }
          },
          {
            separator: true,
          },
          {
            label: 'Listado de proyectos de investigacion',
            icon: 'pi pi-fw pi-list',
            id: 'investigation-project-list',
            command: () => {
              this.router.navigateByUrl("investigation-project/list");
            }
          },
        ],
      },
      {
        label: 'Reportes',
        items: [
          {
            label: 'Reportes general',
            icon: 'pi pi-fw pi-list',
            id: 'reports',
            command: () => {
              this.router.navigateByUrl("report/general");
            }

          }
        ],
      },
    ];
    this.menuItems.next(menubarItems);
  }

  generateDockMenus() {
    let dockItems = [
      {
        label: 'Áreas de interés',
        tooltipOptions: {
          tooltipLabel: 'Áreas de interés',
          tooltipPosition: 'top',
          positionTop: -15,
          positionLeft: 15,
          showDelay: 200,
        },
        icon: 'assets/images/social.png',
        command: () => {
          this.router.navigateByUrl("config");
        },
      },
      {
        label: 'Sedes',
        tooltipOptions: {
          tooltipLabel: 'Sedes',
          tooltipPosition: 'top',
          positionTop: -15,
          positionLeft: 15,
          showDelay: 200,
        },
        icon: 'assets/images/sede.png',
        command: () => {
          this.router.navigateByUrl("config/sede/list");
        },
      },
      {
        label: 'Roles',
        tooltipOptions: {
          tooltipLabel: 'Roles',
          tooltipPosition: 'top',
          positionTop: -15,
          positionLeft: 15,
          showDelay: 200,
        },
        icon: 'assets/images/roles.png',
        command: () => {
          this.router.navigateByUrl("config/rol/list");
        },
      },
      {
        label: 'Cargos',
        tooltipOptions: {
          tooltipLabel: 'Cargos',
          tooltipPosition: 'top',
          positionTop: -15,
          positionLeft: 15,
          showDelay: 200,
        },
        icon: 'assets/images/cargos.png',
        command: () => {
          this.router.navigateByUrl("config/cargo/list");
        },
      },
      {
        label: 'Facultades',
        tooltipOptions: {
          tooltipLabel: 'Facultades',
          tooltipPosition: 'top',
          positionTop: -15,
          positionLeft: 15,
          showDelay: 200,
        },
        icon: 'assets/images/faculty.png',
        command: () => {
          this.router.navigateByUrl("faculty/list");
        },
      },
      {
        label: 'Profesores',
        tooltipOptions: {
          tooltipLabel: 'Profesores',
          tooltipPosition: 'top',
          positionTop: -15,
          positionLeft: 15,
          showDelay: 200,
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
          showDelay: 200,
        },
        icon: 'assets/images/group-investigation.png',
        command: () => {
          console.log('investigation');
        },
      },
      {
        label: 'Proyectos de investigación',
        tooltipOptions: {
          tooltipLabel: 'Proyectos de investigación',
          tooltipPosition: 'top',
          positionTop: -15,
          positionLeft: 15,
          showDelay: 200,
        },
        icon: 'assets/images/management.png',
        command: () => {
          console.log('projects');
        },
      },
      {
        label: 'Reportes',
        tooltipOptions: {
          tooltipLabel: 'Reportes',
          tooltipPosition: 'top',
          positionTop: -15,
          positionLeft: 15,
          showDelay: 200,
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
