import { Component, Input } from '@angular/core';
import { Products, CartItem } from 'src/app/models/products';

@Component({
  selector: 'app-added-products',
  templateUrl: './added-products.component.html',
  styleUrls: ['./added-products.component.scss'],
})
export class AddedProductsComponent {
  totalSum: number = 0;
  existingProduct: any

  @Input() cartProducts: Products[] = [];

  


}
