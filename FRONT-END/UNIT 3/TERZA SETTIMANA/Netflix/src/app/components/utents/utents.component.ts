import { Component, OnInit } from '@angular/core';
import { UtentsService } from 'src/app/service/utents.service';
import { User } from 'src/app/models/user';


@Component({
  selector: 'app-utents',
  templateUrl: './utents.component.html',
  styleUrls: ['./utents.component.scss']
})
export class UtentsComponent implements OnInit {

  utents!: User[];

  constructor (private utentSrv: UtentsService) {}

  ngOnInit() {
    this.utentSrv.getUsers().subscribe((utents) => {
      this.utents = utents;
      console.log(this.utents)
    });
  }

}

