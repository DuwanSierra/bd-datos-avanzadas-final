import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/api';
import { BehaviorSubject, map, Subscription, timer } from 'rxjs';
import { MenuService } from 'src/app/services/menu.service';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {
    
    currentDate = new Date();

    displayFullDock: boolean = false;

    dockItems:  BehaviorSubject<MenuItem[]> = new BehaviorSubject<MenuItem[]>([]);

    menubarItems: BehaviorSubject<MenuItem[]> = new BehaviorSubject<MenuItem[]>([]);

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
        this.menubarItems = this.menuService.menuItems;
        this.dockItems = this.menuService.menuDockItems;
    }

    onFocusInEvent(event: Event){
        this.displayFullDock = true;
    }

    onFocusOutEvent(event: Event){
        this.displayFullDock = false;
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
