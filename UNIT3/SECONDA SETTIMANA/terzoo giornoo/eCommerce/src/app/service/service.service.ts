import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Products, CartItem } from '../models/products';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})

export class ServiceService {
  apiURL = 'https://dummyjson.com/products';
  products: CartItem[] = [];
  cartProducts: CartItem[] = [];
  favProducts: Products[] = [];
  myCart = new BehaviorSubject<Products[]>([]);

  constructor(private http: HttpClient) {}

  getProducts() {
    return this.http.get<{ products: Products[] }>(this.apiURL);
  }

  clickAddCart(id: number) {
    const product = this.products.find((product) => product.id === id);
    if (product) {
      const index = this.products.findIndex((product) => product.id === id);
      if (index !== -1) {
        this.products[index].amount += 1;
        if (this.products[index].amount < 0) {
          this.products[index].amount = 0;
        }
      }
      this.cartProducts.push(product);
      this.cartList();
    }
  }
  

  clickaddFavs(id: number) {
    const product = this.products.find((product) => product.id === id);
    if (product) {
      this.favProducts.push(product);
    }
    this.cartList();
  }

  clickRemoveProduct(id: number) {
    const index = this.products.findIndex((prod) => prod.id === id);
    if (this.products[index].amount === 1) {
        this.products.splice(index, 1);
    } else {
        this.products[index].amount--;
    }
    this.cartList();
}


  cartList() {
    this.myCart.next(this.cartProducts);
  }
}
