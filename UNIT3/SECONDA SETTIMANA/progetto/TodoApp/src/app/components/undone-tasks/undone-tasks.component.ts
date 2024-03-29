import { Component } from '@angular/core';
import { TaskList } from 'src/app/models/task-list';
import { TaskListService } from 'src/app/service/task-list.service';

@Component({
  selector: 'app-undone-tasks',
  templateUrl: './undone-tasks.component.html',
  styleUrls: ['./undone-tasks.component.scss']
})
export class UndoneTasksComponent {
  tasks: TaskList[] = [];

  constructor(private taskSrv: TaskListService) {}

  ngOnInit() {
    this.getTasks();
  }

  getTasks() {
    this.tasks = this.taskSrv.getTasks().filter((items) => !items.completed);
  }
}
