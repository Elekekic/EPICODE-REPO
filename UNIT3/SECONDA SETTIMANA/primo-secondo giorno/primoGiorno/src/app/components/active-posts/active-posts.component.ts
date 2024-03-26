import { Component, OnInit } from '@angular/core';
import { News } from 'src/app/models/news';
import { NewsServiceService } from 'src/app/service/news-service.service';

@Component({
  selector: 'app-active-posts',
  templateUrl: './active-posts.component.html',
  styleUrls: ['./active-posts.component.scss'],
})
export class ActivePostsComponent implements OnInit {
  news: News[] = [];
  idDisplayed: number[] = [];
  selectedPost: News[] = [];

  constructor(private postSrv: NewsServiceService) {}

  async ngOnInit(): Promise<void> {
    console.log('ngOnInit attivato');
    const news = await this.postSrv.getNews();
    this.news = news;
    this.randomiD(); 
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
