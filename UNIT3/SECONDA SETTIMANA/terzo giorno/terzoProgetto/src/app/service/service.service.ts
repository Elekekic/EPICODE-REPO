import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Products } from '../models/products';
import { Subject, throwError } from 'rxjs';
import { Observable } from 'rxjs';



@Injectable({
  providedIn: 'root'
})
export class ServiceService {
  apiURL = 'https://dummyjson.com/products'; 


  constructor(private http: HttpClient) { }


  getProducts() {
    return this.http.get<{ products: Products[]}>(this.apiURL);
  }
}
