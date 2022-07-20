import { Component, Input, OnInit } from '@angular/core';
import { Utils } from 'src/app/utils/utils';

@Component({
  selector: 'input-text-form',
  templateUrl: './input-text-form.component.html',
  styleUrls: ['./input-text-form.component.scss'],
})
export class InputTextFormComponent implements OnInit {
  public id: string = Utils.generateUUID();
  @Input() hint?: string;
  @Input() label?: string;
  @Input() type?: string = 'text';
  constructor() {}

  ngOnInit(): void {}
}
