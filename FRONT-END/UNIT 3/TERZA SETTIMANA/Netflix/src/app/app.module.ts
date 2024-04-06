// vari moduli e importazioni di cose che mi servono
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Route, RouterModule } from '@angular/router';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';



// componenti
import { AppComponent } from './app.component';
import { SignInComponent } from './auth/sign-in/sign-in.component';
import { SignUpComponent } from './auth/sign-up/sign-up.component';
import { HomeComponent } from './components/home/home.component';
import { MovieDetailComponent } from './components/movie-detail/movie-detail.component';
import { UtentsComponent } from './components/utents/utents.component';
import { ProfileComponent } from './components/profile/profile.component';
import { FavoritesComponent } from './components/favorites/favorites.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { authGuard } from './auth/auth.guard';
import { LandingPageComponent } from './components/landing-page/landing-page.component';


const routes: Route[] = [
  {
    path:'',
    component: LandingPageComponent
  },
  {
    path:'movies',
    component: HomeComponent,
    /* canActivate: [authGuard], */
     children: [
      {
          path: ':id',
          component: MovieDetailComponent,
         /*  canActivate: [authGuard], */
      },
  ]
},
  {
    path:'signin',
    component: SignInComponent
  },
  {
    path:'signup',
    component: SignUpComponent
  },
  {
    path:'favorites',
    component: FavoritesComponent,
    canActivate: [authGuard],
  },
  {
    path:'profile',
    component: ProfileComponent,
    canActivate: [authGuard],
  },
  {
    path:'utents',
    component: UtentsComponent,
    canActivate: [authGuard],
  },
]

@NgModule({
  declarations: [
    AppComponent,
    SignInComponent,
    SignUpComponent,
    HomeComponent,
    MovieDetailComponent,
    UtentsComponent,
    ProfileComponent,
    FavoritesComponent,
    NavbarComponent,
    LandingPageComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
    FormsModule,
    ReactiveFormsModule,
    NgbModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
