import { Component, OnInit } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { CustomSpinnerService } from './custom-spinner.service';

@Component({
  selector: 'custom-spinner',
  templateUrl: './custom-spinner.component.html',
  styleUrls: ['./custom-spinner.component.scss'],
})
export class CustomSpinnerComponent implements OnInit {
  public paintSpinner = new BehaviorSubject<boolean>(false);

  constructor(private spinnerService: CustomSpinnerService) {}

  ngOnInit(): void {
    this.getStatusSpinner();
  }

  getStatusSpinner(){
    this.paintSpinner = this.spinnerService.getStatusPaintSpinner();
  }
}
