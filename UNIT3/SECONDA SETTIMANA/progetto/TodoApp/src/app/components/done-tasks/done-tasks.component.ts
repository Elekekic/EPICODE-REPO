import { Component } from '@angular/core';
import { TaskList } from 'src/app/models/task-list';
import { TaskListService } from 'src/app/service/task-list.service';

@Component({
  selector: 'app-done-tasks',
  templateUrl: './done-tasks.component.html',
  styleUrls: ['./done-tasks.component.scss']
})
export class DoneTasksComponent {
  tasks: TaskList[] = [];

  constructor(private taskSrv: TaskListService) {}

  ngOnInit() {
    this.getTasks();
  }

  getTasks() {
    this.tasks = this.taskSrv.getTasks().filter((items) => items.completed);
  }
}
