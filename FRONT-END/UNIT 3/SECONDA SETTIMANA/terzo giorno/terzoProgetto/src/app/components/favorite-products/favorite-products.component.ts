import { Component,OnInit } from '@angular/core';
import { ServiceService } from 'src/app/service/service.service';
import { Products } from 'src/app/models/products';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-favorite-products',
  templateUrl: './favorite-products.component.html',
  styleUrls: ['./favorite-products.component.scss']
})
export class FavoriteProductsComponent implements OnInit {
  products: Products[] = [];
  sub!: Subscription;


  constructor(private productsSrv: ServiceService) {}

  ngOnInit(): void {
    this.infoProducts();
  }

  infoProducts() {
    this.sub = this.productsSrv.getProducts().subscribe((products) => {
      this.products = products.products;
    });
  }


}
