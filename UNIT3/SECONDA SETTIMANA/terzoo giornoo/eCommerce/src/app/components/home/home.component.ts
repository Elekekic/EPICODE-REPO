import { Component, OnInit, OnDestroy } from '@angular/core';
import { Products, CartItem } from 'src/app/models/products';
import { Subscription } from 'rxjs';
import { ServiceService } from 'src/app/service/service.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit, OnDestroy {
  products: Products[] = [];
  cartItem: CartItem[] = []; 
  sub!: Subscription;


  constructor (private prodSrv: ServiceService) {}
  
  
  ngOnInit(): void {
    this.prodSrv.getProducts().subscribe(response => {
      this.products = response.products;
    });
  }

  clickAddCart(id: number) {
    this.prodSrv.clickAddCart(id)
    console.log( this.prodSrv.clickAddCart(id));
  }

  clickAddFavs(id: number) {
    this.prodSrv.clickaddFavs(id); 
    console.log(this.prodSrv.clickaddFavs(id));
  }
  
  
  ngOnDestroy(): void {
   this.sub.unsubscribe()
  }

}
