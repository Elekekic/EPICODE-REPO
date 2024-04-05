import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
  },
  {
    path: 'true-posts',
    loadChildren: () =>
      import('./components/true-posts/true-posts.module').then(
        (m) => m.TruePostsModule
      ),
  },
  {
    path: 'false-posts',
    loadChildren: () =>
      import('./components/false-posts/false-posts.module').then(
        (m) => m.FalsePostsModule
      ),
  },
  {
    path: 'details',
    loadChildren: () =>
      import('./components/details/details.module').then(
        (m) => m.DetailsModule
      ),
  },
  {
    path: 'post-details',
    loadChildren: () =>
      import('./components/post-detail/post-details.module').then(
        (m) => m.PostDetailsModule
      ),
  },
  {
    path: 'login',
    component: LoginComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes), FormsModule],
  exports: [RouterModule],
})
export class AppRoutingModule {}
