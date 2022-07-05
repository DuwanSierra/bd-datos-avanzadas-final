import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListCatalogViewComponent } from './list-catalog-view.component';

describe('ListCatalogViewComponent', () => {
  let component: ListCatalogViewComponent;
  let fixture: ComponentFixture<ListCatalogViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListCatalogViewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListCatalogViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
