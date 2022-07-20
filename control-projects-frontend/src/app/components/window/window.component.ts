import { Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';

@Component({
  selector: 'window-template',
  templateUrl: './window.component.html',
  styleUrls: ['./window.component.scss'],
})
export class WindowComponent implements OnInit {

  @Input() title?: string;
  @Input() showActions = false;

  constructor() {}

  ngOnInit(): void {}
}
