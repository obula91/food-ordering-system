import { Component, OnInit } from '@angular/core';
import { Food } from '../food';
import { FoodService } from '../food.service';

@Component({
  selector: 'app-food-items',
  templateUrl: './food-items.component.html',
  styleUrls: ['./food-items.component.css']
})
export class FoodItemsComponent implements OnInit {

  foodItems:Array<Food>=[];
  foodCart:Array<Food> = [];
  food = new Food();
  isEmpty:boolean=false;
  deleteMessage:string='';
  totalPrice : number=0;
  customerMail = localStorage.getItem('customerEmail');
  constructor(private foodService:FoodService) { }

  ngOnInit(): void {
    this.foodService.getFoodItems().subscribe(
      (response: any) => this.handleSuccessfulResponse(response)
      
    );
     
  }
  handleSuccessfulResponse(response: any) { 
    this.foodItems = response;
    console.log(this.foodItems)
  }

  addToCart(selectedFood:Food) {
   
    this.foodCart.push(selectedFood);
    this.totalPrice = this.totalPrice + selectedFood.price;
    this.isEmpty=true;
    console.log(selectedFood)
    alert(selectedFood.food_name + ' added to cart');
  }
  deleteItemFromCart(selectedFood:Food){
      const indexofItem = this.foodCart.indexOf(selectedFood);
      this.foodCart.splice(indexofItem);
      this.totalPrice = this.totalPrice- selectedFood.price;
      
  }

  placeOrder(){
    if(this.totalPrice == 0)
    {
      alert("please select at least one food item")
    }
    else{
      this.foodCart.map(item => {
        item.customerMail = this.customerMail;
      });
      this.foodService.getOrderItems(this.foodCart).subscribe(
        (response: any) => {
          this.foodCart = [];
          this.totalPrice = 0;
        }
        
      );
      console.log(this.customerMail, 'mail')
      alert("order Places Successfully");
    // this.foodCart = [];
    // this.totalPrice = 0;
    console.log(this.foodCart)

    }
      }
  
}
