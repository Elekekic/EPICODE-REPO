import { Component } from '@angular/core';
import { News } from 'src/app/models/news';

@Component({
  selector: 'app-inactive-posts',
  templateUrl: './inactive-posts.component.html',
  styleUrls: ['./inactive-posts.component.scss']
})
export class InactivePostsComponent {
  isloaded = false; 
  news: News[] = [];
  idDisplayed: number[] = [];
  selectedInactivePost: News[] = [];

  constructor() {
    this.getNews().then((_news) => {
      this.news = _news;
      this.randomiD();
    });
  }

  async getNews() {
    let response = await fetch('assets/db.json');
    let answer = await response.json();
    let data = answer.filter((item: any) => !item.active);

    return data; 
  }

  randomiD() {
    for (let i = 0; i < 4; i++) {
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

      this.selectedInactivePost.push(newsItem);
      console.log('selectedPost:', this.selectedInactivePost); 
      this.isloaded = true; 
    }
  }
}

