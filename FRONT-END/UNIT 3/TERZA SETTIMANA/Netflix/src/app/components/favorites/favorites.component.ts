import { Component, OnInit } from '@angular/core';
import { FavoritesService } from 'src/app/service/favorites.service';
import { Favorites } from 'src/app/models/favorites';
import { Auth } from 'src/app/models/auth';
import { AuthService } from 'src/app/auth/auth.service';

@Component({
  selector: 'app-favorites',
  templateUrl: './favorites.component.html',
  styleUrls: ['./favorites.component.scss'],
})
export class FavoritesComponent implements OnInit {
  allFavs: Favorites[] = [];
  currentUser!: Auth | null; 

  constructor(private favoritesService: FavoritesService, private authSrv: AuthService) {}

  ngOnInit() {
    this.currentUser = this.authSrv.getCurrentUser();
    if (this.currentUser) {
      this.favoritesService.getFavorites().subscribe(
        (favs: Favorites[]) => {
          this.allFavs = favs.filter(fav => fav.userId === this.currentUser?.user.id);
          this.allFavs.forEach((movie) => {
            movie.movie_backdrop_path = `https://image.tmdb.org/t/p/w500/${movie.movie_backdrop_path}`;
          });
          console.log(this.allFavs);
        },
      );
    }
  }

  deleteFavorite(movieId: number): void {
    const index = this.allFavs.findIndex(fav => fav.movieId === movieId);
    if (index !== -1) {
      this.allFavs.splice(index, 1);
    }
  }


}
