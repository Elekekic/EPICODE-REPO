import { Component } from '@angular/core';
import { News } from 'src/app/models/news';

@Component({
  selector: 'app-active-posts',
  templateUrl: './active-posts.component.html',
  styleUrls: ['./active-posts.component.scss']
})
export class ActivePostsComponent {

news!: News[];

  constructor() {
      this.getNews().then((_news) => {
          this.news = _news;
      });
  }

  async getNews() {
      let response = await fetch('assets/db.json');
      let data = await response.json();
      return data.filter((data:any) => data.active);
  }

  
}

  
