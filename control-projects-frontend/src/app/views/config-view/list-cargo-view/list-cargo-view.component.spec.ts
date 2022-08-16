import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListCargoViewComponent } from './list-cargo-view.component';

describe('ListCargoViewComponent', () => {
  let component: ListCargoViewComponent;
  let fixture: ComponentFixture<ListCargoViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListCargoViewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListCargoViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
