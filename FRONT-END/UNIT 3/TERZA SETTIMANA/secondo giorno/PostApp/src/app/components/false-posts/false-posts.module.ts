import { RouterModule, Routes } from '@angular/router';
import { CommonModule } from '@angular/common';
import { TruePostsComponent } from '../true-posts/true-posts.component';
import { NgModule } from '@angular/core';

const routes: Routes = [
  {
      path: '',
      component: TruePostsComponent
  }
];


@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})

export class FalsePostsModule { }
