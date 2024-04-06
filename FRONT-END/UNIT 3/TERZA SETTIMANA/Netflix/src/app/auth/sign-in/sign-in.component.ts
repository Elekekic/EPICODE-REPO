import { Component } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.scss']
})
export class SignInComponent {
  constructor(private authSrv: AuthService, private router: Router) {}

  submit(form: NgForm) {
      console.log(form.value);
      this.authSrv.login(form.value).subscribe(
          () => {
              console.log('Sign in successful');
              alert ('Sign in successful! ')
              this.router.navigate(['/movies']);
          },
          (error) => {
              console.error('Error during sign in:', error);
          }
      );
    };
}
