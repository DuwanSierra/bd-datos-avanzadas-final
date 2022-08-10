import { NgModule } from '@angular/core';
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
import { BrowserModule } from '@angular/platform-browser';
import { CustomConfirmDialogModule } from './components/custom-confirm-dialog/custom-confirm-dialog.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { CustomSpinnerModule } from './@core/spinner/custom-spinner.module';
import { CustomHttpInterceptor } from './@core/interceptor/custom-http.interceptor';
import { CalendarModule } from 'primeng/calendar';


@NgModule({
  declarations: [AppComponent, NavbarComponent],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
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
    CustomConfirmDialogModule,
    HttpClientModule,
    CustomSpinnerModule,
    CalendarModule,
    

  ],
  providers: [
    MessageService,
    TerminalService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: CustomHttpInterceptor,
      multi: true,
    },
  ],
  bootstrap: [AppComponent],
})
export class AppModule { }
