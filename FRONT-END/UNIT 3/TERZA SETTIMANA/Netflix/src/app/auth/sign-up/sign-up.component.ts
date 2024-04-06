import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
    selector: 'app-sign-up',
    templateUrl: './sign-up.component.html',
    styleUrls: ['./sign-up.component.scss'],
})
export class SignUpComponent {
 constructor(private authSrv: AuthService, private router: Router) {}

submit(form: NgForm) {
    console.log(form.value);
    this.authSrv.signup(form.value).subscribe(
        () => {
            console.log('Sign up successful');
            alert ('Sign up successful! ')
            this.router.navigate(['/signin']);
        },
        (error) => {
            console.error('Error during sign up:', error);
        }
    );
  };
}; 
