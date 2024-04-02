import { Component } from '@angular/core';
import {
  FormGroup,
  FormBuilder,
  Validators,
  FormControl,
} from '@angular/forms';
import { User } from '../interface/user';

@Component({
  selector: 'app-second-form',
  templateUrl: './second-form.component.html',
  styleUrls: ['./second-form.component.scss'],
})
export class SecondFormComponent {
  form!: FormGroup;
  genders = ['uomo', 'donna'];
  user!: User;

  constructor(private fb: FormBuilder) { }

  ngOnInit(): void {
    this.form = this.fb.group({
      userInfo: this.fb.group({
        email: this.fb.control(null, [
          Validators.required, 
          Validators.email]),
        avatar: this.fb.control(null, [
          Validators.required]),
        firstName: this.fb.control(null, [
          Validators.required,
          Validators.maxLength(10),
        ]),
        lastName: this.fb.control(null, [
          Validators.required,
          Validators.maxLength(10),
        ]),
        biography: this.fb.control(null, [Validators.required]),
        password: this.fb.control(null, [
          Validators.required,
          Validators.minLength(8),
        ]),
        confirmPassword: this.fb.control(null, [
          Validators.required,
          Validators.minLength(8),
        ]),
        gender: this.fb.control (null, [
          Validators.required
        ])
      }),
    });
  }

  submit() {
    this.user = this.form.value;
    console.log('Form sent', this.user);
    this.form.reset();
  }
}
