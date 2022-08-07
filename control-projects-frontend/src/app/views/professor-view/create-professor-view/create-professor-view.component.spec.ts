import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateProfessorViewComponent } from './create-professor-view.component';

describe('CreateProfessorViewComponent', () => {
  let component: CreateProfessorViewComponent;
  let fixture: ComponentFixture<CreateProfessorViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateProfessorViewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateProfessorViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
