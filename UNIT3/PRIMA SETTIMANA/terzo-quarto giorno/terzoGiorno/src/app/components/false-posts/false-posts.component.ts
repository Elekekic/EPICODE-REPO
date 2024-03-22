import { Component } from '@angular/core';
import { News } from 'src/app/models/news';

@Component({
  selector: 'app-false-posts',
  templateUrl: './false-posts.component.html',
  styleUrls: ['./false-posts.component.scss']
})
export class FalsePostsComponent {
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
    let answer = await response.json();
    let data = answer; 
    data = data.filter((item: any) => item.active); 

    return data; 
  }

  randomiD() {
    for (let i = 0; i < this.news.length; i++) {
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
