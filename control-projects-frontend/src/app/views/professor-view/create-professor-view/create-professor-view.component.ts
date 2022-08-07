import { Component, OnInit } from '@angular/core';
import { GenericView } from 'src/app/utils/generic-view';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-create-professor-view',
  templateUrl: './create-professor-view.component.html',
  styleUrls: ['./create-professor-view.component.scss']
})
export class CreateProfessorViewComponent implements OnInit {

  title = 'Crear profesor';
  phones = [
    {
      id: 0,
      value: '',
    },
  ];




  constructor( ){
    
   }

  ngOnInit(): void {
  }

}
