import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.development';
import { HttpClient } from '@angular/common/http';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class UtentsService {

  constructor(private http: HttpClient) { }

  APIURL = environment.apiURL; 

  getUsers(){
    return this.http.get<User[]> (`${this.APIURL}users`)
  }


  
}
