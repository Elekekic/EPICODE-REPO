import { Component } from '@angular/core';
import { News } from 'src/app/models/news';

@Component({
  selector: 'app-inactive-posts',
  templateUrl: './inactive-posts.component.html',
  styleUrls: ['./inactive-posts.component.scss']
})
export class InactivePostsComponent {
  news!: News[];

  constructor() {
      this.getNews().then((_news) => {
          this.news = _news;
      });
  }

  async getNews() {
      let response = await fetch('assets/db.json');
      let data = await response.json();
      return data.filter((data:any) => !data.active);
  }
}
