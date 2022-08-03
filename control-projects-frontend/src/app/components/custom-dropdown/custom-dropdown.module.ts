import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CustomDropdownComponent } from './custom-dropdown.component';
import { DropdownModule } from 'primeng/dropdown';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SkeletonModule } from 'primeng/skeleton';

@NgModule({
  declarations: [CustomDropdownComponent],
  imports: [
    CommonModule,
    DropdownModule,
    ReactiveFormsModule,
    FormsModule,
    SkeletonModule,
  ],
  exports: [CustomDropdownComponent],
})
export class CustomDropdownModule {}
