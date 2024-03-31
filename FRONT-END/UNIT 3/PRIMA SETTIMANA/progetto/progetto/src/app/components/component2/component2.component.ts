import { Component } from '@angular/core';
import { Modules } from 'src/app/models/modules';

@Component({
  selector: 'app-component2',
  templateUrl: './component2.component.html',
  styleUrls: ['./component2.component.scss']
})
export class Component2Component {

  takingAudiLogo!: Modules; 
  takingFordLogo!: Modules;
  takingFiatLogo!: Modules;

  modules: Modules[] = [];


  constructor() {
    this.getModules().then(data => {
      data.forEach((module: any) => {
        if(module.brand === "Fiat") {
          this.takingFiatLogo = module.brandLogo; 
        } else if (module.brand === "Ford") {
          this.takingFordLogo = module.brandLogo; 
        } else if (module.brand === "Audi" ) {
          this.takingAudiLogo = module.brandLogo; 
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
