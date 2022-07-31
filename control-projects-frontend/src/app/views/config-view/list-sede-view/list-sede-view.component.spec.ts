import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListSedeViewComponent } from './list-sede-view.component';

describe('ListSedeViewComponent', () => {
  let component: ListSedeViewComponent;
  let fixture: ComponentFixture<ListSedeViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListSedeViewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListSedeViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
