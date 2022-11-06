import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerService } from '../../customer/customer.service';

@Component({
  selector: 'app-ordernotification',
  templateUrl: './ordernotification.component.html',
  styleUrls: ['./ordernotification.component.css']
})
export class OrdernotificationComponent implements OnInit {

  customerOrderHistory:any = [];
  constructor(private routerObj:Router,
    private customerService:CustomerService) { }

  ngOnInit(): void {
    this.getOrderHistoryItems();
  }

  getOrderHistoryItems() {
    this.customerService.getCustomerOrderItems().subscribe(
      (response:any) => {
        this.customerOrderHistory = response;
      }
    )
  }

  goToHome() {
    this.routerObj.navigate(['admin/home']);
  }

  orderStatus(status:string, item:any) {
    item.status = status;
    let index = this.customerOrderHistory.indexOf(item);
    this.customerService.acceptRejectOrders(item).subscribe((response:any) => {
      //Updating order status
    })
    this.customerOrderHistory.splice(index,1);
  }


}
