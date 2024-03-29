import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Products } from '../models/products';



@Injectable({
  providedIn: 'root'
})
export class ServiceService {
  apiURL = 'https://dummyjson.com/products'; 
  products: Products[] = []; 
  cartProducts: Products[] = [];


  constructor(private http: HttpClient) { }


  getProducts() {
    return  this.http.get<{products: Products[]}>(this.apiURL);
  }

  ClickAddCart(id: number) {
    const product = this.products.find((product) => product.id === id);
    if (product) {
      this.cartProducts.push(product);
    }
  }

  

}
