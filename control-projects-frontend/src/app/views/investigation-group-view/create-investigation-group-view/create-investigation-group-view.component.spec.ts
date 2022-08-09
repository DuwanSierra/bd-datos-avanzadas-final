import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateInvestigationGroupViewComponent } from './create-investigation-group-view.component';

describe('CreateInvestigationGroupViewComponent', () => {
  let component: CreateInvestigationGroupViewComponent;
  let fixture: ComponentFixture<CreateInvestigationGroupViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateInvestigationGroupViewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateInvestigationGroupViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
