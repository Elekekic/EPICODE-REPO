import { Component, OnInit } from '@angular/core';
import { AuthorizationService } from 'src/app/authorization.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit{
  user = localStorage.getItem('user');
    logged!: boolean;

    constructor(private authSrv: AuthorizationService, private router: Router) {}

  ngOnInit(): void {
    this.logged = this.authSrv.isLoggedIn;
  }

  checkUser() { 
    return localStorage.getItem('user');
}

onLogout(): void {
    localStorage.removeItem('user');
    this.user = null;
    this.logged = this.authSrv.logout();
    if (!this.logged) {
        this.router.navigate(['/']);
    }
}



}
