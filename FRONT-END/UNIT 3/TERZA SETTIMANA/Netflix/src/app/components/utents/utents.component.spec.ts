import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UtentsComponent } from './utents.component';

describe('UtentsComponent', () => {
  let component: UtentsComponent;
  let fixture: ComponentFixture<UtentsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UtentsComponent]
    });
    fixture = TestBed.createComponent(UtentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
