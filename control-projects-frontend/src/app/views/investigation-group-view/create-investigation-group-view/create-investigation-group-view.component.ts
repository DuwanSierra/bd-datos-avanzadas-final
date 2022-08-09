import { Component, OnInit } from '@angular/core';
import { GenericView } from 'src/app/utils/generic-view';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-create-investigation-group-view',
  templateUrl: './create-investigation-group-view.component.html',
  styleUrls: ['./create-investigation-group-view.component.scss']
})
export class CreateInvestigationGroupViewComponent implements OnInit {

  title = 'Crear Grupo de Investigación';
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

