import { Component, Input } from '@angular/core';
import { Products } from 'src/app/models/products';

@Component({
  selector: 'app-added-products',
  templateUrl: './added-products.component.html',
  styleUrls: ['./added-products.component.scss'],
})
export class AddedProductsComponent {
  totalSum: number = 0;

  @Input() cartProducts: Products[] = [];

  ngOnInit() {
    this.calculateTotalSum();
  }

  calculateTotalSum() {
    this.totalSum = this.cartProducts.reduce((total, product) => total + product.price ,0);
  }
}
