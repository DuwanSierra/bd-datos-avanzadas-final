import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-create-investigation-project-view',
  templateUrl: './create-investigation-project-view.component.html',
  styleUrls: ['./create-investigation-project-view.component.scss']
})
export class CreateInvestigationProjectViewComponent implements OnInit {

  title = 'Crear Proyecto de Investigación';
  phones = [
    {
      id: 0,
      value: '',
    },
  ];

  constructor() { }

  ngOnInit(): void {
  }

}
