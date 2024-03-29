import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UndoneTasksComponent } from './undone-tasks.component';

describe('UndoneTasksComponent', () => {
  let component: UndoneTasksComponent;
  let fixture: ComponentFixture<UndoneTasksComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UndoneTasksComponent]
    });
    fixture = TestBed.createComponent(UndoneTasksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
