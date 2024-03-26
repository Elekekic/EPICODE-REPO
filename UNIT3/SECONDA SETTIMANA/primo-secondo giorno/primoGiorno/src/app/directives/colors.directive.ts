import { Directive, ElementRef, Renderer2 } from '@angular/core';

@Directive({
  selector: '[appColors]'
})
export class ColorsDirective {
  // render2 perché in teoria dovrebbe essere più veloce
  constructor(private target: ElementRef, private render: Renderer2) {
    this.render.setStyle(this.target.nativeElement, 'backgroundColor', this.randomColor());
   }

   // per mettere un colore a caso come background color
   randomColor() {
    return '#' + Math.floor(Math.random() * 16777215).toString(16);
  }



}
