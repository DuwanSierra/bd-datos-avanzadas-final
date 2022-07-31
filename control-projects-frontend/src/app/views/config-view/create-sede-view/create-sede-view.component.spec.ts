import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateSedeViewComponent } from './create-sede-view.component';

describe('CreateSedeViewComponent', () => {
  let component: CreateSedeViewComponent;
  let fixture: ComponentFixture<CreateSedeViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateSedeViewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateSedeViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
