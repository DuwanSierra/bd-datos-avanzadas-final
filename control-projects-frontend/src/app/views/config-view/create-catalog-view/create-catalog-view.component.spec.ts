import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateCatalogViewComponent } from './create-catalog-view.component';

describe('CreateCatalogViewComponent', () => {
  let component: CreateCatalogViewComponent;
  let fixture: ComponentFixture<CreateCatalogViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateCatalogViewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateCatalogViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
