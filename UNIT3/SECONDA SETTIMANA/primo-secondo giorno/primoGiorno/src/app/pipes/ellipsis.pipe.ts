import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'ellipsis'
})
export class EllipsisPipe implements PipeTransform {

  //Semplice pipe che taglierà il testo e lo limita ai primi 80 caratteri 
  transform(value: string): string {
    return value.slice(0, 80) + '...';
  }
}
