import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';

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

  public getOrderItems(OrderItems:any):Observable<any>{
    return this.httpClient.post<any>("http://localhost:8080/orderItem/order",OrderItems);
  }

  constructor(private httpClient:HttpClient) { }
}
