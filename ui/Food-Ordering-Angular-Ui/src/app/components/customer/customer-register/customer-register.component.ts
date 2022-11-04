import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-customer-register',
  templateUrl: './customer-register.component.html',
  styleUrls: ['./customer-register.component.css']
})
export class CustomerRegisterComponent implements OnInit {

@Input() profileHeader: any = 'Sign up : Customer';

 customer = new Customer();
  errorMessage:string='';
  constructor(private customerService:CustomerService, private routerObj:Router) { }

  ngOnInit(): void {
  }
    registerCustomer() {
    this.customerService.registerCustomerRest(this.customer).subscribe(
      data=>{
        console.log("User Logged in successfully");
        this.routerObj.navigate(['customer/login']);
      },
      error=>{
        console.log("User Logged in successfully");
        this.routerObj.navigate(['customer/login'], );
      }
    )
  }
}
