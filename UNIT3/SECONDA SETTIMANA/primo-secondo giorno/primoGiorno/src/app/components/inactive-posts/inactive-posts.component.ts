import { Component } from '@angular/core';
import { News } from 'src/app/models/news';
import { NewsServiceService } from 'src/app/service/news-service.service';


@Component({
  selector: 'app-inactive-posts',
  templateUrl: './inactive-posts.component.html',
  styleUrls: ['./inactive-posts.component.scss']
})
export class InactivePostsComponent {
  news: News[] = [];
  idDisplayed: number[] = [];
  selectedInactivePost: News[] = [];

  constructor(private postSrv: NewsServiceService) {}

  async ngOnInit(): Promise<void> {
    const posts = await this.postSrv.getNews();
    this.news = posts;
    this.randomiD();
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
    }
  }
}

