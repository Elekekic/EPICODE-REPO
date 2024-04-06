import { Injectable } from '@angular/core';
import { Movies } from '../models/movies';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class MoviesService {

 APIURL = environment.apiURL; 

  constructor(private http: HttpClient) { }

  getMoviesPopular(){
    return this.http.get<Movies[]> (`${this.APIURL}movies-popular`)
  }

  getMoviesTopRated() {
    return this.http.get<Movies[]> (`${this.APIURL}movies-toprated`)
  }

  IdMoviesPopular(id: number) {
    return this.http.get<Movies> (`${this.APIURL}movies-popular/${id}`)
  }

  IdMoviesTopRated(id: number) {
    return this.http.get<Movies> (`${this.APIURL}movies-toprated/${id}`)
  }
}
