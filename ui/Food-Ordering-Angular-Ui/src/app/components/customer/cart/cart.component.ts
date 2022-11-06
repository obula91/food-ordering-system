import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { FoodService } from '../../food/food.service';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  isEmpty: boolean = true;
  totalPrice = 0;
  cartData: any = [];
  customerMail = localStorage.getItem('customerEmail');

  constructor(
    private customerService: CustomerService,
    private foodService: FoodService,
    private routerObj:Router,
  ) { }

  ngOnInit(): void {
    console.log(this.customerService.customerOrders, 'cart');
    this.cartData = this.customerService.customerOrders;
    this.cartData.forEach((item:any) => {
      this.totalPrice += item.price;
    })
  }

  deleteItemFromCart(selectedFood: any) {
    const indexofItem = this.cartData.indexOf(selectedFood);
    this.cartData.splice(indexofItem, 1);
    this.totalPrice = this.totalPrice - selectedFood.price;

  }

  placeOrder() {
    if (this.totalPrice == 0) {
      alert("please select at least one food item")
    }
    else {
      this.cartData.map((item: any) => {
        item.adminEmail = this.customerMail;
        item.status = 'In Progress';
      });
      this.foodService.getOrderItems(this.cartData).subscribe(
        (response: any) => {
          this.cartData = [];
          this.totalPrice = 0;
        }

      );
      console.log(this.customerMail, 'mail')
      alert("order Placed Successfully");
      console.log(this.cartData)

    }
  }

  viewProfile(){
    this.routerObj.navigate(['customer/profile']);
  }

  goToHome() {
    this.routerObj.navigate(['customer/home']);
  }


}
