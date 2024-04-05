import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthorizationService } from 'src/app/authorization.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  loginForm!: NgForm;
  username!: string;
  password!: string;
  logged!: boolean;

  constructor(private router: Router, private authSrv: AuthorizationService) {}

  onSubmit(form: NgForm) {
      console.log(form.value);
      localStorage.setItem('user', JSON.stringify(form.value));
      this.logged = this.authSrv.login();
      if (this.logged) {
          this.router.navigate(['/']);
      }
  }
}
