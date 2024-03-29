import { Component, OnInit } from '@angular/core';
import { TaskList } from 'src/app/models/task-list';
import { UserList } from 'src/app/models/user-list';
import { TaskListService } from 'src/app/service/task-list.service';
import { UserListService } from 'src/app/service/user-list.service';

@Component({
  selector: 'app-all-tasks',
  templateUrl: './all-tasks.component.html',
  styleUrls: ['./all-tasks.component.scss'],
})
export class AllTasksComponent implements OnInit {
  tasks: TaskList[] = [];
  searchQuery: string = '';

  constructor(private taskSrv: TaskListService, private userSrv: UserListService) {}

  ngOnInit() {
    this.getTasks();
  }

  getTasks() {
    this.tasks = this.taskSrv.getTasks();
  }

  searchUser() {
   // if query == '' then return me array tasks
   // if query == user.firstName then return me all the tasks.id of user.id
  }
}
