import { Component, OnInit } from '@angular/core';
import { MoviesService } from 'src/app/service/movies.service';
import { Movies } from 'src/app/models/movies';
import { Favorites } from 'src/app/models/favorites';
import { AuthService } from 'src/app/auth/auth.service';
import { FavoritesService } from 'src/app/service/favorites.service';
import { Auth } from 'src/app/models/auth';

@Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.scss'],
})
export class HomeComponent implements OnInit {
    allMovies!: Movies[];
    dataToAddToFavorites!: Favorites;
    user!: Auth | null; 
    heartIcon: boolean = false;

    constructor(
        private movieSrv: MoviesService,
        private authService: AuthService,
        private favoritesService: FavoritesService
    ) {}

    ngOnInit() {
        this.authService.user$.subscribe((user) => {
            this.user = user});
        this.movieSrv.getMoviesPopular().subscribe(
            (movies) => {
                this.allMovies = movies;
                this.allMovies.forEach((movie) => {
                    movie.poster_path = `https://image.tmdb.org/t/p/w500/${movie.poster_path}`;
                });
            },
            (error) => {
                console.error('Error fetching movies:', error);
            }
        );
    }

    getIdMovie(id: number) {
        return this.movieSrv.IdMoviesPopular(id);
    }


    addToFavorites(movie: Movies) {
        const currentUser = this.authService.getCurrentUser();
        if (currentUser) {
            const favorite: Favorites = {
                userId: currentUser.user.id,
                movieId: movie.id,
                movie_overview: movie.overview,
                movie_poster_path: movie.poster_path,
                movie_vote_average: movie.vote_average,
                movie_backdrop_path: movie.backdrop_path,
                movie_original_title: movie.original_title,
                id: movie.id
            };
            this.favoritesService.addFavorites(favorite).subscribe(
                (response) => {
                    console.log('added to favorites:', response);
                },
                (error) => {
                    console.error('Error:', error);
                }
            );
        }
    }
      
}
