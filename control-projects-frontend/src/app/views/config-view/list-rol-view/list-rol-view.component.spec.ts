import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListRolViewComponent } from './list-rol-view.component';

describe('ListRolViewComponent', () => {
  let component: ListRolViewComponent;
  let fixture: ComponentFixture<ListRolViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListRolViewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListRolViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
