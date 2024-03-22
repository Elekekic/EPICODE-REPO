import { Component } from '@angular/core';
import { Modules } from 'src/app/models/modules';

@Component({
  selector: 'app-component2',
  templateUrl: './component2.component.html',
  styleUrls: ['./component2.component.scss']
})
export class Component2Component {

  modules: Modules[] = [];
  logos: string[] = [];


  constructor() {
    this.getModules().then(data => {
      let addedLogos: string[] = [];
  
      data.forEach((module: any) => {
        if ((module.brand === "Fiat" || module.brand === "Ford" || module.brand === "Audi") && !addedLogos.includes(module.brandLogo)) {
          addedLogos.push(module.brandLogo);
        } else {
          this.logos.push(module.brandLogo);
        }
      });
    });
  }

  async getModules() {
    let response = await fetch('assets/db.json');
    let answer = await response.json();
    let data = answer;  

    return data; 
  }

}
