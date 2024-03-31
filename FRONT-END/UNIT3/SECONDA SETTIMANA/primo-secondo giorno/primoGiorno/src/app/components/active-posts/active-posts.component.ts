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
    // usato con la service per ottenre i dati 
    const posts = await this.postSrv.getNews();
    this.news = posts;
    //chiamata per randomId
    this.randomiD(); 
}

  randomiD() {
    for (let i = 0; i < 2; i++) {
      // Genero un indice casuale
      let index = Math.floor(Math.random() * this.news.length);
      //  Ottengo la news corrispondente all'indice generato casualmente
      let newsItem = this.news[index];

      // SE newsItem esiste: 
      if (newsItem) {
        // Controllami se la notizia è già stata visualizzata
        while (newsItem && this.idDisplayed.includes(newsItem.id)) {
           // Se la notizia è stata già visualizzata, generami un nuovo indice casuale e seleziona una nuova notizia
          index = Math.floor(Math.random() * this.news.length);
          // ottenendo un'altra news
          newsItem = this.news[index];
        }
        // Aggiungi l'ID della notizia corrente all'elenco delle notizie già visualizzate
        this.idDisplayed.push(newsItem.id);
      }
      // se non è stata visualizzata, aggiungimela nel selectedPost
      this.selectedPost.push(newsItem);
    }
  }
}
