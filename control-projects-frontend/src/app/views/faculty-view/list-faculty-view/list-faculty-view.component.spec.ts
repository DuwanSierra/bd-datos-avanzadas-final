import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListFacultyViewComponent } from './list-faculty-view.component';

describe('ListFacultyViewComponent', () => {
  let component: ListFacultyViewComponent;
  let fixture: ComponentFixture<ListFacultyViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListFacultyViewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListFacultyViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
