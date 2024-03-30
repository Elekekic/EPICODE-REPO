import { Component } from '@angular/core';
import { TaskList } from 'src/app/models/task-list';
import { UserList } from 'src/app/models/user-list';
import { UserListService } from 'src/app/service/user-list.service';
import { TaskListService } from 'src/app/service/task-list.service';

@Component({
  selector: 'app-undone-tasks',
  templateUrl: './undone-tasks.component.html',
  styleUrls: ['./undone-tasks.component.scss']
})
export class UndoneTasksComponent {
  tasks: TaskList[] = [];
  users: UserList[] = [];
  userTasks: { user: UserList; tasks: TaskList[] }[] = [];

  constructor(private taskSrv: TaskListService, private userSrv: UserListService) {}

  ngOnInit() {
    this.getTasks();
    this.getUsers(); 
    this.getCards(); 
  }

  getTasks() {
    this.tasks = this.taskSrv.getTasks().filter((items) => !items.completed);
  }

   
  getUsers() {
    this.users = this.userSrv.getUsers();
  }

  getCards() {
    this.userTasks = [];
    this.users.forEach((user) => {
      const userTasks = this.tasks.filter((task) => task.userId === user.id);
      this.userTasks.push({ user, tasks: userTasks });
    });
  } 

}
