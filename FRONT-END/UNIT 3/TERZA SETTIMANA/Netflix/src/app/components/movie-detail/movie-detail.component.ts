import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MoviesService } from 'src/app/service/movies.service';
import { Movies } from 'src/app/models/movies';


@Component({
  selector: 'app-movie-detail',
  templateUrl: './movie-detail.component.html',
  styleUrls: ['./movie-detail.component.scss']
})
export class MovieDetailComponent implements OnInit {
  detailMovie!: Movies; 

  constructor(private movieSrv: MoviesService, private route: ActivatedRoute) {}

  ngOnInit():void {
    this.route.params.subscribe((params) => {
      const id = +params['id'];
      this.movieSrv.IdMoviesPopular(id).subscribe((data) => {
          this.detailMovie = data;
      });
  });
    
  }



}
