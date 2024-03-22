import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { FooterComponent } from './components/footer/footer.component';
import { Component1Component } from './components/component1/component1.component';
import { Component2Component } from './components/component2/component2.component';
import { Component3Component } from './components/component3/component3.component';
import { AudiComponent } from './components/audi/audi.component';
import { FordComponent } from './components/ford/ford.component';
import { FiatComponent } from './components/fiat/fiat.component';

const route: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'Audi',
    component: AudiComponent
  },
  {
    path: 'Ford',
    component: FordComponent
  },
  {
    path: 'Fiat',
    component: FiatComponent
  }
  /* {
    path: '**',
    component: errore 404 
  } */
]


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavbarComponent,
    FooterComponent,
    Component1Component,
    Component2Component,
    Component3Component,
    AudiComponent,
    FordComponent,
    FiatComponent
  ],
  imports: [
    BrowserModule, 
    RouterModule.forRoot(route)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
