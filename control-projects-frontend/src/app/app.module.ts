import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { CardModule } from 'primeng/card';
import { TabViewModule } from 'primeng/tabview';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { DockModule } from 'primeng/dock';
import { MenubarModule } from 'primeng/menubar';
import { DialogModule } from 'primeng/dialog';
import { ToastModule } from 'primeng/toast';
import { GalleriaModule } from 'primeng/galleria';
import { TerminalModule, TerminalService } from 'primeng/terminal';
import { TreeModule } from 'primeng/tree';
import { MessageService } from 'primeng/api';

@NgModule({
  declarations: [AppComponent, NavbarComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CardModule,
    DockModule,
    TabViewModule,
    MenubarModule,
    DialogModule,
    TerminalModule,
    TreeModule,
    ToastModule,
    GalleriaModule,
  ],
  providers: [
    MessageService,
    TerminalService
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
