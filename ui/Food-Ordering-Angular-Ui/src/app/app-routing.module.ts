import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminHomeComponent } from './components/admin/admin-home/admin-home.component';
import { AdminLoginComponent } from './components/admin/admin-login/admin-login.component';
import { AdminRegisterComponent } from './components/admin/admin-register/admin-register.component';
import { OrdernotificationComponent } from './components/admin/ordernotification/ordernotification.component';
import { CartComponent } from './components/customer/cart/cart.component';
import { CustomerHomeComponent } from './components/customer/customer-home/customer-home.component';
import { CustomerLoginComponent } from './components/customer/customer-login/customer-login.component';
import { CustomerRegisterComponent } from './components/customer/customer-register/customer-register.component';
import { ProfileComponent } from './components/customer/profile/profile.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { MenuItemsComponent } from './components/menu/menu-items/menu-items.component';

const routes: Routes = [
  
  {path:'home/',component:HomePageComponent},
  {path:'admin/login',component:AdminLoginComponent},
  {path:'admin/register',component:AdminRegisterComponent},
  {path:'admin/home',component:AdminHomeComponent},
  {path:'customer/login',component:CustomerLoginComponent},
  {path:'customer/home',component:CustomerHomeComponent},
  {path:'customer/register',component:CustomerRegisterComponent},
  {path:'menus/',component:MenuItemsComponent},
  {path:'customer/profile',component:ProfileComponent},
  {path: 'customer/cart', component: CartComponent},
  {path: 'admin/ordernotification', component:OrdernotificationComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
