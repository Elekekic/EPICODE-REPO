import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { News } from 'src/app/models/news';

@Component({
  selector: 'app-post-detail',
  templateUrl: './post-detail.component.html',
  styleUrls: ['./post-detail.component.scss'],
})
export class PostDetailComponent implements OnInit {
  testId!: number;
  news!: News;
  private sub!: Subscription;
  selectedPost!: News | null;

  constructor(private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.sub = this.route.params.subscribe((params) => {
      this.testId = params['id'];
      console.log(params);
      this.getNews().then((news) => {
        this.news = news;
      });
    });
  }

  async getNews() {
    console.log(this.testId);
    let response = await fetch(`http://localhost:3000/posts/${this.testId}`);
    console.log(response);
    let answer = await response.json();
    console.log(answer);
    let data = answer;

    return data;
  }

  changeNews(news: News) {
    this.selectedPost = news;
  }

  changeItems() {
    this.selectedPost = null; 
  }
}
