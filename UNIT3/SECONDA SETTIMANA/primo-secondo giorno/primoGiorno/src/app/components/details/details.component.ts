import { Component, Input, Output,  EventEmitter} from '@angular/core';
import { News } from 'src/app/models/news';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.scss']
})
export class DetailsComponent {

  @Input() news!: News; 

  @Output() newItem = new EventEmitter<News>();

  addNewItem() {
    this.newItem.emit(this.news);
  }



}
