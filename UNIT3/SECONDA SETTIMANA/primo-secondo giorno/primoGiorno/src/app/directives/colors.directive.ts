import { Directive, ElementRef, Renderer2 } from '@angular/core';

@Directive({
  selector: '[appColors]'
})
export class ColorsDirective {

  constructor(private target: ElementRef, private render: Renderer2) {
    this.render.setStyle(this.target.nativeElement, 'backgroundColor', this.randomColor());
   }

   randomColor() {
    return '#' + Math.floor(Math.random() * 16777215).toString(16);
  }



}
