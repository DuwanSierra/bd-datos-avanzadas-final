import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { WindowComponent } from './window.component';
import { CardModule } from 'primeng/card';

@NgModule({
  declarations: [WindowComponent],
  imports: [CommonModule, CardModule],
  exports: [WindowComponent],
})
export class WindowModule {}
