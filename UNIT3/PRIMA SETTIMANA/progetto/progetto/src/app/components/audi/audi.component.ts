import { Component } from '@angular/core';
import { Modules } from 'src/app/models/modules';

@Component({
  selector: 'app-audi',
  templateUrl: './audi.component.html',
  styleUrls: ['./audi.component.scss']
})
export class AudiComponent {

  audiLogo!: Modules; 
  modules: Modules[] = [];
  modelsDisplayed: string[] = [];
  modelsSelected: Modules[] = [];


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
    data = data.filter((item: any) => item.brand === 'Audi'); 

    if (data.length > 0) {
      this.audiLogo = data[0].brandLogo;
    } 

    return data;
  }

  showingModel() {
    for (let i = 0; i < this.modules.length; i++) {
      let carModel = this.modules[i];

      if (carModel) {
        this.modelsDisplayed.push(carModel.model);
        this.modelsSelected.push(carModel);
      } else {
        console.error("carModel doesn't exist");
      }
    }
  }
}
