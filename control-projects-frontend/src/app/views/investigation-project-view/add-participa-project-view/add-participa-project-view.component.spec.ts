import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddParticipaProjectViewComponent } from './add-participa-project-view.component';

describe('AddParticipaProjectViewComponent', () => {
  let component: AddParticipaProjectViewComponent;
  let fixture: ComponentFixture<AddParticipaProjectViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddParticipaProjectViewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddParticipaProjectViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
