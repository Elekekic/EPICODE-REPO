import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/auth/auth.service';
import { Auth } from 'src/app/models/auth';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {

  loggedUser!: Auth | null; 

  constructor (private authSrv: AuthService) {}


  ngOnInit(): void {
    this.loggedUser = this.authSrv.getCurrentUser(); 
  }


}
