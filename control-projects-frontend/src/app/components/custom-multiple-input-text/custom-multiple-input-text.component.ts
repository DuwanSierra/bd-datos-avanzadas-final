import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'custom-multiple-input-text',
  templateUrl: './custom-multiple-input-text.component.html',
  styleUrls: ['./custom-multiple-input-text.component.scss']
})
export class CustomMultipleInputTextComponent implements OnInit {

  items = [''];
  constructor() { }

  ngOnInit(): void {
  }

}
