import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/api';
import { map, Subscription, timer } from 'rxjs';
import { MenuService } from 'src/app/services/menu.service';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {
    
    currentDate = new Date();

    displayTerminal: boolean = false;

    displayFinder: boolean= false;

    displayGalleria: boolean= false;

    dockBasicItems: MenuItem[] = [];

    dockItems: MenuItem[] = [];

    menubarItems: any[] = [];

    responsiveOptions: any[] = [];

    images: any[] = [];

    nodes: any[] = [];

    subscription: Subscription = new Subscription();

    subscriptionMenu: Subscription = new Subscription();

    time = new Date();
    
    intervalId: any;

    constructor(
        public menuService: MenuService
      ) { }

    ngOnInit() {
        this.getMenus();
        this.dockBasicItems = [
            {
                label: 'Finder',
                icon: "assets/images/finder.svg"
            },
            {
                label: 'App Store',
                icon: "assets/images/appstore.svg"
            },
            {
                label: 'Photos',
                icon: "assets/images/photos.svg"
            },
            {
                label: 'Trash',
                icon: "assets/images/trash.png"
            }
        ];

        this.dockItems = [
            {
                label: 'Finder',
                tooltipOptions: {
                    tooltipLabel: "Finder",
                    tooltipPosition: 'top',
                    positionTop: -15,
                    positionLeft: 15,
                    showDelay: 1000
                },
                icon: "assets/images/finder.svg",
                command: () => {
                    this.displayFinder = true;
                }
            },
            {
                label: 'Terminal',
                tooltipOptions: {
                    tooltipLabel: "Terminal",
                    tooltipPosition: 'top',
                    positionTop: -15,
                    positionLeft: 15,
                    showDelay: 1000
                },
                icon: "assets/images/terminal.svg",
                command: () => {
                    this.displayTerminal = true;
                }
            },
            {
                label: 'App Store',
                tooltipOptions: {
                    tooltipLabel: "App Store",
                    tooltipPosition: 'top',
                    positionTop: -15,
                    positionLeft: 15,
                    showDelay: 1000
                },
                icon: "assets/images/appstore.svg",
                command: () => {
                    console.log('App Store');
                }
            },
            {
                label: 'Safari',
                tooltipOptions: {
                    tooltipLabel: "Safari",
                    tooltipPosition: 'top',
                    positionTop: -15,
                    positionLeft: 15,
                    showDelay: 1000
                },
                icon: "assets/images/safari.svg",
                command: () => {
                  console.log('Safari');
                }
            },
            {
                label: 'Photos',
                tooltipOptions: {
                    tooltipLabel: "Photos",
                    tooltipPosition: 'top',
                    positionTop: -15,
                    positionLeft: 15,
                    showDelay: 1000
                },
                icon: "assets/images/photos.svg",
                command: () => {
                  console.log('Photos');
                }
            },
            {
                label: 'GitHub',
                tooltipOptions: {
                    tooltipLabel: "GitHub",
                    tooltipPosition: 'top',
                    positionTop: -15,
                    positionLeft: 15,
                    showDelay: 1000
                },
                icon: "assets/images/github.svg",
            },
            {
                label: 'Trash',
                tooltipOptions: {
                    tooltipLabel: "Trash",
                    tooltipPosition: 'top',
                    positionTop: -15,
                    positionLeft: 15,
                    showDelay: 1000
                },
                icon: "assets/images/trash.png",
                command: () => {
                  console.log('Trash');
                }
            }
        ];

        this.menubarItems = [
            
            {
                label: 'File',
                items: [
                    {
                        label: 'New',
                        icon: 'pi pi-fw pi-plus',
                        items: [
                            {
                                label: 'Bookmark',
                                icon: 'pi pi-fw pi-bookmark'
                            },
                            {
                                label: 'Video',
                                icon: 'pi pi-fw pi-video'
                            },

                        ]
                    },
                    {
                        label: 'Delete',
                        icon: 'pi pi-fw pi-trash'
                    },
                    {
                        separator: true
                    },
                    {
                        label: 'Export',
                        icon: 'pi pi-fw pi-external-link'
                    }
                ]
            },
            {
                label: 'Edit',
                items: [
                    {
                        label: 'Left',
                        icon: 'pi pi-fw pi-align-left'
                    },
                    {
                        label: 'Right',
                        icon: 'pi pi-fw pi-align-right'
                    },
                    {
                        label: 'Center',
                        icon: 'pi pi-fw pi-align-center'
                    },
                    {
                        label: 'Justify',
                        icon: 'pi pi-fw pi-align-justify'
                    },

                ]
            },
            {
                label: 'Users',
                items: [
                    {
                        label: 'New',
                        icon: 'pi pi-fw pi-user-plus',

                    },
                    {
                        label: 'Delete',
                        icon: 'pi pi-fw pi-user-minus',

                    },
                    {
                        label: 'Search',
                        icon: 'pi pi-fw pi-users',
                        items: [
                            {
                                label: 'Filter',
                                icon: 'pi pi-fw pi-filter',
                                items: [
                                    {
                                        label: 'Print',
                                        icon: 'pi pi-fw pi-print'
                                    }
                                ]
                            },
                            {
                                icon: 'pi pi-fw pi-bars',
                                label: 'List'
                            }
                        ]
                    }
                ]
            },
            {
                label: 'Events',
                items: [
                    {
                        label: 'Edit',
                        icon: 'pi pi-fw pi-pencil',
                        items: [
                            {
                                label: 'Save',
                                icon: 'pi pi-fw pi-calendar-plus'
                            },
                            {
                                label: 'Delete',
                                icon: 'pi pi-fw pi-calendar-minus'
                            }
                        ]
                    },
                    {
                        label: 'Archieve',
                        icon: 'pi pi-fw pi-calendar-times',
                        items: [
                            {
                                label: 'Remove',
                                icon: 'pi pi-fw pi-calendar-minus'
                            }
                        ]
                    }
                ]
            },
            {
                label: 'Quit'
            }
        ];

        this.responsiveOptions = [
            {
                breakpoint: '1024px',
                numVisible: 3
            },
            {
                breakpoint: '768px',
                numVisible: 2
            },
            {
                breakpoint: '560px',
                numVisible: 1
            }
        ];
        this.createActualDate();
    }

    createActualDate(){
        this.intervalId = setInterval(() => {
            this.time = new Date();
          }, 1000);
    }

    getMenus(){
        this.menuService.menuItems.subscribe({
            next: (manuItems) => this.setCurrentMenu(manuItems),
        })
    }

    setCurrentMenu(menuItems: MenuItem[]){
        this.menubarItems = menuItems;
    }

    commandHandler(text: string) {
        let response;
        let argsIndex = text.indexOf(' ');
        let command = argsIndex !== -1 ? text.substring(0, argsIndex) : text;

        switch (command) {
            case 'date':
                response = 'Today is ' + new Date().toDateString();
            break;

            case 'greet':
                response = 'Hola ' + text.substring(argsIndex + 1) + '!';
            break;

            case 'random':
                response = Math.floor(Math.random() * 100);
            break;

            default:
                response = 'Unknown command: ' + command;
            break;
        }
        console.log('Execute', text);
    }

    ngOnDestroy() {
        if (this.subscription) {
            this.subscription.unsubscribe();
        }
        if(this.subscriptionMenu){
            this.subscriptionMenu.unsubscribe();
        }
    }

}
