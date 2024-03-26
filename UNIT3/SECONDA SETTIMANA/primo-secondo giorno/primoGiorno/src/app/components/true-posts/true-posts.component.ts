import { Component } from '@angular/core';
import { News } from 'src/app/models/news';
import { NewsServiceService } from 'src/app/service/news-service.service';

@Component({
  selector: 'app-true-posts',
  templateUrl: './true-posts.component.html',
  styleUrls: ['./true-posts.component.scss'],
})
export class TruePostsComponent {
  news: News[] = [];
  idDisplayed: number[] = [];
  selectedPost: News[] = [];
  tags: string[] = [];
  selectedTag: string = '';

  constructor(private postSrv: NewsServiceService) {}

  async ngOnInit(): Promise<void> {
    const news = await this.postSrv.getNews();
    this.news = news;
    this.randomiD();
    this.getTags(news);
    this.filterByTag('');
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
    }
  }

  getTags(news: News[]) {
    news.forEach((post) => {
      post.tags.forEach((tag) => {
        if (!this.tags.includes(tag)) {
          this.tags.push(tag);
        }
      });
    });
    console.log(this.tags);
    return this.tags;
  }

  filterByTag(tag: string): void {
    this.selectedTag = tag;
    if (tag === '') {
      this.selectedPost = this.news;
    } else {
      this.selectedPost = this.news.filter((item) => item.tags.includes(tag));
    }
  }
}
