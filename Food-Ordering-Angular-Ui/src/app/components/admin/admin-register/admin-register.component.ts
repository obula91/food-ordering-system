import { ANALYZE_FOR_ENTRY_COMPONENTS, Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Admin } from '../admin';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-admin-register',
  templateUrl: './admin-register.component.html',
  styleUrls: ['./admin-register.component.css']
})
export class AdminRegisterComponent implements OnInit {
  admin = new Admin();
  response='';
  constructor(private adminService:AdminService,private routerObj:Router) { }

  ngOnInit(): void {
  }

  registerAdmin(){
    let formCheck = this.admin;
    if(formCheck.admin_name && formCheck.admin_email && formCheck.admin_password){}
    this.adminService.registerAdminRest(this.admin).subscribe
    ({
      next: (response) => {
        console.log("Registered successfully");
         alert("Registered Successfully")
         this.routerObj.navigate(['admin/login']);
      },
      error: () => {
        console.log("Registered successfully");
         alert("Registered Successfully")
         this.routerObj.navigate(['admin/login']);
      }
    })
  }
    // this.routerObj.navigate(['admin/login']);

}
