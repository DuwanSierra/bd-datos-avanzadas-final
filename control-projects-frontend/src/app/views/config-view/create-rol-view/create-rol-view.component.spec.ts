import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateRolViewComponent } from './create-rol-view.component';

describe('CreateRolViewComponent', () => {
  let component: CreateRolViewComponent;
  let fixture: ComponentFixture<CreateRolViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateRolViewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateRolViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
