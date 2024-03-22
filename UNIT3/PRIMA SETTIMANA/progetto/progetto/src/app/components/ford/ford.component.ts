import { Component } from '@angular/core';
import { Modules } from 'src/app/models/modules';

@Component({
  selector: 'app-ford',
  templateUrl: './ford.component.html',
  styleUrls: ['./ford.component.scss']
})
export class FordComponent {

  modules: Modules[] = [];
  modelsDisplayed: string[] = [];
  modelsSelected: Modules[] = [];
  logos: string[] = [];


  constructor() {
    this.getModules().then((_modules) => {
      this.modules = _modules;
      this.showingModel();
    });

  }


  async getModules() {
    let response = await fetch('assets/db.json');
    let answer = await response.json();
    let data = answer;
    data = data.filter((item: any) => item.brand === 'Ford');

    return data;
  }

  showingModel() {
    for (let i = 0; i < this.modules.length; i++) {
      let carModel = this.modules[i];

      if (carModel) {
        this.modelsDisplayed.push(carModel.model);
        this.modelsSelected.push(carModel);
        console.log(carModel);
      } else {
        console.error("carModel doesn't exist");
      }
    }
  }
}
