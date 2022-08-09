import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListInvestigationProjectViewComponent } from './list-investigation-project-view.component';

describe('ListInvestigationProjectViewComponent', () => {
  let component: ListInvestigationProjectViewComponent;
  let fixture: ComponentFixture<ListInvestigationProjectViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListInvestigationProjectViewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListInvestigationProjectViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
