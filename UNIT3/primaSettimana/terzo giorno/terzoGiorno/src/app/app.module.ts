import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { ActivePostsComponent } from './components/active-posts/active-posts.component';
import { InactivePostsComponent } from './components/inactive-posts/inactive-posts.component';
import { PostDetailComponent } from './components/post-detail/post-detail.component';
import { HomeComponent } from './components/home/home.component';
import { RouterModule, Routes } from '@angular/router';
import { TruePostsComponent } from './true-posts/true-posts.component';
import { FalsePostsComponent } from './false-posts/false-posts.component';

const route: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'true',
    component: TruePostsComponent
  },
  {
    path: 'false',
    component: FalsePostsComponent
  }, 
  {
    path: 'news/:id',
    component: PostDetailComponent
  }
]

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    ActivePostsComponent,
    InactivePostsComponent,
    PostDetailComponent,
    HomeComponent,
    TruePostsComponent,
    FalsePostsComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(route)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
