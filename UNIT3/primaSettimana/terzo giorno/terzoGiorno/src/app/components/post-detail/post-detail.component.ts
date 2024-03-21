import { Component, Input } from '@angular/core';
import { News } from 'src/app/models/news';

@Component({
  selector: 'app-post-detail',
  templateUrl: './post-detail.component.html',
  styleUrls: ['./post-detail.component.scss']
})

export class PostDetailComponent {
  news: News[] = [];
  idDisplayed: number[] = [];
  selectedPost: News[] = [];

  constructor() {
    this.getNews().then((_news) => {
      this.news = _news;
      this.randomiD();
    });
  }

  async getNews() {
    let response = await fetch('assets/db.json');
    let data = await response.json();

    return data;
  }

  randomiD() {
    for (let i = 0; i < 2; i++) {
      let index = Math.floor(Math.random() * this.news.length);
      let newsItem = this.news[index];

      if (newsItem) {
        while (newsItem && this.idDisplayed.includes(newsItem.id)) {
          index = Math.floor(Math.random() * this.news.length);
          newsItem = this.news[index];
        }

        this.idDisplayed.push(newsItem.id);
      } else {
        console.error("newsItem doesn't exist");
      }

      this.selectedPost.push(newsItem);
      console.log('selectedPost:', this.selectedPost);
    }
  }
}

