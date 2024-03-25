import { Component } from '@angular/core';
import { News } from 'src/app/models/news';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})

export class HomeComponent {
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
    let response = await fetch('http://localhost:3000/posts');
    let data = await response.json();

    return data;
  }

  randomiD() {
    for (let i = 0; i < 1; i++) {
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
