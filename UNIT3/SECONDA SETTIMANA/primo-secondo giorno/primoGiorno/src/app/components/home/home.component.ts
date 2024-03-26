import { Component, OnInit } from '@angular/core';
import { News } from 'src/app/models/news';
import { NewsServiceService } from 'src/app/service/news-service.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})

export class HomeComponent implements OnInit {
  news: News[] = [];
  idDisplayed: number[] = [];
  selectedPost: News[] = [];

  constructor(private postSrv: NewsServiceService) {}

  async ngOnInit(): Promise<void> {
    console.log('ngOnInit attivato');
    const posts = await this.postSrv.getNews();
    this.news = posts;
    this.randomiD(); 
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
