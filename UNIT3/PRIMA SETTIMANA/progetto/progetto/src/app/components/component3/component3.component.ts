import { Component } from '@angular/core';
import { Modules } from 'src/app/models/modules';

@Component({
  selector: 'app-component3',
  templateUrl: './component3.component.html',
  styleUrls: ['./component3.component.scss'],
})
export class Component3Component {
  modules: Modules[] = [];
  modelsDisplayed: string[] = [];
  modelsSelected: Modules[] = [];

  constructor() {
    this.getModules().then((_modules) => {
      this.modules = _modules;
      this.randomModel(); 
    });

  }

  async getModules() {
    let response = await fetch('assets/db.json');
    let answer = await response.json();
    let data = answer;

    return data;
  }


  randomModel() {
    for (let i = 0; i < 4; i++) {
      let index = Math.floor(Math.random() * this.modules.length);
      let carModel = this.modules[index];

      if (carModel) {
        while (carModel && this.modelsDisplayed.includes(carModel.model)) {
          index = Math.floor(Math.random() * this.modules.length);
          carModel = this.modules[index];
        }

        if (carModel) {
          this.modelsDisplayed.push(carModel.model);
          this.modelsSelected.push(carModel); 
          console.log(carModel)
        } else {
          console.error("carModel doesn't exist");
        }
      }
    }
  }
}
