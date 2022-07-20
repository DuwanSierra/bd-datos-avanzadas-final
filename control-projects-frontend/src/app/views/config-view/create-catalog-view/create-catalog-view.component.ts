import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-create-catalog-view',
  templateUrl: './create-catalog-view.component.html',
  styleUrls: ['./create-catalog-view.component.scss']
})
export class CreateCatalogViewComponent implements OnInit {
  public title = "Crear área de interes"

  constructor() { }

  ngOnInit(): void {
  }

}
