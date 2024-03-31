import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TruePostsComponent } from './true-posts.component';

describe('TruePostsComponent', () => {
  let component: TruePostsComponent;
  let fixture: ComponentFixture<TruePostsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TruePostsComponent]
    });
    fixture = TestBed.createComponent(TruePostsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
