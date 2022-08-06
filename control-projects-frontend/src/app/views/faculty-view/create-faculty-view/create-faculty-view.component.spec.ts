import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateFacultyViewComponent } from './create-faculty-view.component';

describe('CreateFacultyViewComponent', () => {
  let component: CreateFacultyViewComponent;
  let fixture: ComponentFixture<CreateFacultyViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateFacultyViewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateFacultyViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
