import { Component, InputDecorator, OnInit } from '@angular/core';
import { ServiceService } from 'src/app/service/service.service';
import { Products } from 'src/app/models/products';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss'],
})
export class ProductsComponent implements OnInit {
  products: Products[] = [];
  sub!: Subscription;
  cartProducts: Products[] = [];
  favorites: Products[] = [];


  constructor(private productsSrv: ServiceService) {}

  ngOnInit(): void {
    this.infoProducts();
  }

  infoProducts() {
    this.sub = this.productsSrv.getProducts().subscribe((products) => {
      this.products = products.products;
    });
  }

  ClickAdd(id: number) {
    const product = this.products.find((product) => product.id === id);
    if (product) {
      this.cartProducts.push(product);
      console.log(this.cartProducts); 
    }
  }

  addToFavorites(id: number) {
    const favs = this.products.find((product) => product.id === id);
    if (favs) {
      this.favorites.push(favs);
      console.log(this.favorites); 
    }
  }

}
