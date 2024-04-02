import { Component, ViewChild } from '@angular/core';
import { User } from '../interface/user';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-first-form',
  templateUrl: './first-form.component.html',
  styleUrls: ['./first-form.component.scss'],
})
export class FirstFormComponent {
  user: User = {
    firstName: '',
    lastName: '',
    email: '',
    avatar: '', 
    biography: '',
    gender: [
      {
        label: 'uomo',
        value: 'uomo',
      },
      {
        label: 'donna',
        value: 'donna',
      },
    ],
    password: '',
    confirmPassword: '',
  };

  @ViewChild('form', { static: true }) form!: NgForm;

  ngOnInit(): void {
    this.form.statusChanges?.subscribe((status) => {
      console.log('Stato del form: ', status);
    });
  }

  submit() {
    console.log(this.form.value);

    this.user.firstName = this.form.value.firstName;
    this.user.lastName = this.form.value.lastName;
    this.user.email = this.form.value.email;
    this.user.avatar = this.form.value.avatar; 
    this.user.gender = this.form.value.gender;
    this.user.password = this.form.value.password;
    this.user.confirmPassword = this.form.value.confirmPassword;

    this.form.reset();
  }
}
