import { Component, OnInit } from '@angular/core';
import { ServiceService } from 'src/app/service/service.service';
import { Products, CartItem } from 'src/app/models/products';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss'],
})
export class ProductsComponent implements OnInit {
  products: Products[] = [];
  cartProducts: Products[] = [];
  favorites: Products[] = [];

  existingProduct: any


  constructor(private productsSrv: ServiceService) {}

  ngOnInit(): void {
    this.productsSrv.getProducts().subscribe(response => {
      this.products = response.products;
    });
  }

  addToCart(id: number) {
    const product = this.products.find(product => product.id === id);
    if (product) {
      this.productsSrv.ClickAddCart(id); // Chiamata a ClickAdd
      this.cartProducts.push(product); // Aggiungi direttamente il prodotto al carrello
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
