import { Component, OnInit } from '@angular/core';
import { TaskList } from 'src/app/models/task-list';
import { TaskListService } from 'src/app/service/task-list.service';

@Component({
  selector: 'app-all-tasks',
  templateUrl: './all-tasks.component.html',
  styleUrls: ['./all-tasks.component.scss']
})
export class AllTasksComponent implements OnInit {
  tasks: TaskList[] = [];

  constructor(private taskSrv: TaskListService) {}

  ngOnInit() {
    this.getTasks();
  }

  getTasks() {
    this.tasks = this.taskSrv.getTasks();
  }
}
