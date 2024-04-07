import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.development';
import { HttpClient } from '@angular/common/http';
import { Favorites } from 'src/app/models/favorites';

@Injectable({
    providedIn: 'root',
})
export class FavoritesService {
    APIURL = environment.apiURL;

    constructor(private http: HttpClient) {}

    getFavorites() {
        return this.http.get<Favorites[]>(`${this.APIURL}favorites`);
    }

    addFavorites(data: Favorites) {
        return this.http.post<Favorites[]>(`${this.APIURL}favorites`, data, {
            headers: {
                'Content-Type': 'application/json',
            },
        });
    }

    deleteFavorites(Id: number) {
      return this.http.delete(`${this.APIURL}favorites/${Id}`);
    }
}
