import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomMultipleInputTextComponent } from './custom-multiple-input-text.component';

describe('CustomMultipleInputTextComponent', () => {
  let component: CustomMultipleInputTextComponent;
  let fixture: ComponentFixture<CustomMultipleInputTextComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomMultipleInputTextComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CustomMultipleInputTextComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
