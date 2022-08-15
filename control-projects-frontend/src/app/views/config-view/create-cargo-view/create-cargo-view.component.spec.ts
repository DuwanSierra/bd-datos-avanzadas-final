import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateCargoViewComponent } from './create-cargo-view.component';

describe('CreateCargoViewComponent', () => {
  let component: CreateCargoViewComponent;
  let fixture: ComponentFixture<CreateCargoViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateCargoViewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateCargoViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
