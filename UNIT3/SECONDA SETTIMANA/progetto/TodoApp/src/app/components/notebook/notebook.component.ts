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
  searching: string = '';

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

  filterTasks() {
    if (!this.searching.trim()) {
      // se l'input è vuoto, stampa tutte le tasks
      this.getCards();
      return;
    }

    this.userTasks = [];
    this.users.forEach((user) => {
      // Filtra le tasks per firstname e lastname
      const filteredTasks = this.tasks.filter(
        (task) =>
          task.userId === user.id &&
          (user.firstName
            .toLowerCase()
            .includes(this.searching.toLowerCase()) ||
            user.lastName.toLowerCase().includes(this.searching.toLowerCase()))
      );
      if (filteredTasks.length > 0) {
        this.userTasks.push({ user, tasks: filteredTasks });
      }
    });
  }
}
