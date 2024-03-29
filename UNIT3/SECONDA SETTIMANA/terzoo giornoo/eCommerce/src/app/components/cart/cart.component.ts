import { Component } from '@angular/core';
import { Input } from '@angular/core';
import { Products } from 'src/app/models/products';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class CartComponent {

  @Input() products: Products[] = [];

}
