import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomeComponent } from './components/home/home.component';

import { AppRoutingModule } from './app-routing.module';
import { FormModule } from './components/form/form.module';
import { EllipsisPipe } from './pipes/ellipsis.pipe';

import { ColorsDirective } from './directives/colors.directive';
import { LoginComponent } from './components/login/login.component';
import { TruePostsModule } from './components/true-posts/true-posts.module';
import { FalsePostsModule } from './components/false-posts/false-posts.module';
import { DetailsModule } from './components/details/details.module';
import { PostDetailsModule } from './components/post-detail/post-details.module';
import { TruePostsRotingModule } from './components/true-posts/true-posts-roting.module';
import { FalsePostsRoutingModule } from './components/false-posts/false-posts-routing.module';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    EllipsisPipe,
    ColorsDirective,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    FormsModule, 
    AppRoutingModule, 
    FormModule, TruePostsModule, FalsePostsModule, DetailsModule, PostDetailsModule, TruePostsRotingModule, FalsePostsRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
