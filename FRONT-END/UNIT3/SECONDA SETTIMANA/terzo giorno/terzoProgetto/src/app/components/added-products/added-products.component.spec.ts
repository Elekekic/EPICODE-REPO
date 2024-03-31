import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddedProductsComponent } from './added-products.component';

describe('AddedProductsComponent', () => {
  let component: AddedProductsComponent;
  let fixture: ComponentFixture<AddedProductsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AddedProductsComponent]
    });
    fixture = TestBed.createComponent(AddedProductsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
