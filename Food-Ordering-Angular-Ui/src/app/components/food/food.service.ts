import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class FoodService {
  getFoodItems() {
    return this.httpClient.get("http://localhost:8080/customer/foodItems")
  }

  saveOrder(){
    //this.httpClient.post()
  }

  constructor(private httpClient:HttpClient) { }
}
