import { Component, Input, Output,  EventEmitter} from '@angular/core';
import { News } from 'src/app/models/news';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.scss']
})
export class DetailsComponent {

  @Input() news!: News; // Lo uso per definire una proprietà di input del component 

  @Output() newItem = new EventEmitter<News>(); //Lo uso per definire un evento (newItem) che il componente può emettere verso l'esterno.

  addNewItem() {
    this.newItem.emit(this.news);
    // this.newItem = (dichiarato nel decoratore Output) rappresenta l'evento che può essere emesso dal component 
    // .emit() = (metodo EventEmitter) viene passato l'oggetto news, che contiene le informazioni sulla news che voglio comunicare attraverso newItem
    // qualsiasi componente esterno che abbia ascoltato l'evento newItem sarà in grado di ricevere e gestire l'oggetto news che è stato emesso
  }



}
