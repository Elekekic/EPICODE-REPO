import { Component } from '@angular/core';
import { News } from 'src/app/models/news';
import { NewsServiceService } from 'src/app/service/news-service.service';

@Component({
  selector: 'app-false-posts',
  templateUrl: './false-posts.component.html',
  styleUrls: ['./false-posts.component.scss']
})
export class FalsePostsComponent {
  news: News[] = [];
  idDisplayed: number[] = [];
  selectedPost: News[] = [];
  tags: string[] = [];
  selectedTag: string = '';

  constructor(private postSrv: NewsServiceService) {}

  async ngOnInit(): Promise<void> {
    // usato con la service per ottenre i dati 
    const posts = await this.postSrv.getNews();
    this.news = posts.filter((item) => !item.active);
    // chiamata per getTags 
    this.getTags(this.news); 
    // chiamata per filterTag 
    this.filterTag('');
}

  getTags(news: News[]) {
    // ciclo che itera su ogni oggetto post 
    news.forEach((post) => {
      // All'interno di ogni oggetto post, viene iterato su ogni elemento dell'array tags. 
      post.tags.forEach((tag) => {
        // viene verificato se l'array tags dell'oggetto corrente this include il tag corrente
        if (!this.tags.includes(tag)) {
          // Se non c'è, viene pushato nell'array tags
          this.tags.push(tag);
      }
      });
    });
    return this.tags;
  }


  filterTag(tag: string): void {
    // il paramentro tag diventa il valore di selectedTag 
    this.selectedTag = tag;
    if (tag === '') {
      // Se il tag fornito è vuoto, verranno restituiti tutti gli elementi dell'array news.
      this.selectedPost = this.news;
    } else {
      // Invece se il tag fornito c'è: 
      // filter: crea un nuovo array con tutti gli elementi di news
      // include: verifica se l'array tags di ciascun elemento item include il valore di tag.
      this.selectedPost = this.news.filter((item) => item.tags.includes(tag));
    }
  }
}
