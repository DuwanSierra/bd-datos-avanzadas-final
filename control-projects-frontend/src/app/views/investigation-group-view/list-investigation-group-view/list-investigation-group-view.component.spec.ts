import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListInvestigationGroupViewComponent } from './list-investigation-group-view.component';

describe('ListInvestigationGroupViewComponent', () => {
  let component: ListInvestigationGroupViewComponent;
  let fixture: ComponentFixture<ListInvestigationGroupViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListInvestigationGroupViewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListInvestigationGroupViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
