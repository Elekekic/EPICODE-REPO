import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
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
  selectedPost!: News | null;

  constructor(
    private route: ActivatedRoute,
    private postSrv: NewsServiceService
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      // Mi ottengo l'ID dalla route attuale convertendolo in un numero usando il "+" davanti a params['id'].
      const Id = +params['id'];
      // Il risultato viene assegnato alla variabile this.news
      this.news = this.postSrv.getPost(Id); // Mi chiamo il metodo getPost(con il paramentro) del service
    });
  }

  changeNews(news: News) {
    // Letteralmente imposta la news selezionata nella variabile selectedPost
    this.selectedPost = news;
  }

  changeItems() {
    // mi serve per quando al click di 'salva', voglio che si chiudi la card per cambiare i dettagli
    this.selectedPost = null;
  }
}
