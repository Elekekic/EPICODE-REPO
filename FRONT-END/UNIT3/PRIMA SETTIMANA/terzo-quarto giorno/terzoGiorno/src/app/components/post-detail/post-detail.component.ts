import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { News } from 'src/app/models/news';

@Component({
  selector: 'app-post-detail',
  templateUrl: './post-detail.component.html',
  styleUrls: ['./post-detail.component.scss'],
})
export class PostDetailComponent implements OnInit {
  testId!: string;
  news!: News;
  dataNews = []

  constructor(private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      this.testId = params['id'];
    });
  }

  async getNews() {
    let response = await fetch('assets/db.json');
    let answer = await response.json();
    let data = answer;

    return data
  }
}
