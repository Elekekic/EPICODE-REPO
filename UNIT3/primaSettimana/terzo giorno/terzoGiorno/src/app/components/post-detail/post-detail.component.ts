import { Component } from '@angular/core';
import { News } from 'src/app/models/news';

@Component({
  selector: 'app-post-detail',
  templateUrl: './post-detail.component.html',
  styleUrls: ['./post-detail.component.scss'],
})
export class PostDetailComponent {
  news: News[] = [];

  constructor() {
    this.getNews().then((_news) => {
      this.news = _news;
      this.detailedPost();
    });
  }

  async getNews() {
    let response = await fetch('assets/db.json');
    let data = await response.json();

    return data;
  }

  detailedPost() {

    

  }
}
