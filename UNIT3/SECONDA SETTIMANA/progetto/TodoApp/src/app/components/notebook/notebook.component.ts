import { Component, OnInit } from '@angular/core';
import { TaskList } from 'src/app/models/task-list';
import { UserList } from 'src/app/models/user-list';
import { TaskListService } from 'src/app/service/task-list.service';
import { UserListService } from 'src/app/service/user-list.service';

@Component({
  selector: 'app-notebook',
  templateUrl: './notebook.component.html',
  styleUrls: ['./notebook.component.scss']
})
export class NotebookComponent implements OnInit {
  tasks: TaskList[] = [];
  users: UserList[] = [];
  userTasks: { user: UserList, tasks: TaskList[] }[] = [];

  constructor(private taskSrv: TaskListService, private userSrv: UserListService) {}

  ngOnInit() {
    this.getTasks();
    this.getUsers();
    this.getCards();
  }
  
  getTasks() {
    this.tasks = this.taskSrv.getTasks();
  }

  getUsers() {
    this.users = this.userSrv.getUsers();
  }

  getCards() {
    this.userTasks = [];
    this.users.forEach(user => {
      const userTasks = this.tasks.filter(task => task.userId === user.id);
        this.userTasks.push({ user, tasks: userTasks });
    });
  }
}
