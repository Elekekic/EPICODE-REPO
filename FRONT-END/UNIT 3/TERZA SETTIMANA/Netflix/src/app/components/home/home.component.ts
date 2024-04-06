import { Component, OnInit } from '@angular/core';
import { MoviesService } from 'src/app/service/movies.service';
import { Movies } from 'src/app/models/movies';


@Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.scss'],
})
export class HomeComponent implements OnInit {

    allMovies!: Movies[];

    constructor(private movieSrv: MoviesService) {}

    ngOnInit() {
        this.movieSrv.getMoviesPopular().subscribe(
            (movies) => {
                this.allMovies = movies;
                this.allMovies.forEach(movie => {
                    movie.poster_path = `https://image.tmdb.org/t/p/w500/${movie.poster_path}`;
                });
            },
            (error) => {
                console.error('Error fetching movies:', error);
            }
        );
    } 
    
    getIdMovie(id: number){
        return this.movieSrv.IdMoviesPopular(id);
 }}
