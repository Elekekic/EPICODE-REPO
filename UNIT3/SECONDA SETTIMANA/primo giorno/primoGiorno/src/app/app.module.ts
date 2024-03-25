import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { ActivePostsComponent } from './components/active-posts/active-posts.component';
import { InactivePostsComponent } from './components/inactive-posts/inactive-posts.component';
import { PostDetailComponent } from './components/post-detail/post-detail.component';
import { HomeComponent } from './components/home/home.component';
import { RouterModule, Routes } from '@angular/router';
import { TruePostsComponent } from './components/true-posts/true-posts.component';
import { FalsePostsComponent } from './components/false-posts/false-posts.component';
import { DetailsComponent } from './components/details/details.component';

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
    FalsePostsComponent,
    DetailsComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(route), 
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
