import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FacultyRequest } from 'src/app/managers/request-dto/faculty.request';
import { SedeManagerService } from 'src/app/managers/sede-manager/sede-manager.service';
import { GenericView } from 'src/app/utils/generic-view';

@Component({
  selector: 'app-create-faculty-view',
  templateUrl: './create-faculty-view.component.html',
  styleUrls: ['./create-faculty-view.component.scss'],
})
export class CreateFacultyViewComponent extends GenericView implements OnInit {
  title = 'Crear facultad';
  faculty: FacultyRequest = new FacultyRequest(); 

  constructor(public override activatedRoute: ActivatedRoute, public sedeManager: SedeManagerService) {
    super(activatedRoute);
  }

  ngOnInit(): void {}

  saveEvent(isValid: boolean) {
    if (isValid) {
      this.isEdit;
    }
  }
}
