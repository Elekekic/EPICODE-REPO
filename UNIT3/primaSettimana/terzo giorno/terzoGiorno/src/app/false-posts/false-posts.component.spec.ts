import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FalsePostsComponent } from './false-posts.component';

describe('FalsePostsComponent', () => {
  let component: FalsePostsComponent;
  let fixture: ComponentFixture<FalsePostsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FalsePostsComponent]
    });
    fixture = TestBed.createComponent(FalsePostsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
