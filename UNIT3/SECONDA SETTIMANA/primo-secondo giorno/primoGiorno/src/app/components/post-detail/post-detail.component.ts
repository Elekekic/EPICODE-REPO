import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { News } from 'src/app/models/news';
import { NewsServiceService } from 'src/app/service/news-service.service';

@Component({
  selector: 'app-post-detail',
  templateUrl: './post-detail.component.html',
  styleUrls: ['./post-detail.component.scss'],
})
export class PostDetailComponent implements OnInit {
  testId!: number;
  news!: News | undefined;
  private sub!: Subscription;
  selectedPost!: News | null;

  constructor(
    private route: ActivatedRoute,
    private postSrv: NewsServiceService
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      const Id = +params['id'];
      this.news = this.postSrv.getPost(Id);
    });
  }

  changeNews(news: News) {
    this.selectedPost = news;
  }

  changeItems() {
    this.selectedPost = null;
  }
}
