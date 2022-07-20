import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { WindowComponent } from './window.component';
import { CardModule } from 'primeng/card';
import { ButtonModule } from 'primeng/button';

@NgModule({
  declarations: [WindowComponent],
  imports: [CommonModule, CardModule, ButtonModule],
  exports: [WindowComponent],
})
export class WindowModule {}
