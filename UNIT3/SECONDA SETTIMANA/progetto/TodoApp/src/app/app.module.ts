import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { HeaderComponent } from './components/header/header.component';
import { AllTasksComponent } from './components/all-tasks/all-tasks.component';
import { UndoneTasksComponent } from './components/undone-tasks/undone-tasks.component';
import { DoneTasksComponent } from './components/done-tasks/done-tasks.component';
import { NotebookComponent } from './components/notebook/notebook.component';


const routes: Routes = [
  {
    path:"",
    component: HomeComponent
  },
  {
    path:"seeAll",
    component: AllTasksComponent
  },
  {
    path:"doneTasks",
    component: DoneTasksComponent
  },
  {
    path:"undoneTasks",
    component: UndoneTasksComponent
  },
  {
    path:"notebook",
    component: NotebookComponent
  }

]

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    AllTasksComponent,
    UndoneTasksComponent,
    DoneTasksComponent,
    NotebookComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
