import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CustomSpinnerService {
  private paintSpinner = new BehaviorSubject<boolean>(false);

  constructor() {}

  openSpinner() {
    this.paintSpinner.next(true);
  }

  closeSpinner() {
    this.paintSpinner.next(false);
  }

  getStatusPaintSpinner(): BehaviorSubject<boolean> {
    return this.paintSpinner;
  }
}
