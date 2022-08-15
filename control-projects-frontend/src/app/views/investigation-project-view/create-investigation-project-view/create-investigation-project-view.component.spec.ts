import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateInvestigationProjectViewComponent } from './create-investigation-project-view.component';

describe('CreateInvestigationProjectViewComponent', () => {
  let component: CreateInvestigationProjectViewComponent;
  let fixture: ComponentFixture<CreateInvestigationProjectViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateInvestigationProjectViewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateInvestigationProjectViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
